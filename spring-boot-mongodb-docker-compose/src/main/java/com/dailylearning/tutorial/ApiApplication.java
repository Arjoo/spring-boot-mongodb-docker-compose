package com.dailylearning.tutorial;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class ApiApplication {

	@Value("${app.ui.host.cors.uri_1}")
	private String uiHostUrl_1;

	@Value("${app.ui.host.cors.uri_2}")
	private String uiHostUrl_2;

	public static void main(String[] args) throws IOException, CsvException {
		SpringApplication.run(ApiApplication.class, args);


	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/dailylearning/*").allowedOrigins(uiHostUrl_1, uiHostUrl_2);
			}
		};
	}

}
