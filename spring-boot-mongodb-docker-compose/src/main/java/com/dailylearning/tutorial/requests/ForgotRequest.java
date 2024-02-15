package com.dailylearning.tutorial.requests;

import com.dailylearning.tutorial.models.ForgotModel;
import lombok.Data;

@Data
public class ForgotRequest {

    private String email;
    private String password;
    private String confirmPassword;

    public ForgotModel toForgotModel() {
        return ForgotModel.builder()
                .email(this.email)
                .password(this.password)
                .confirmPassword(this.confirmPassword)
                .build();
    }
}
