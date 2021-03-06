package com.hachichu.bootifulcalculator.service.impl;

import com.hachichu.bootifulcalculator.dto.CalculateRequest;
import com.hachichu.bootifulcalculator.dto.CalculateResponse;
import com.hachichu.bootifulcalculator.service.AbstractBootifulCalculatorProcessor;
import com.hachichu.bootifulcalculator.enums.Type;
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
        int length = request.getValues().length;

        if (request.getType().equals(Type.INTEGER)) {
            BigInteger result = CalculateUtil.process(Arrays.copyOf(request.getValues(), length, BigInteger[].class),
                    request.getOperation().getIntegerOperator());

            return CalculateResponse.builder()
                    .result(result)
                    .build();
        }

        BigDecimal result = CalculateUtil.process(Arrays.copyOf(request.getValues(), length, BigDecimal[].class),
                request.getOperation().getDecimalOperator());
        return CalculateResponse.builder()
                .result(result)
                .build();
    }
}
