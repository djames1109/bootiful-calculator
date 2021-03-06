package com.hachichu.bootifulcalculator.constraints.validators;

import com.hachichu.bootifulcalculator.constraints.ValidIntegerValues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * Created by djames
 * 07/03/2021  1:25 AM
 */
public class ValidIntegerValuesValidator implements ConstraintValidator<ValidIntegerValues, BigDecimal[]> {
    @Override
    public void initialize(ValidIntegerValues constraintAnnotation) {
    }

    @Override
    public boolean isValid(BigDecimal[] value, ConstraintValidatorContext context) {
        for (BigDecimal entry : value) {
            if (!(entry.stripTrailingZeros().scale() <= 0))
                return false;
        }
        return true;
    }
}
