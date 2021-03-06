package com.hachichu.bootifulcalculator.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hachichu.bootifulcalculator.enums.Type;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by djames
 * 06/03/2021  7:39 PM
 */
public class TypeDeserializer extends StdDeserializer<Type> {

    public TypeDeserializer() {
        super(Type.class);
    }

    @Override
    public Type deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Objects.nonNull(jsonParser.getValueAsString()) ? Type.valueOf(jsonParser.getValueAsString()) : null;
    }
}
