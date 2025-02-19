package com.ioprogramming.day02jsondata.practiceproblems.tojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ListToJsonExample {

    public static String convertListToJson(List<Student> students) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        } catch (Exception e) {
            return "Error converting list to JSON: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Ankit", 21, Arrays.asList("Math", "Science")),
                new Student("Aakrati", 22, Arrays.asList("English", "History")),
                new Student("Anand", 23, Arrays.asList("Physics", "Chemistry"))
        );

        String jsonArray = convertListToJson(students);
        System.out.println("JSON Array:\n" + jsonArray);
    }
}
