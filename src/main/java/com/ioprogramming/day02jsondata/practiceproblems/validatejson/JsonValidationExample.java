package com.ioprogramming.day02jsondata.practiceproblems.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidationExample {

    public static boolean isValidJson(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // Check if required fields exist
            return rootNode.has("name") && rootNode.has("email") && rootNode.has("age");
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String validJson = "{ \"name\": \"Ankit\", \"email\": \"ankit@example.com\", \"age\": 25 }";
        String invalidJson = "{ \"name\": \"Aakrati\", \"email\": \"aakrati@example.com\" }";
        String malformedJson = "{ name: \"Anand\", email: \"anand@example.com\", age: 24 ";

        System.out.println("Valid JSON: " + isValidJson(validJson));
        System.out.println("Invalid JSON (missing field): " + isValidJson(invalidJson));
        System.out.println("Malformed JSON: " + isValidJson(malformedJson));
    }
}

