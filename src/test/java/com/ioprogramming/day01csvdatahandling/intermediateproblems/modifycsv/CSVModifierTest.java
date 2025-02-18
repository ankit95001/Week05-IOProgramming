package com.ioprogramming.day01csvdatahandling.intermediateproblems.modifycsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVModifierTest {

    private static final String TEST_INPUT_FILE = "test_employees.csv";
    private static final String TEST_OUTPUT_FILE = "test_updated_employees.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Arrays.asList(
                "ID,Name,Department,Salary",
                "1,Alice,HR,50000",
                "2,Bob,IT,60000",
                "3,Charlie,Finance,55000",
                "4,David,IT,65000"
        );
        Files.write(Paths.get(TEST_INPUT_FILE), lines);
    }

    @Test
    void testUpdateSalaries() throws IOException {
        CSVModifier.updateSalaries(TEST_INPUT_FILE, TEST_OUTPUT_FILE);
        List<String> updatedLines = Files.readAllLines(Paths.get(TEST_OUTPUT_FILE));

        assertEquals("ID,Name,Department,Salary", updatedLines.get(0));
        assertEquals("1,Alice,HR,50000.00", updatedLines.get(1));
        assertEquals("2,Bob,IT,66000.00", updatedLines.get(2)); // 60000 * 1.10
        assertEquals("3,Charlie,Finance,55000.00", updatedLines.get(3));
        assertEquals("4,David,IT,71500.00", updatedLines.get(4)); // 65000 * 1.10
    }

    @AfterEach
    void tearDown() {
        new File(TEST_INPUT_FILE).delete();
        new File(TEST_OUTPUT_FILE).delete();
    }
}

