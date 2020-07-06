package de.telran;

<<<<<<< HEAD
import de.telran.entity.ActionableImage;
import de.telran.entity.ImageDescriptor;
import de.telran.factory.ImageActionFactory;
import de.telran.service.*;
=======
import de.telran.entity.DownloadedImage;
import de.telran.entity.ImageDescriptor;
import de.telran.service.DownloadService;
import de.telran.service.FileService;
import de.telran.service.ImageDescriptorService;
>>>>>>> e0e0efc806f0f30bcf76acfece8abfc8f9a8b758

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private ConfigService configService;
    private ImageDescriptorService imageDescriptorService;
    private DownloadService downloadService;
<<<<<<< HEAD
    private ImageService imageService;
    private ImageFileService imageFileService;
    private CsvFileService csvFileService;


    public ImageProcessor(ImageDescriptorService imageDescriptorService,
                          DownloadService downloadService,
                          ImageService imageService,
                          ImageFileService imageFileService,CsvFileService csvFileService,
                          ConfigService configService) {
        this.imageDescriptorService = imageDescriptorService;
        this.downloadService = downloadService;
        this.imageService = imageService;
        this.imageFileService = imageFileService;
        this.csvFileService = csvFileService;
        this.configService = configService;
=======
    private FileService fileService;
    //private DownloadService downloadService;
    //private ImageService imageService;
    //....

    public ImageProcessor(ImageDescriptorService imageDescriptorService,
                          DownloadService downloadService,
                          FileService fileService) {
        this.imageDescriptorService = imageDescriptorService;
        this.downloadService = downloadService;
        this.fileService = fileService;
>>>>>>> e0e0efc806f0f30bcf76acfece8abfc8f9a8b758
    }

    public void doProcessing(String fileName) {

        List<ImageDescriptor> imageDescriptors = imageDescriptorService.getImageDescriptors(fileName);

<<<<<<< HEAD
        List<ActionableImage> actionableImages = imageDescriptors
                .stream()
                .map(i -> new ActionableImage(null, false, i.getImageUrlName(), i.getActionName()))
                .collect(Collectors.toList());

        List<ActionableImage> downloadedImages = downloadService.downloadImages(actionableImages);

        List<ActionableImage> successfullyDownloadedImages = downloadedImages.stream()
                .filter(ActionableImage::isSuccessful)
                .collect(Collectors.toList());
=======
        List<String> urls = imageDescriptors.stream().map(d -> d.getImageUrlName()).collect(Collectors.toList());

        List<DownloadedImage> downloadedImages = downloadService.downloadImages(urls);

        List<BufferedImage> successfullyDownloadedImages = downloadedImages.stream()
                .filter(DownloadedImage::isSuccessfull)
                .map(DownloadedImage::getImage)
                .collect(Collectors.toList());

        successfullyDownloadedImages.forEach(i -> fileService.saveImageAsFile(i));

>>>>>>> e0e0efc806f0f30bcf76acfece8abfc8f9a8b758

        List<ActionableImage> processedImages = successfullyDownloadedImages
                .stream()
                .map(i -> imageService.processImage(i))
                .collect(Collectors.toList());

        processedImages.forEach(i -> imageFileService.saveImageAsFile(i));

    }


    public static void main(String[] args) throws Exception {

        String fileName = args[0];
        ConfigService configService = new ConfigService();
        ImageFileService imageFileService = new ImageFileService(configService);
        CsvFileService csvFileService = new CsvFileService();

        ImageDescriptorService imageDescriptorService = new ImageDescriptorService(csvFileService,configService);

        DownloadService downloadService = new DownloadService();

        ImageService imageService = new ImageService(new ImageActionFactory(new ActionsConfigService()));

<<<<<<< HEAD
        ImageProcessor processor = new ImageProcessor(imageDescriptorService, downloadService, imageService, imageFileService,csvFileService,
                configService);
=======
        DownloadService downloadService = new DownloadService();

        ImageProcessor processor = new ImageProcessor(imageDescriptorService, downloadService, fileService);
>>>>>>> e0e0efc806f0f30bcf76acfece8abfc8f9a8b758

        processor.doProcessing(fileName);

    }
}