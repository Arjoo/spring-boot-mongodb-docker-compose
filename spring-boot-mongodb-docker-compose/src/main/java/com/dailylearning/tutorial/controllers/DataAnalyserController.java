package com.dailylearning.tutorial.controllers;

import com.dailylearning.tutorial.models.SalesDataModel;
import com.dailylearning.tutorial.requests.SignupRequest;
import com.dailylearning.tutorial.responses.UserResponse;
import com.dailylearning.tutorial.services.DataAnalyserService;
import com.dailylearning.tutorial.utils.FileReaderUtils;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.*;

@Slf4j
@RestController
@RequestMapping(value = "/dailylearning")
public class DataAnalyserController {

    @Autowired
    private DataAnalyserService dataAnalyserService;

    @GetMapping(value = "/analyze/{key}")
    public Map<String, Long> analyze(@PathVariable String key) {
        log.info("{}", key);
        Map<String, Long> all = dataAnalyserService.findAll(key);
        return all;
    }
}
