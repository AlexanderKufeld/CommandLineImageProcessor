package de.telran.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileService {
    public List<String> loadStringsFromFile(String fileName) {
        try {
            return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return Collections.EMPTY_LIST;
        }
    }
<<<<<<< HEAD:src/main/java/de/telran/service/CsvFileService.java
=======

    public void saveImageAsFile(BufferedImage image) {

        try {
            ImageIO.write(image, "jpg",new File("/Users/slukichev/Downloads/images/img_"+image.hashCode()+".jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
>>>>>>> e0e0efc806f0f30bcf76acfece8abfc8f9a8b758:src/main/java/de/telran/service/FileService.java
}