package com.dailylearning.tutorial.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupResponse {
    private String resMessage;
}
