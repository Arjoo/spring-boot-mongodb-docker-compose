package com.dailylearning.tutorial.requests;

import com.dailylearning.tutorial.models.LoginModel;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    public LoginModel toLoginModel() {
        return LoginModel.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}
