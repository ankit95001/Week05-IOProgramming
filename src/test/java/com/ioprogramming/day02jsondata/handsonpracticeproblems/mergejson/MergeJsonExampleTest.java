package com.ioprogramming.day02jsondata.handsonpracticeproblems.mergejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MergeJsonExampleTest {

    @Test
    public void testMergeJsonObjects() {
        String json1 = "{ \"name\": \"Aakrati\", \"email\": \"aakrati@example.com\" }";
        String json2 = "{ \"age\": 23, \"city\": \"Indore\" }";

        String mergedJson = MergeJsonExample.mergeJsonObjects(json1, json2);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(mergedJson);

            assertEquals("Aakrati", jsonNode.get("name").asText());
            assertEquals("aakrati@example.com", jsonNode.get("email").asText());
            assertEquals(23, jsonNode.get("age").asInt());
            assertEquals("Indore", jsonNode.get("city").asText());

        } catch (Exception e) {
            fail("Exception while parsing merged JSON: " + e.getMessage());
        }
    }
}

