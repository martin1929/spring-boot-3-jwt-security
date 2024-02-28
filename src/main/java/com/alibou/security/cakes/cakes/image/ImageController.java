package com.alibou.security.cakes.cakes.image;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/cakeImage")

public class ImageController {
    private final CakeImageService cakeImageService;

    public ImageController(CakeImageService cakeImageService) {
        this.cakeImageService = cakeImageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
    return cakeImageService.saveImageInDb(file);
    }


    @GetMapping("/getImage/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        return cakeImageService.getImageFromDb(imageName);
    }
}
