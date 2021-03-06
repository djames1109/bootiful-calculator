package com.hachichu.bootifulcalculator.controller;

import com.hachichu.bootifulcalculator.dto.CalculateRequest;
import com.hachichu.bootifulcalculator.dto.CalculateResponse;
import com.hachichu.bootifulcalculator.service.AbstractBootifulCalculatorProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by djames
 * 06/03/2021  5:20 PM
 */
@RequestMapping("/bootiful-calculator")
@RestController
public class BootifulCalculatorController {

    private final AbstractBootifulCalculatorProcessor processor;

    public BootifulCalculatorController(AbstractBootifulCalculatorProcessor processor) {
        this.processor = processor;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculateResponse> calculate(CalculateRequest request) {
        return ResponseEntity.ok(processor.calculate(request));
    }
}
