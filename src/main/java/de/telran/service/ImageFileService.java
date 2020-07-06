package de.telran.service;

import de.telran.entity.ActionableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ImageFileService {

    private ConfigService configService;
    private CreationImageNameService creationImageNameService = new CreationImageNameService();

    public ImageFileService(ConfigService configService){
        this.configService = configService;
    }

    public void saveImageAsFile(ActionableImage image) {
        try {
            ImageIO.write(image.getImage(), "jpg",new File(configService.getPathToSavedImages()
                    + creationImageNameService.getImageName(image))); //image.hashCode()+ ".jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
