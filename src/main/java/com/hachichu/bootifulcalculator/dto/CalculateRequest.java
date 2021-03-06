package com.hachichu.bootifulcalculator.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hachichu.bootifulcalculator.enums.Operation;
import com.hachichu.bootifulcalculator.enums.Type;
import com.hachichu.bootifulcalculator.serializer.OperationDeserializer;
import com.hachichu.bootifulcalculator.serializer.TypeDeserializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by djames
 * 06/03/2021  5:23 PM
 */
@Data
public class CalculateRequest {

    private BigDecimal[] values;
    @JsonDeserialize(using = OperationDeserializer.class)
    private Operation operation;
    @JsonDeserialize(using = TypeDeserializer.class)
    private Type type;
}
