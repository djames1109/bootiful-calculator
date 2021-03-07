package com.hachichu.bootifulcalculator.constraints.validators;

import com.hachichu.bootifulcalculator.constraints.NotDivisionByZero;
import com.hachichu.bootifulcalculator.dto.CalculateRequest;
import com.hachichu.bootifulcalculator.enums.Operation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by djames
 * 07/03/2021  12:59 AM
 */
public class NotDivisionByZeroValidator implements ConstraintValidator<NotDivisionByZero, CalculateRequest> {

    @Override
    public boolean isValid(CalculateRequest value, ConstraintValidatorContext context) {
        if (Objects.isNull(value.getOperation()) || !Operation.DIVIDE.equals(value.getOperation()))
            return true;
        if (Objects.isNull(value.getValues()) || value.getValues().length == 1)
            return true;

        return Arrays.stream(value.getValues())
                .skip(1)
                .filter(v -> BigDecimal.ZERO.compareTo(v) == 0)
                .findAny()
                .isEmpty();
    }
}
