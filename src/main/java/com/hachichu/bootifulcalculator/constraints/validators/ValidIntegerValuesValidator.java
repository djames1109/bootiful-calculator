package com.hachichu.bootifulcalculator.constraints.validators;

import com.hachichu.bootifulcalculator.constraints.ValidIntegerValues;
import com.hachichu.bootifulcalculator.dto.CalculateRequest;
import com.hachichu.bootifulcalculator.enums.Type;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by djames
 * 07/03/2021  1:25 AM
 */
public class ValidIntegerValuesValidator implements ConstraintValidator<ValidIntegerValues, CalculateRequest> {

    @Override
    public boolean isValid(CalculateRequest value, ConstraintValidatorContext context) {
        if (Objects.isNull(value.getValues()))
            return true;
        if (Objects.isNull(value.getType()) || !Type.INTEGER.equals(value.getType()))
            return true;

        for (BigDecimal entry : value.getValues()) {
            if (!(entry.stripTrailingZeros().scale() <= 0))
                return false;
        }
        return true;
    }
}
