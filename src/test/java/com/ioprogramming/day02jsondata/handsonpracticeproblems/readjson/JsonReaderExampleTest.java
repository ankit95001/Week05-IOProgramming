package com.ioprogramming.day02jsondata.handsonpracticeproblems.readjson;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReaderExampleTest {

    @Test
    public void testPrintJsonKeysAndValues() {
        String jsonContent = "{"
                + "\"name\": \"Ankit\","
                + "\"age\": 24,"
                + "\"email\": \"ankit@example.com\","
                + "\"subjects\": [\"Math\", \"Science\"],"
                + "\"address\": {\"city\": \"Bhopal\", \"pincode\": 462001}"
                + "}";

        File tempFile = createTempJsonFile(jsonContent);
        assertNotNull(tempFile);

        JsonReaderExample.printJsonKeysAndValues(tempFile);
    }

    private File createTempJsonFile(String jsonContent) {
        try {
            File tempFile = File.createTempFile("testJson", ".json");
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(jsonContent);
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

