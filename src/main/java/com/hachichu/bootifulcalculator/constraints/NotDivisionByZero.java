package com.hachichu.bootifulcalculator.constraints;

import com.hachichu.bootifulcalculator.constraints.validators.NotDivisionByZeroValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by djames
 * 07/03/2021  12:57 AM
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotDivisionByZeroValidator.class)
public @interface NotDivisionByZero {

    String message() default "must not be divided by zero.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
