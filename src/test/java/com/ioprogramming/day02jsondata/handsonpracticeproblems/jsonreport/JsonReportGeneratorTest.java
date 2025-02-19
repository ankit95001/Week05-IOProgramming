package com.ioprogramming.day02jsondata.handsonpracticeproblems.jsonreport;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class JsonReportGeneratorTest {

    @Test
    public void testGenerateJsonReport() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ankit", 24, "ankit@example.com"));
        students.add(new Student("Aakrati", 22, "aakrati@example.com"));

        String jsonReport = JsonReportGenerator.generateJsonReport(students);
        assertNotNull(jsonReport);
        assertTrue(jsonReport.contains("\"name\" : \"Ankit\""));
        assertTrue(jsonReport.contains("\"name\" : \"Aakrati\""));
    }

    @Test
    public void testEmptyList() {
        List<Student> emptyList = new ArrayList<>();
        String jsonReport = JsonReportGenerator.generateJsonReport(emptyList);
        assertEquals("[ ]", jsonReport);
    }
}

