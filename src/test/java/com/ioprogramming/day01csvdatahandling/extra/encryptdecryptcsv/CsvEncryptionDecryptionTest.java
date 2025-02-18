package com.ioprogramming.day01csvdatahandling.extra.encryptdecryptcsv;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class CsvEncryptionDecryptionTest {

    private static final String TEST_FILE_PATH = "test_employees_encrypted.csv";

    @BeforeAll
    public static void setup() {
        // Create sample data for testing
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "Alice", "alice@example.com", "5000"));
        employees.add(new Employee("2", "Bob", "bob@example.com", "6000"));
        employees.add(new Employee("3", "Charlie", "charlie@example.com", "7000"));

        // Write encrypted data to the test CSV file
        CsvEncryptionDecryption.writeToCSV(TEST_FILE_PATH, employees);
    }

    @Test
    public void testEncryptionAndDecryption() {
        // Read and decrypt data from CSV
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps); // Redirect System.out to capture the output

        CsvEncryptionDecryption.readFromCSV(TEST_FILE_PATH);

        // Get the printed output and verify it contains the correct decrypted data
        String output = baos.toString();
        assertTrue(output.contains("Alice") && output.contains("alice@example.com") && output.contains("5000"));
        assertTrue(output.contains("Bob") && output.contains("bob@example.com") && output.contains("6000"));
        assertTrue(output.contains("Charlie") && output.contains("charlie@example.com") && output.contains("7000"));
    }

    @AfterAll
    public static void cleanup() {
        // Clean up the test file after test execution
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}

