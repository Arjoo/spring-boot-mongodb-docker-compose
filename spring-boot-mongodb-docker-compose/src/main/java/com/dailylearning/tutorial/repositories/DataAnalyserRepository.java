package com.dailylearning.tutorial.repositories;

import com.dailylearning.tutorial.models.SalesDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DataAnalyserRepository extends MongoRepository<SalesDataModel, String>{


    @Query("{'invoiceId' : ?0}")
    SalesDataModel findByInvoiceId(String key);

    @Query("{'branch' : ?0}")
    List<SalesDataModel> findByBranch(String key);

    @Query("{'city':?0}")
    List<SalesDataModel> findByCity(String key);
}
