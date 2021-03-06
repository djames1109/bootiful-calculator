package com.hachichu.bootifulcalculator.controller;

import com.hachichu.bootifulcalculator.dto.CalculateRequest;
import com.hachichu.bootifulcalculator.dto.CalculateResponse;
import com.hachichu.bootifulcalculator.service.AbstractBootifulCalculatorProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by djames
 * 06/03/2021  5:20 PM
 */
@Slf4j
@RequestMapping("/bootiful-calculator")
@RestController
public class BootifulCalculatorController {

    private final AbstractBootifulCalculatorProcessor processor;

    public BootifulCalculatorController(AbstractBootifulCalculatorProcessor processor) {
        this.processor = processor;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculateResponse> calculate(@RequestBody CalculateRequest request) {
        log.info("Request: {}", request);
        return ResponseEntity.ok(processor.calculate(request));
    }
}
