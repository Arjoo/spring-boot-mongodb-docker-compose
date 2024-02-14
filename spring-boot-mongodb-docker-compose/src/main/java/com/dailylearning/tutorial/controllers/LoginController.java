package com.dailylearning.tutorial.controllers;

import com.dailylearning.tutorial.requests.LoginRequest;
import com.dailylearning.tutorial.requests.SignupRequest;
import com.dailylearning.tutorial.responses.SignupResponse;
import com.dailylearning.tutorial.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/create")
    public SignupResponse addUser(@RequestBody SignupRequest signupRequest) {
        log.info("Request : {}", signupRequest);
        boolean find = loginService.saveUser(signupRequest.toSignupModel());
        String resMessage = find ? "User Created" : "User Already exists";
        return SignupResponse.builder().resMessage(resMessage).build();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest loginRequest) {
        boolean isFind = loginService.findByEmail(loginRequest.toLoginModel());
        log.info("Request : {}", isFind);
        return isFind;
    }
}
