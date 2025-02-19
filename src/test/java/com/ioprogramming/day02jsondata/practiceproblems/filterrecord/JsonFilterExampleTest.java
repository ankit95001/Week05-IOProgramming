package com.ioprogramming.day02jsondata.practiceproblems.filterrecord;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class JsonFilterExampleTest {

    @Test
    public void testFilterStudentsByAge() {
        String jsonInput = "["
                + "{\"name\":\"Ankit\",\"age\":24,\"email\":\"ankit@example.com\"},"
                + "{\"name\":\"Aakrati\",\"age\":26,\"email\":\"aakrati@example.com\"},"
                + "{\"name\":\"Anand\",\"age\":28,\"email\":\"anand@example.com\"},"
                + "{\"name\":\"Yaman\",\"age\":30,\"email\":\"yaman@example.com\"}"
                + "]";

        List<Student> result = JsonFilterExample.filterStudentsByAge(jsonInput, 25);

        assertEquals(3, result.size());
        assertEquals("Aakrati", result.get(0).getName());
        assertEquals("Anand", result.get(1).getName());
        assertEquals("Yaman", result.get(2).getName());
    }

    @Test
    public void testFilterNoMatch() {
        String jsonInput = "["
                + "{\"name\":\"Ankit\",\"age\":24,\"email\":\"ankit@example.com\"},"
                + "{\"name\":\"Avinash\",\"age\":23,\"email\":\"avinash@example.com\"}"
                + "]";

        List<Student> result = JsonFilterExample.filterStudentsByAge(jsonInput, 25);
        assertTrue(result.isEmpty());
    }
}

