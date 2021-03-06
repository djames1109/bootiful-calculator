package com.hachichu.bootifulcalculator.constraints.validators;

import com.hachichu.bootifulcalculator.constraints.NotDivisionByZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by djames
 * 07/03/2021  12:59 AM
 */
public class NotDivisionByZeroValidator implements ConstraintValidator<NotDivisionByZero, BigDecimal[]> {

    @Override
    public void initialize(NotDivisionByZero constraintAnnotation) {

    }

    @Override
    public boolean isValid(BigDecimal[] value, ConstraintValidatorContext context) {
        if (value.length == 1)
            return true;

        return Arrays.stream(value)
                .skip(1)
                .filter(v -> BigDecimal.ZERO.compareTo(v) == 0)
                .findAny()
                .isEmpty();

    }
}
