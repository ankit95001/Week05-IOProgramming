package com.ioprogramming.day02jsondata.practiceproblems.tojsonarray;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonExampleTest {

    @Test
    public void testConvertListToJson() {
        List<Student> students = Arrays.asList(
                new Student("Avinash", 24, Arrays.asList("Computer Science", "Math")),
                new Student("Yaman", 25, Arrays.asList("Biology", "Chemistry"))
        );

        String jsonArray = ListToJsonExample.convertListToJson(students);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonArray);

            assertEquals(2, jsonNode.size()); // Should have 2 students
            assertEquals("Avinash", jsonNode.get(0).get("name").asText());
            assertEquals("Yaman", jsonNode.get(1).get("name").asText());
        } catch (Exception e) {
            fail("Exception while parsing JSON: " + e.getMessage());
        }
    }
}

