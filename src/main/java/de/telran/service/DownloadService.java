package de.telran.service;

<<<<<<< HEAD
import de.telran.entity.ActionableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadService {
    public List<ActionableImage> downloadImages(List<ActionableImage> images) {
        List<ActionableImage> imageList = new ArrayList<>(images);
        for(ActionableImage actionableImage:images) {
            try {
                URL url = new URL(actionableImage.getSourceUrl());
                BufferedImage image = ImageIO.read(url);
                actionableImage.setImage(image);
                actionableImage.setSuccessful(true);
            } catch (Exception ex) {
                System.err.println(actionableImage.getSourceUrl());
                System.err.println(ex.getMessage());
                actionableImage.setSuccessful(false);
            }
        }
        return imageList;
    }
}
=======

import de.telran.entity.DownloadedImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    public class DownloadService {
        public List<DownloadedImage> downloadImages(List<String> imageUrls) {
            List<DownloadedImage> imageList = new ArrayList<>();
            for(String urlName:imageUrls) {
                try {
                    URL url = new URL(urlName);
                    BufferedImage image = ImageIO.read(url);
                    imageList.add(new DownloadedImage(image, true));
                } catch (Exception ex) {
                    System.err.println(urlName);
                    System.err.println(ex.getMessage());
                    imageList.add(new DownloadedImage(null, false));
                }
            }
            return imageList;
        }
    }

>>>>>>> e0e0efc806f0f30bcf76acfece8abfc8f9a8b758
