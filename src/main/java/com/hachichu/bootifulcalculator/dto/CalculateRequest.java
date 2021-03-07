package com.hachichu.bootifulcalculator.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hachichu.bootifulcalculator.constraints.NotDivisionByZero;
import com.hachichu.bootifulcalculator.constraints.ValidIntegerValues;
import com.hachichu.bootifulcalculator.enums.Operation;
import com.hachichu.bootifulcalculator.enums.Type;
import com.hachichu.bootifulcalculator.serializer.OperationDeserializer;
import com.hachichu.bootifulcalculator.serializer.TypeDeserializer;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by djames
 * 06/03/2021  5:23 PM
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ValidIntegerValues
@NotDivisionByZero
public class CalculateRequest {

    @NotEmpty
    private BigDecimal[] values;
    @NotNull
    @JsonDeserialize(using = OperationDeserializer.class)
    private Operation operation;
    @NotNull
    @JsonDeserialize(using = TypeDeserializer.class)
    private Type type;
}
