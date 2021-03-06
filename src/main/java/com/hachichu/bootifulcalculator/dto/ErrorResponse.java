package com.hachichu.bootifulcalculator.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by djames
 * 06/03/2021  11:14 PM
 */
@Data
@Builder
public class ErrorResponse {
    private String error;
}
