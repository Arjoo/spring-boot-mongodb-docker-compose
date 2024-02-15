package com.dailylearning.tutorial.repositories;

import com.dailylearning.tutorial.models.UserModel;
import com.dailylearning.tutorial.models.SignupModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<SignupModel, String> {
    @Query("{email:?0}")
    public UserModel findByEmail(String email);

    @Query("{'email' : ?0}")
    @Update("{'$set': {'password': ?1, 'confirmPassword': ?2}}")
    Integer forgotPassword(String email, String password, String confirmPassword);
}
