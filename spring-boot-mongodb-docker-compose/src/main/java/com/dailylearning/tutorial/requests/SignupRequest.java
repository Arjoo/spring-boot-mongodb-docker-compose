package com.dailylearning.tutorial.requests;

import com.dailylearning.tutorial.models.SignupModel;
import lombok.Data;

@Data
public class SignupRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String confirmPassword;

    public SignupModel toSignupModel() {
        return SignupModel.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .userName(this.userName)
                .email(this.email)
                .password(this.password)
                .confirmPassword(this.confirmPassword)
                .build();
    }
}
