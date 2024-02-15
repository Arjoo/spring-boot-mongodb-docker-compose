package com.dailylearning.tutorial.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class ForgotModel {

    private String email;
    private String password;
    private String confirmPassword;

}
