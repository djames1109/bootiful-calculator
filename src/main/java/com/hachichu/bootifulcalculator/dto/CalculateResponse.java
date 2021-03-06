package com.hachichu.bootifulcalculator.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by djames
 * 06/03/2021  5:30 PM
 */
@Data
@Builder
public class CalculateResponse {

    private Number result;
}
