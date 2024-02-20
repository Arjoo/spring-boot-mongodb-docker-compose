package com.dailylearning.tutorial.repositories;

import com.dailylearning.tutorial.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ImageRepository extends MongoRepository<Image, String> {

    @Query("{$and :[{email: ?0},{name: ?1}] }")
    Optional<Image> findByEmail(String email, String imageName);
}
