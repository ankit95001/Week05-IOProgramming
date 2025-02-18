package com.ioprogramming.day01csvdatahandling.basicproblems.writecsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVWriterTest {

    private static final String TEST_FILE = "test_employees.csv";

    @BeforeEach
    void setUp() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ankit", "HR", 50000),
                new Employee(2, "Anand", "Engineering", 70000)
        );
        CSVWriter.writeCSV(TEST_FILE, employees);
    }

    @Test
    void testFileExists() {
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "File should be created");
    }

    @Test
    void testFileContent() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
        assertEquals(3, lines.size()); // 1 header + 2 records
        assertEquals("ID,Name,Department,Salary", lines.get(0));
        assertEquals("1,Ankit,HR,50000.0", lines.get(1));
        assertEquals("2,Anand,Engineering,70000.0", lines.get(2));
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

