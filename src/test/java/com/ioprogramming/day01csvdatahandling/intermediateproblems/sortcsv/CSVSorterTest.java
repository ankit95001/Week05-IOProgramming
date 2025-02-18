package com.ioprogramming.day01csvdatahandling.intermediateproblems.sortcsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

class CSVSorterTest {

    private static final String TEST_FILE = "test_employees.csv";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = Arrays.asList(
                "ID,Name,Department,Salary",
                "1,Alice,HR,50000",
                "2,Bob,IT,60000",
                "3,Charlie,Finance,55000",
                "4,David,IT,65000",
                "5,Eve,HR,70000",
                "6,Frank,Marketing,80000",
                "7,Grace,Finance,90000"
        );
        Files.write(Paths.get(TEST_FILE), lines);
    }

    @Test
    void testSortEmployeesBySalary() {
        List<String> sortedEmployees = CSVSorter.sortEmployeesBySalary(TEST_FILE);

        assertEquals("ID,Name,Department,Salary", sortedEmployees.get(0));
        assertEquals("7,Grace,Finance,90000", sortedEmployees.get(1));
        assertEquals("6,Frank,Marketing,80000", sortedEmployees.get(2));
        assertEquals("5,Eve,HR,70000", sortedEmployees.get(3));
        assertEquals("4,David,IT,65000", sortedEmployees.get(4));
        assertEquals("2,Bob,IT,60000", sortedEmployees.get(5));
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }
}

