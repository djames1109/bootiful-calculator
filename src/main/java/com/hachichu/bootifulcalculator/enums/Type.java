package com.hachichu.bootifulcalculator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Created by djames
 * 06/03/2021  7:04 PM
 */
@Getter
@AllArgsConstructor
public enum Type {

    INTEGER("integer"),
    DECIMAL("decimal"),
    SAFE("safe");

    private final String value;

    public static Type parse(String value) {
        return Arrays.stream(values())
                .filter(t -> t.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid Type.")); //create custom exception
    }
}
