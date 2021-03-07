package com.hachichu.bootifulcalculator.constraints;

import com.hachichu.bootifulcalculator.constraints.validators.ValidIntegerValuesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by djames
 * 07/03/2021  1:23 AM
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidIntegerValuesValidator.class)
public @interface ValidIntegerValues {

    String message() default "must not contain decimals if the type is integer.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
