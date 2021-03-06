package com.hachichu.bootifulcalculator.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * Created by djames
 * 06/03/2021  6:17 PM
 */
public class CalculateUtil {

    private CalculateUtil() {
    }

    public static BigDecimal process(BigDecimal[] decimals, BinaryOperator<BigDecimal> operator) {
        return Arrays.stream(decimals)
                .skip(1)
                .reduce(decimals[0], operator);
    }

    public static BigInteger process(BigInteger[] numbers, BinaryOperator<BigInteger> operator) {
        return Arrays.stream(numbers)
                .skip(1)
                .reduce(numbers[0], operator);
    }
}
