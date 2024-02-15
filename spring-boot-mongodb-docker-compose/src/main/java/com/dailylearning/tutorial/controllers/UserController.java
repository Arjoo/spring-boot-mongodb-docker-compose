package com.dailylearning.tutorial.controllers;

import com.dailylearning.tutorial.requests.ForgotRequest;
import com.dailylearning.tutorial.requests.LoginRequest;
import com.dailylearning.tutorial.requests.SignupRequest;
import com.dailylearning.tutorial.responses.UserResponse;
import com.dailylearning.tutorial.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserResponse addUser(@RequestBody SignupRequest signupRequest) {
        log.info("Request : {}", signupRequest);
        boolean find = userService.saveUser(signupRequest.toSignupModel());
        String resMessage = find ? "User Created" : "User Already exists";
        return UserResponse.builder().resMessage(resMessage).build();
    }

    @PutMapping("/forgot")
    public UserResponse updatePassword(@RequestBody ForgotRequest forgotRequest) {
        log.info("Request : {}", forgotRequest);
        boolean find = userService.updatePassword(forgotRequest.toForgotModel());
        String resMessage = find ? "Password updated" : "Wrong username or password";
        return UserResponse.builder().resMessage(resMessage).build();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest loginRequest) {
        boolean isFind = userService.login(loginRequest.toLoginModel());
        log.info("Request : {}", isFind);
        return isFind;
    }
}
