package com.hachichu.bootifulcalculator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * Created by djames
 * 06/03/2021  6:41 PM
 */
@Getter
@AllArgsConstructor
public enum Operation {
    ADD("add", BigDecimal::add, BigInteger::add),
    SUBTRACT("sub", BigDecimal::subtract, BigInteger::subtract),
    MULTIPLY("mul", BigDecimal::multiply, BigInteger::multiply),
    DIVIDE("div", BigDecimal::divide, BigInteger::divide);

    private final String value;
    private final BinaryOperator<BigDecimal> decimalOperator;
    private final BinaryOperator<BigInteger> integerOperator;

    public static Operation parse(String value) {
        return Arrays.stream(values())
                .filter(o -> o.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid Operator.")); // create custom exception

    }
}
