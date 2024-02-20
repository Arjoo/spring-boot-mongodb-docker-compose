package com.dailylearning.tutorial.controllers;

import com.dailylearning.tutorial.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(value = "/dailylearning")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/user/image")
    public String uploadImage(@RequestParam("email") String email,
                            @RequestParam("image") MultipartFile image) {
        try {
            return imageService.uploadImage(email, image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/photo")
    public ResponseEntity<?> downloadImage(@RequestParam("email") String email,
                                           @RequestParam("imageName") String imageName){
        byte[] bytes = imageService.downloadImage(email, imageName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(bytes);
    }
}
