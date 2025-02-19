package com.ioprogramming.day02jsondata.practiceproblems.filterrecord;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class JsonFilterExample {

    public static List<Student> filterStudentsByAge(String jsonString, int ageThreshold) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = objectMapper.readValue(jsonString, new TypeReference<List<Student>>() {});

            return students.stream()
                    .filter(student -> student.getAge() > ageThreshold)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return List.of(); // Return empty list on failure
        }
    }

    public static void main(String[] args) {
        String jsonInput = "["
                + "{\"name\":\"Ankit\",\"age\":24,\"email\":\"ankit@example.com\"},"
                + "{\"name\":\"Aakrati\",\"age\":26,\"email\":\"aakrati@example.com\"},"
                + "{\"name\":\"Anand\",\"age\":28,\"email\":\"anand@example.com\"},"
                + "{\"name\":\"Avinash\",\"age\":23,\"email\":\"avinash@example.com\"},"
                + "{\"name\":\"Yaman\",\"age\":30,\"email\":\"yaman@example.com\"}"
                + "]";

        List<Student> filteredStudents = filterStudentsByAge(jsonInput, 25);
        System.out.println("Filtered Students (Age > 25): " + filteredStudents);
    }
}
