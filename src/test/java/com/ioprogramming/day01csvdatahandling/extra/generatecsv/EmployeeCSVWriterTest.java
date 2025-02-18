package com.ioprogramming.day01csvdatahandling.extra.generatecsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

class EmployeeCSVWriterTest {
    private static final String TEST_FILE = "test_employees_report.csv";

    @Test
    void testWriteToCSV() {
        EmployeeCSVWriter.writeToCSV(TEST_FILE);
        assertTrue(new File(TEST_FILE).exists()); // Check if file is created
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

