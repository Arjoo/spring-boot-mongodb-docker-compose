package com.dailylearning.tutorial.services;

import com.dailylearning.tutorial.models.LoginModel;
import com.dailylearning.tutorial.models.SignupModel;
import com.dailylearning.tutorial.repositories.LoginRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean saveUser(SignupModel signupModel) {
        if(!StringUtils.equals(signupModel.getPassword(), signupModel.getConfirmPassword())) {
            return Boolean.FALSE;
        }

        LoginModel byEmail = loginRepository.findByEmail(signupModel.getEmail());
        if(byEmail == null) {
            loginRepository.save(signupModel);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    public boolean findByEmail(LoginModel toLoginModel) {
        LoginModel loginModel = loginRepository.findByEmail(toLoginModel.getEmail());
        if(loginModel == null) {
            return Boolean.FALSE;
        }
        if(StringUtils.equals(loginModel.getPassword(), toLoginModel.getPassword())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
