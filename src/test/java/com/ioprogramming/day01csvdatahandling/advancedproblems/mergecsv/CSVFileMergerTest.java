package com.ioprogramming.day01csvdatahandling.advancedproblems.mergecsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVFileMergerTest {

    private static final String FILE1 = "test_students1.csv";
    private static final String FILE2 = "test_students2.csv";
    private static final String OUTPUT_FILE = "test_merged.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> data1 = Arrays.asList(
                "ID,Name,Age",
                "1,Alice,20",
                "2,Bob,21",
                "3,Charlie,19"
        );
        Files.write(Paths.get(FILE1), data1);

        List<String> data2 = Arrays.asList(
                "ID,Marks,Grade",
                "1,85.5,A",
                "2,78.0,B",
                "3,90.2,A+"
        );
        Files.write(Paths.get(FILE2), data2);
    }

    @Test
    void testMergeCSVFiles() {
        CSVFileMerger.mergeCSVFiles(FILE1, FILE2, OUTPUT_FILE);

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(OUTPUT_FILE));
        } catch (IOException e) {
            fail("Failed to read output file");
            return;
        }

        assertEquals(4, lines.size()); // 1 header + 3 records
        assertTrue(lines.get(1).contains("Alice"));
        assertTrue(lines.get(2).contains("Bob"));
        assertTrue(lines.get(3).contains("Charlie"));
    }

    @AfterEach
    void tearDown() {
        new File(FILE1).delete();
        new File(FILE2).delete();
        new File(OUTPUT_FILE).delete();
    }
}

