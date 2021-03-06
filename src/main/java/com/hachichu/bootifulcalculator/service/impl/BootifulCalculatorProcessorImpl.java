package com.hachichu.bootifulcalculator.service.impl;

import com.hachichu.bootifulcalculator.dto.CalculateRequest;
import com.hachichu.bootifulcalculator.dto.CalculateResponse;
import com.hachichu.bootifulcalculator.enums.Type;
import com.hachichu.bootifulcalculator.service.AbstractBootifulCalculatorProcessor;
import com.hachichu.bootifulcalculator.utils.CalculateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by djames
 * 06/03/2021  5:30 PM
 */
@Service
public class BootifulCalculatorProcessorImpl extends AbstractBootifulCalculatorProcessor {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        if (request.getType().equals(Type.INTEGER)) {
            BigInteger[] values = Arrays.copyOf(
                    Arrays.stream(request.getValues()).map(BigDecimal::toBigInteger).toArray(),
                    request.getValues().length, BigInteger[].class);

            BigInteger result = CalculateUtil.process(values, request.getOperation().getIntegerOperator());
            return CalculateResponse.builder()
                    .result(result)
                    .build();
        }

        BigDecimal result = CalculateUtil.process(request.getValues(), request.getOperation().getDecimalOperator());
        return CalculateResponse.builder()
                .result(result)
                .build();
    }
}
