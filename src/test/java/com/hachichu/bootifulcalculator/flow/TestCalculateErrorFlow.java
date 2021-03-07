package com.hachichu.bootifulcalculator.flow;

import com.hachichu.bootifulcalculator.enums.Operation;
import com.hachichu.bootifulcalculator.enums.Type;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by djames
 * 07/03/2021  11:14 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestCalculateErrorFlow {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEmptyValues() throws Exception {
        String request = prepareRequest(null, Operation.MULTIPLY.getValue(), Type.INTEGER.getValue());
        test(request, "values must not be empty");
    }

    @Test
    public void testNullType() throws Exception {
        String request = "{" +
                "\"values\" : " + Arrays.toString(new BigDecimal[]{BigDecimal.ONE}) + ",\n" +
                "\"operation\" : " + "\"" + Operation.ADD.getValue() + "\"" + "\n" +
                '}';
        test(request, "type must not be null");
    }

    @Test
    public void testInvalidType() throws Exception {
        String request = prepareRequest(new BigDecimal[]{BigDecimal.ONE}, Operation.ADD.getValue(), "noType");
        test(request, "invalid type");
    }

    @Test
    public void testInvalidOperation() throws Exception {
        String request = prepareRequest(new BigDecimal[]{BigDecimal.ONE}, "noOperation", Type.INTEGER.getValue());
        test(request, "invalid operation");
    }

    @Test
    public void testOperation() throws Exception {
        String request = "{" +
                "\"values\" : " + Arrays.toString(new BigDecimal[]{BigDecimal.ONE}) + ",\n" +
                "\"type\" : " + "\"" + Type.INTEGER.getValue() + "\"" + "\n" +
                '}';
        test(request, "operation must not be null");
    }

    @Test
    public void testDecimalsInInteger() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(5),
                        BigDecimal.valueOf(65),
                        BigDecimal.valueOf(63.26),
                        BigDecimal.valueOf(2)
                }, Operation.ADD.getValue(),
                Type.INTEGER.getValue());
        test(request, "calculateRequest must not contain decimals if the type is integer.");

    }

    @Test
    public void testDivisionByZero() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(77),
                        BigDecimal.valueOf(7),
                        BigDecimal.ZERO,
                        BigDecimal.ONE
                }, Operation.DIVIDE.getValue(),
                Type.INTEGER.getValue());
        test(request, "calculateRequest must not be divided by zero.");
    }

    private <T> void test(String request, T expected) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bootiful-calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(request))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", CoreMatchers.is(expected)));
    }

    private String prepareRequest(BigDecimal[] values, String operation, String type) {
        return "{" +
                "\"values\" : " + Arrays.toString(values) + ",\n" +
                "\"operation\" : " + "\"" + operation + "\"" + ", \n" +
                "\"type\" : " + "\"" + type + "\"" + "\n" +
                '}';
    }
}
