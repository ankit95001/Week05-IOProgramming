package com.ioprogramming.day02jsondata.handsonpracticeproblems.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ListToJsonExample {

    public static String convertListToJson(List<Student> students) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(students);
        } catch (Exception e) {
            System.out.println("Error converting to JSON: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Ankit", 24, "ankit@example.com"),
                new Student("Aakrati", 26, "aakrati@example.com"),
                new Student("Anand", 28, "anand@example.com"),
                new Student("Avinash", 23, "avinash@example.com"),
                new Student("Yaman", 30, "yaman@example.com")
        );

        String jsonArray = convertListToJson(students);
        System.out.println("JSON Array: " + jsonArray);
    }
}
