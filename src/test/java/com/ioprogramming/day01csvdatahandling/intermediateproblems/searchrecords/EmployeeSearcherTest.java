package com.ioprogramming.day01csvdatahandling.intermediateproblems.searchrecords;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class EmployeeSearcherTest {

    private static final String TEST_FILE = "test_employees.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Arrays.asList(
                "ID,Name,Department,Salary",
                "1,Alice,HR,50000",
                "2,Bob,IT,60000",
                "3,Charlie,Finance,55000",
                "4,David,Marketing,52000"
        );
        Files.write(Paths.get(TEST_FILE), lines);
    }

    @Test
    void testSearchEmployeeFound() {
        assertEquals("Department: HR | Salary: 50000", EmployeeSearcher.searchEmployee(TEST_FILE, "Alice"));
        assertEquals("Department: IT | Salary: 60000", EmployeeSearcher.searchEmployee(TEST_FILE, "Bob"));
    }

    @Test
    void testSearchEmployeeNotFound() {
        assertEquals("Employee not found", EmployeeSearcher.searchEmployee(TEST_FILE, "Emma"));
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

