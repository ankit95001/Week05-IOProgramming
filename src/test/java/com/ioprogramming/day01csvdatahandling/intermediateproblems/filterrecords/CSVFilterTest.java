package com.ioprogramming.day01csvdatahandling.intermediateproblems.filterrecords;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVFilterTest {

    private static final String TEST_FILE = "test_students.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Arrays.asList(
                "ID,Name,age,Marks",
                "1,Alice,20,85",
                "2,Bob,22,78",
                "3,Charlie,23,90",
                "4,David,15,65",
                "5,Emma,12,88"
        );
        Files.write(Paths.get(TEST_FILE), lines);
    }

    @Test
    void testFilterHighScorers() {
        List<Student> highScorers = CSVFilter.filterHighScorers(TEST_FILE);
        assertEquals(3, highScorers.size());
    }

    @Test
    void testNoHighScorers() throws IOException {
        Files.write(Paths.get(TEST_FILE), List.of("ID,Name,age,Marks", "1,John,22,70", "2,Jane,21,75"));
        List<Student> highScorers = CSVFilter.filterHighScorers(TEST_FILE);
        assertEquals(0, highScorers.size());
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

