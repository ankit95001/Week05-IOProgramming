package com.ioprogramming.day02jsondata.handsonpracticeproblems.csvtojson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CsvToJsonConverterTest {

    @Test
    public void testConvertCsvToJson() {
        String csvData = "name,age,email\nAnkit,24,ankit@example.com\nAakrati,22,aakrati@example.com";
        String expectedJson = "[ {\n" +
                "  \"name\" : \"Ankit\",\n" +
                "  \"age\" : 24,\n" +
                "  \"email\" : \"ankit@example.com\"\n" +
                "}, {\n" +
                "  \"name\" : \"Aakrati\",\n" +
                "  \"age\" : 22,\n" +
                "  \"email\" : \"aakrati@example.com\"\n" +
                "} ]";

        String actualJson = CsvToJsonConverter.convertCsvToJson(csvData);
        assertNotNull(actualJson);
        assertTrue(actualJson.contains("\"name\" : \"Ankit\""));
        assertTrue(actualJson.contains("\"name\" : \"Aakrati\""));
    }

    @Test
    public void testInvalidCsv() {
        String invalidCsv = "name,age,email\nAnkit,24"; // Missing email
        assertNull(CsvToJsonConverter.convertCsvToJson(invalidCsv));
    }
}


