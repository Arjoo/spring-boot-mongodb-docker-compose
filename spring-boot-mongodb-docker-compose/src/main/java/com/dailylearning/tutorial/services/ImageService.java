package com.dailylearning.tutorial.services;

import com.dailylearning.tutorial.models.Image;
import com.dailylearning.tutorial.repositories.ImageRepository;
import com.dailylearning.tutorial.utils.ImageUtils;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(String email, MultipartFile file) throws IOException {

        Image imageData = imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .email(email)
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return "Error in file uploaded";
    }

    public byte[] downloadImage(String email, String imageName) {
        Optional<Image> dbImageData = imageRepository.findByEmail(email, imageName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
