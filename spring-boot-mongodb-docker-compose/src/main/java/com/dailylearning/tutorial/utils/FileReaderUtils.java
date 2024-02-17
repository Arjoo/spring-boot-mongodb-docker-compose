package com.dailylearning.tutorial.utils;

import com.dailylearning.tutorial.models.SalesDataModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class FileReaderUtils {

    public List<SalesDataModel> readFile(String absoluteFilePath) throws IOException, CsvException {
        List<SalesDataModel> salesData;
        try (CSVReader reader = new CSVReader(new FileReader(absoluteFilePath))) {
            AtomicInteger count = new AtomicInteger();
            salesData = reader.readAll().stream().map(data -> {
                if (count.get() == 0) {
                    count.getAndIncrement();
                    return null;
                }
                return SalesDataModel.builder()
                        .invoiceId(data[0])
                        .branch(data[1])
                        .city(data[2])
                        .customerType(data[3])
                        .gender(data[4])
                        .productLine(data[5])
                        .unitPrice(Double.parseDouble(data[6]))
                        .quantity(Double.parseDouble(data[7]))
                        .tax(Double.parseDouble(data[8]))
                        .total(data[9])
                        .date(data[10])
                        .time(data[11])
                        .payment(data[12])
                        .cogs(Double.parseDouble(data[13]))
                        .grossMarginPercentage(Double.parseDouble(data[14]))
                        .grossIncome(Double.parseDouble(data[15]))
                        .rating(Double.parseDouble(data[16]))
                        .build();
                }).collect(Collectors.toList());

        } finally {

        }
        return salesData;
    }
}
