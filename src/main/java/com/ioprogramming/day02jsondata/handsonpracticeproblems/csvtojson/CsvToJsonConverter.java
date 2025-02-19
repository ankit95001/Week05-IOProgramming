package com.ioprogramming.day02jsondata.handsonpracticeproblems.csvtojson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.util.List;

public class CsvToJsonConverter {

    public static String convertCsvToJson(String csvData) {
        try {
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // Auto-detect headers

            MappingIterator<Object> it = csvMapper.readerFor(Object.class).with(schema).readValues(csvData);
            List<Object> dataList = it.readAll();

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);

        } catch (IOException e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String csvData = "name,age,email\nAnkit,24,ankit@example.com\nAakrati,22,aakrati@example.com";

        String jsonResult = convertCsvToJson(csvData);
        System.out.println("Converted JSON:\n" + jsonResult);
    }
}

