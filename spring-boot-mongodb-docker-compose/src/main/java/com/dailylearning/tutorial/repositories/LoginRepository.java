package com.dailylearning.tutorial.repositories;

import com.dailylearning.tutorial.models.LoginModel;
import com.dailylearning.tutorial.models.SignupModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface LoginRepository extends MongoRepository<SignupModel, String> {
    @Query("{email:?0}")
    public LoginModel findByEmail(String email);
}
