package com.dailylearning.tutorial.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@Builder
@Document
public class SalesDataModel {

    private String invoiceId;
    private String branch;
    private String city;
    private String customerType;
    private String gender;
    private String productLine;
    private double unitPrice;
    private double quantity;
    private double tax;
    private String total;
    private String date;
    private String time;
    private String payment;
    private double cogs;
    private double grossMarginPercentage;
    private double grossIncome;
    private double rating;

}
