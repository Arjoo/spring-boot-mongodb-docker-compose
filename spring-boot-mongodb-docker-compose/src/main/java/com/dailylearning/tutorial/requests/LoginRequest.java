package com.dailylearning.tutorial.requests;

import com.dailylearning.tutorial.models.UserModel;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    public UserModel toLoginModel() {
        return UserModel.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}
