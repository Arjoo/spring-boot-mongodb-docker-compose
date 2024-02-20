package com.dailylearning.tutorial.models;

import lombok.Builder;
import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "images_upload")
@Data
@Builder
public class Image {
    @Id
    private String id;
    private String name;
    private String type;
    private String email;
    private byte[] imageData;

}