package com.ioprogramming.day01csvdatahandling.extra.jsontocsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

class JsonCsvConverterTest {
    private static final String JSON_FILE = "test_students.json";
    private static final String CSV_FILE = "test_students.csv";
    private static final String NEW_JSON_FILE = "test_converted_students.json";

    @BeforeEach
    void setup() throws IOException {
        String jsonData = "[{\"ID\":\"1\",\"Name\":\"Alice\",\"Age\":\"20\"},{\"ID\":\"2\",\"Name\":\"Bob\",\"Age\":\"22\"}]";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE))) {
            writer.write(jsonData);
        }
    }

    @Test
    void testJsonToCsv() {
        JsonCsvConverter.jsonToCsv(JSON_FILE, CSV_FILE);
        assertTrue(new File(CSV_FILE).exists());
    }

    @Test
    void testCsvToJson() {
        JsonCsvConverter.jsonToCsv(JSON_FILE, CSV_FILE);
        JsonCsvConverter.csvToJson(CSV_FILE, NEW_JSON_FILE);
        assertTrue(new File(NEW_JSON_FILE).exists());
    }

    @AfterEach
    void cleanup() {
        new File(JSON_FILE).delete();
        new File(CSV_FILE).delete();
        new File(NEW_JSON_FILE).delete();
    }
}

