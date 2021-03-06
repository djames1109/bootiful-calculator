package com.hachichu.bootifulcalculator.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hachichu.bootifulcalculator.enums.Operation;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by djames
 * 06/03/2021  7:31 PM
 */
public class OperationDeserializer extends StdDeserializer<Operation> {

    public OperationDeserializer() {
        super(Operation.class);
    }

    @Override
    public Operation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Objects.nonNull(jsonParser.getValueAsString()) ? Operation.parse(jsonParser.getValueAsString()) : null;
    }
}
