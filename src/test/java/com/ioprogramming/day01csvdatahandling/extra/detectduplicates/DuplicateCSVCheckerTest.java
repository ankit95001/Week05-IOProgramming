package com.ioprogramming.day01csvdatahandling.extra.detectduplicates;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class DuplicateCSVCheckerTest {
    private static final String TEST_FILE = "test_students.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> data = Arrays.asList(
                "ID,Name,Age",
                "1,Alice,20",
                "2,Bob,21",
                "3,Charlie,19",
                "2,Bob,21",
                "4,David,22",
                "3,Charlie,19"
        );
        Files.write(Paths.get(TEST_FILE), data);
    }

    @Test
    void testDetectDuplicates() {
        DuplicateCSVChecker.detectDuplicates(TEST_FILE);
        assertTrue(new File(TEST_FILE).exists());
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

