package com.ioprogramming.day01csvdatahandling.advancedproblems.convertcsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVToStudentConverterTest {

    private static final String TEST_FILE = "test_students.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Arrays.asList(
                "ID,Name,Age,Marks",
                "1,Alice,20,85.5",
                "2,Bob,21,78.0",
                "3,Charlie,19,90.2"
        );
        Files.write(Paths.get(TEST_FILE), lines);
    }

    @Test
    void testReadStudentsFromCSV() {
        List<Student> students = CSVToStudentConverter.readStudentsFromCSV(TEST_FILE);

        assertEquals(3, students.size());
        assertTrue(students.toString().contains("Alice"));
        assertTrue(students.toString().contains("Charlie"));
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

