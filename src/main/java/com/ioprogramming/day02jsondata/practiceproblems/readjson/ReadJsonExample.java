package com.ioprogramming.day02jsondata.practiceproblems.readjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJsonExample {
    public static void extractFieldsFromJson(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Extract specific fields
            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            System.out.println("Extracted Data:");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day02jsondata/practiceproblems/readjson/user.json";
        extractFieldsFromJson(filePath);
    }
}

