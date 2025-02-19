package com.ioprogramming.day02jsondata.practiceproblems.readjson;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadJsonExampleTest {

    @Test
    public void testExtractFieldsFromJson() {
        // Create a temporary JSON file for testing
        String testJson = "{ \"name\": \"Aakrati\", \"email\": \"aakrati@example.com\", \"age\": 23 }";
        File tempFile = null;

        try {
            tempFile = File.createTempFile("testUser", ".json");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(testJson);
            writer.close();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(tempFile);

            assertEquals("Aakrati", rootNode.get("name").asText());
            assertEquals("aakrati@example.com", rootNode.get("email").asText());

        } catch (IOException e) {
            fail("Exception while testing JSON extraction: " + e.getMessage());
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }
}

