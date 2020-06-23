package de.telran.entity;

import java.awt.image.BufferedImage;

<<<<<<< HEAD
public class DownloadedImage {
    private BufferedImage image;
    private boolean isSuccessfull;
    private ImageDescriptor imageDescriptor;

    public DownloadedImage(BufferedImage image, boolean status, ImageDescriptor imageDescriptor) {
        this.image = image;
        this.isSuccessfull = status;
        this.imageDescriptor = imageDescriptor;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public ImageDescriptor getImageDescriptor() {
        return imageDescriptor;
    }
}
=======
    public class DownloadedImage {
        private BufferedImage image;
        private boolean isSuccessfull;

        public DownloadedImage(BufferedImage image, boolean status) {
            this.image = image;
            this.isSuccessfull = status;
        }

        public BufferedImage getImage() {
            return image;
        }

        public boolean isSuccessfull() {
            return isSuccessfull;
        }
    }

>>>>>>> downloadservice and added test_file
