package com.dailylearning.tutorial.services;

import com.dailylearning.tutorial.models.ForgotModel;
import com.dailylearning.tutorial.models.UserModel;
import com.dailylearning.tutorial.models.SignupModel;
import com.dailylearning.tutorial.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean saveUser(SignupModel signupModel) {
        if(!StringUtils.equals(signupModel.getPassword(), signupModel.getConfirmPassword())) {
            return Boolean.FALSE;
        }

        UserModel byEmail = userRepository.findByEmail(signupModel.getEmail());
        if(byEmail == null) {
            userRepository.save(signupModel);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    public boolean login(UserModel toLoginModel) {
        UserModel userModel = userRepository.findByEmail(toLoginModel.getEmail());
        if(userModel == null) {
            return Boolean.FALSE;
        }
        if(StringUtils.equals(userModel.getPassword(), toLoginModel.getPassword())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public boolean updatePassword(ForgotModel toForgotModel) {
        UserModel userModel = userRepository.findByEmail(toForgotModel.getEmail());
        if(userModel == null ||
                !StringUtils.equals(toForgotModel.getPassword(), toForgotModel.getConfirmPassword())) {
            return  Boolean.FALSE;
        }
        userRepository.forgotPassword(toForgotModel.getEmail(), toForgotModel.getPassword(), toForgotModel.getConfirmPassword());
        return Boolean.TRUE;
    }
}
