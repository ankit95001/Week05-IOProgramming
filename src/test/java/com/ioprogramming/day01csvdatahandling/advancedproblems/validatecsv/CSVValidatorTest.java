package com.ioprogramming.day01csvdatahandling.advancedproblems.validatecsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVValidatorTest {

    private static final String TEST_FILE = "test_employees.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Arrays.asList(
                "ID,Name,Email,Phone",
                "1,Alice,alice@example.com,9876543210",
                "2,Bob,bob@example,9876543210",
                "3,Charlie,charlie@example.com,123456789",
                "4,David,david@xyz.com,99999abcde",
                "5,Eve,eve@gmail.com,9876543210"
        );
        Files.write(Paths.get(TEST_FILE), lines);
    }

    @Test
    void testValidateCSV() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CSVValidator.validateCSV(TEST_FILE);
        String output = outContent.toString();

        assertTrue(output.contains("Invalid Email: bob@example"));
        assertTrue(output.contains("Row 3 is invalid: 3,Charlie,charlie@example.com,123456789"));
        assertTrue(output.contains("Invalid Phone Number: 123456789"));
        assertTrue(output.contains("Row 4 is invalid: 4,David,david@xyz.com,99999abcde"));
        assertTrue(output.contains("Invalid Phone Number: 99999abcde"));
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

