package com.ioprogramming.day01csvdatahandling.extra.readlargecsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class LargeCSVReaderTest {
    private static final String TEST_FILE = "test_large.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> data = new ArrayList<>();
        data.add("ID,Name,Age,Salary"); // Header
        for (int i = 1; i <= 500; i++) {
            data.add(i + ",Employee" + i + "," + (20 + (i % 10)) + "," + (30000 + (i * 10)));
        }
        Files.write(Paths.get(TEST_FILE), data);
    }

    @Test
    void testReadLargeCSVFile() {
        LargeCSVReader.readLargeCSVFile(TEST_FILE, 100);
        assertTrue(new File(TEST_FILE).exists());
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

