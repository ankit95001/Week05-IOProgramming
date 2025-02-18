package com.ioprogramming.day01csvdatahandling.basicproblems.countrows;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVRowCounterTest {

    private static final String TEST_FILE = "test_data.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Arrays.asList(
                "ID,Name,Age",
                "1,Ankit,22",
                "2,Anand,25",
                "3,Aakrati,28"
        );
        Files.write(Paths.get(TEST_FILE), lines);
    }

    @Test
    void testRowCount() {
        int count = CSVRowCounter.countRows(TEST_FILE);
        assertEquals(3, count); // 3 records excluding header
    }

    @Test
    void testEmptyFile() throws IOException {
        Files.write(Paths.get(TEST_FILE), List.of("ID,Name,Age")); // Only header
        int count = CSVRowCounter.countRows(TEST_FILE);
        assertEquals(0, count);
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

