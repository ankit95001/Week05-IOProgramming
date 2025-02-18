package com.ioprogramming.day01csvdatahandling.basicproblems.readcsv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

class CSVReaderTest {

    @Test
    void testReadCSV() {
        List<Student> students = CSVReader.readCSV("src/main/java/com/ioprogramming/day01csvdatahandling/basicproblems/readcsv/large_dataset.csv");
        assertNotNull(students);
        assertFalse(students.isEmpty());

        Student firstStudent = students.get(0);
        assertEquals(1, firstStudent.id);
        assertEquals("Alice", firstStudent.name);
        assertEquals(20, firstStudent.age);
        assertEquals(85.5, firstStudent.marks, 0.01);
    }

    @Test
    void testEmptyFile() {
        List<Student> students = CSVReader.readCSV("empty.csv");
        assertTrue(students.isEmpty());
    }
}

