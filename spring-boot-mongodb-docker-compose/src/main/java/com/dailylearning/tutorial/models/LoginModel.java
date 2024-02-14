package com.dailylearning.tutorial.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class LoginModel {
    @Id
    private String email;
    private String password;
}
