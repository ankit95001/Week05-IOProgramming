package com.ioprogramming.day02jsondata.handsonpracticeproblems.validateemail;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonEmailValidator {

    public static boolean validateEmailJson(String jsonString) {
        try {
            // Define JSON Schema for email validation
            String schemaString = "{"
                    + "\"type\": \"object\","
                    + "\"properties\": {"
                    + "    \"email\": {"
                    + "        \"type\": \"string\","
                    + "        \"format\": \"email\""
                    + "    }"
                    + "},"
                    + "\"required\": [\"email\"]"
                    + "}";

            JSONObject schemaJson = new JSONObject(new JSONTokener(schemaString));
            Schema schema = SchemaLoader.load(schemaJson);

            // Convert input JSON string to JSONObject
            JSONObject inputJson = new JSONObject(new JSONTokener(jsonString));

            // Validate input JSON against schema
            schema.validate(inputJson);
            return true;  // Validation successful
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
            return false; // Validation failed
        }
    }

    public static void main(String[] args) {
        String validJson = "{\"email\": \"ankit@example.com\"}";
        String invalidJson = "{\"email\": \"invalid-email\"}";

        System.out.println("Valid JSON Test: " + validateEmailJson(validJson));
        System.out.println("Invalid JSON Test: " + validateEmailJson(invalidJson));
    }
}

