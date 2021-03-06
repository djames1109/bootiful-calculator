package com.hachichu.bootifulcalculator.service;

import com.hachichu.bootifulcalculator.dto.CalculateRequest;
import com.hachichu.bootifulcalculator.dto.CalculateResponse;

/**
 * Created by djames
 * 06/03/2021  5:28 PM
 */
public abstract class AbstractBootifulCalculatorProcessor {

    public abstract CalculateResponse calculate(CalculateRequest request);
}
