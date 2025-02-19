package com.ioprogramming.day02jsondata.practiceproblems.validatejson;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JsonValidationExampleTest {

    @Test
    public void testValidJson() {
        String json = "{ \"name\": \"Avinash\", \"email\": \"avinash@example.com\", \"age\": 26 }";
        assertTrue(JsonValidationExample.isValidJson(json));
    }

    @Test
    public void testInvalidJsonMissingField() {
        String json = "{ \"name\": \"Yaman\", \"email\": \"yaman@example.com\" }"; // Missing 'age'
        assertFalse(JsonValidationExample.isValidJson(json));
    }

    @Test
    public void testMalformedJson() {
        String json = "{ name: \"Anand\", email: \"anand@example.com\", age: 24 "; // Incorrect format
        assertFalse(JsonValidationExample.isValidJson(json));
    }
}

