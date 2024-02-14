package com.dailylearning.tutorial.services;

import com.dailylearning.tutorial.models.FruitModel;
import com.dailylearning.tutorial.repositories.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public FruitModel saveFruit(FruitModel fruitModel) {
        return fruitRepository.save(fruitModel);
    }

    public List<FruitModel> findAll() {
        return fruitRepository.findAll();
    }

    public void deleteAll() {
        fruitRepository.deleteAll();
    }
}
