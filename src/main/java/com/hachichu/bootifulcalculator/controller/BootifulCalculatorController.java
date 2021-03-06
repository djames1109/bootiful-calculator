package com.hachichu.bootifulcalculator.controller;

import com.hachichu.bootifulcalculator.dto.CalculateRequest;
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

    @PostMapping("/calculate")
    public ResponseEntity<Object> calculate(CalculateRequest request) {
        return null;
    }
}
