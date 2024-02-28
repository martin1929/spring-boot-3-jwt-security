package com.alibou.security.cakes.cakes.image;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CakeImageService {
    public ResponseEntity<byte[]> getImageFromDb(String imageName) {
        try {
            String filePath="C:\\Users\\martin_martirosyan\\IdeaProjects\\images\\cakes\\";
            File file = new File( filePath+ imageName);
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            byte[] bytes = outputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> saveImageInDb(MultipartFile file) {
        try {
            String filePath = "C:\\Users\\martin_martirosyan\\IdeaProjects\\images\\cakes\\";
            File folder = new File(filePath);
            if (isFolderExists(folder)) {
                folder.mkdirs();
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder + "\\" + file.getOriginalFilename());
            Files.write(path, bytes);
            return new ResponseEntity<>("Image is uploaded", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving image: " + e.getMessage()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isFolderExists(File folder) {
        return !folder.exists();
    }
}
