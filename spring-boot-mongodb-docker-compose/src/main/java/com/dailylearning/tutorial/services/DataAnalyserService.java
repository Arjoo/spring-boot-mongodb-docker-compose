package com.dailylearning.tutorial.services;

import com.dailylearning.tutorial.models.SalesDataModel;
import com.dailylearning.tutorial.repositories.DataAnalyserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Service
public class DataAnalyserService {
    @Autowired
    private DataAnalyserRepository dataAnalyserRepository;

    public Map<String, Long>  findAll(String key) {
        List<SalesDataModel> all = dataAnalyserRepository.findAll();
        Map<String, Long> collect = new HashMap<>();
        switch (key) {
            case "city":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getCity).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;

            case "branch":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getBranch).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;
            case "customerType":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getCustomerType).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                    break;
            case "gender":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getGender).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;
            /*case "productLine":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getProductLine).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;
            case "unitPrice":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getUnitPrice).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;
            case "quantity":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getQuantity).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;
            case "tax":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getTax).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;
            case "total":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getTotal).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;
            case "date":
                collect = all.stream().filter(data -> data != null)
                        .map(SalesDataModel::getDate).collect(Collectors.groupingBy(identity(), Collectors.counting()));
                break;*/
            default:
        }
        return collect;
    }
}
