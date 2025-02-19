package com.ioprogramming.day02jsondata.practiceproblems;

import static org.junit.jupiter.api.Assertions.*;

import com.ioprogramming.day02jsondata.practiceproblems.createjson.StudentJsonExample;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class StudentJsonExampleTest {

    @Test
    public void testCreateStudentJson() {
        List<String> subjects = Arrays.asList("Math", "Science", "English");
        String jsonString = StudentJsonExample.createStudentJson("Aakrati", 20, subjects);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            assertEquals("Aakrati", jsonNode.get("name").asText());
            assertEquals(20, jsonNode.get("age").asInt());

            JsonNode subjectsArray = jsonNode.get("subjects");
            assertNotNull(subjectsArray);
            assertTrue(subjectsArray.isArray());
            assertEquals(3, subjectsArray.size());
            assertEquals("Math", subjectsArray.get(0).asText());
            assertEquals("Science", subjectsArray.get(1).asText());
            assertEquals("English", subjectsArray.get(2).asText());

        } catch (Exception e) {
            fail("Exception while parsing JSON: " + e.getMessage());
        }
    }
}

