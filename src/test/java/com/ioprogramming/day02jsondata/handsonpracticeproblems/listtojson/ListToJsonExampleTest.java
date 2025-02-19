package com.ioprogramming.day02jsondata.handsonpracticeproblems.listtojson;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class ListToJsonExampleTest {

    @Test
    public void testConvertListToJson() {
        List<Student> students = Arrays.asList(
                new Student("Ankit", 24, "ankit@example.com"),
                new Student("Aakrati", 26, "aakrati@example.com"),
                new Student("Anand", 28, "anand@example.com")
        );

        String jsonResult = ListToJsonExample.convertListToJson(students);

        assertNotNull(jsonResult);
        assertTrue(jsonResult.contains("\"name\":\"Ankit\""));
        assertTrue(jsonResult.contains("\"age\":24"));
        assertTrue(jsonResult.contains("\"email\":\"ankit@example.com\""));
    }
}

