import de.telran.ImageProcessor;
import de.telran.entity.ActionableImage;
import de.telran.entity.DownloadedImage;
import de.telran.entity.ImageDescriptor;
import de.telran.service.DownloadService;

import de.telran.service.ImageDescriptorService;
import de.telran.service.ImageService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ImageProcessorTest {

    ImageDescriptorService imageDescriptorService = mock(ImageDescriptorService.class);
    ActionableImage actionableImage = mock(ActionableImage.class);
    DownloadService downloadService = mock(DownloadService.class);
    ImageService imageService = mock(ImageService.class);


    ImageProcessor processor;


    @Test
    public void testDoProcessing() {
        //configure mock
        List<ImageDescriptor> testImageDescriptors = createTestImageDescriptors();
        List<ActionableImage> testActionableImages = createActionableImage();
        when(imageDescriptorService.getImageDescriptors(any())).thenReturn(testImageDescriptors);
//        when(downloadService.downloadImages(any())).thenReturn(testActionableImages);
        when(downloadService.downloadImages(any())).thenReturn(testActionableImages);

        //execute test method
        processor.doProcessing("test.txt");



    }
    private static List<ActionableImage> createActionableImage(){
        return  Arrays.asList(
                new ActionableImage(null, true, "http://server.com/image1.jpg", "PREVIEW"),
                new ActionableImage(null, true, "http://server.com/image2.jpg", "THUMBNAIL")
        );
    }


    private static List<DownloadedImage> createDownloadedImage() {
        return Arrays.asList(
                new DownloadedImage(null, true, new ImageDescriptor("http://server.com/image1.jpg", "PREVIEW")),
                new DownloadedImage(null, true, new ImageDescriptor("http://server.com/image2.jpg", "THUMBNAIL"))
        );
    }

    private static List<ImageDescriptor> createTestImageDescriptors() {
        return Arrays.asList(
                new ImageDescriptor("http://server.com/image1.jpg", "PREVIEW"),
                new ImageDescriptor("http://server.com/image2.jpg", "THUMBNAIL"));
    }
}