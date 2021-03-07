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
 * 07/03/2021  9:48 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestCalculateSuccessFlow {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateAddIntegers() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(21),
                        BigDecimal.valueOf(32),
                        BigDecimal.valueOf(5),
                        BigDecimal.valueOf(42),
                        BigDecimal.valueOf(12)
                }, Operation.ADD.getValue(),
                Type.INTEGER.getValue());

        test(request, 112);
    }

    @Test
    public void testCalculateAddDecimals() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(95.36),
                        BigDecimal.valueOf(21.96),
                        BigDecimal.valueOf(75.63),
                        BigDecimal.valueOf(0.99),
                        BigDecimal.valueOf(0.05)
                }, Operation.ADD.getValue(),
                Type.DECIMAL.getValue());

        test(request, 193.99);
    }

    @Test
    public void testCalculateSubtractIntegers() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(785),
                        BigDecimal.valueOf(562),
                        BigDecimal.valueOf(32),
                        BigDecimal.valueOf(2),
                        BigDecimal.valueOf(45)
                }, Operation.SUBTRACT.getValue(),
                Type.INTEGER.getValue());

        test(request, 144);
    }

    @Test
    public void testCalculateSubtractDecimals() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(459.23),
                        BigDecimal.valueOf(56.09),
                        BigDecimal.valueOf(75.696),
                        BigDecimal.valueOf(4.006),
                        BigDecimal.valueOf(78.123),
                        BigDecimal.ZERO
                }, Operation.SUBTRACT.getValue(),
                Type.DECIMAL.getValue()
        );

        test(request, 245.315);
    }

    @Test
    public void testCalculateMultiplyIntegers() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(5),
                        BigDecimal.valueOf(3),
                        BigDecimal.valueOf(2),
                        BigDecimal.valueOf(1000)
                }, Operation.MULTIPLY.getValue(),
                Type.INTEGER.getValue());

        test(request, 30000);
    }

    @Test
    public void testCalculateMultiplyDecimals() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(0.56),
                        BigDecimal.valueOf(2.2),
                        BigDecimal.valueOf(63.7),
                        BigDecimal.valueOf(3)
                }, Operation.MULTIPLY.getValue(),
                Type.DECIMAL.getValue());

        test(request, 235.4352);
    }

    @Test
    public void testCalculateMultiplySafe() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(1.025),
                        BigDecimal.valueOf(6.2785),
                        BigDecimal.valueOf(1.7),
                        BigDecimal.valueOf(3)
                }, Operation.MULTIPLY.getValue(),
                Type.DECIMAL.getValue());

        test(request, 32.82085875);
    }

    @Test
    public void testCalculateDivideIntegers() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(600),
                        BigDecimal.valueOf(2),
                        BigDecimal.valueOf(6),
                        BigDecimal.valueOf(5)
                }, Operation.DIVIDE.getValue(),
                Type.INTEGER.getValue());

        test(request, 10);
    }

    @Test
    public void testCalculateDivideDecimals() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(500.605),
                        BigDecimal.valueOf(0.25),
                        BigDecimal.valueOf(50)
                }, Operation.DIVIDE.getValue(),
                Type.DECIMAL.getValue());

        test(request, 40.0484);
    }


    @Test
    public void testCalculateDivideSafe() throws Exception {
        String request = prepareRequest(new BigDecimal[]{
                        BigDecimal.valueOf(500.605),
                        BigDecimal.valueOf(0.25),
                        BigDecimal.valueOf(50)
                }, Operation.DIVIDE.getValue(),
                Type.SAFE.getValue());

        test(request, 40.0484);
    }


    private <T> void test(String request, T expected) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bootiful-calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(request))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result", CoreMatchers.is(expected)));
    }

    private String prepareRequest(BigDecimal[] values, String operation, String type) {
        return "{" +
                "\"values\" : " + Arrays.toString(values) + ",\n" +
                "\"operation\" : " + "\"" + operation + "\"" + ", \n" +
                "\"type\" : " + "\"" + type + "\"" + "\n" +
                '}';
    }
}
