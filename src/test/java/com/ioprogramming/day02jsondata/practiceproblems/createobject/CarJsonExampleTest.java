package com.ioprogramming.day02jsondata.practiceproblems.createobject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarJsonExampleTest {

    @Test
    public void testConvertCarToJson() {

        Car testCar = new Car("Honda", "Civic", 2023);
        String jsonString = CarJsonExample.convertCarToJson(testCar);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            assertEquals("Honda", jsonNode.get("brand").asText());
            assertEquals("Civic", jsonNode.get("model").asText());
            assertEquals(2023, jsonNode.get("year").asInt());

        } catch (Exception e) {
            fail("Exception while parsing JSON: " + e.getMessage());
        }
    }
}

