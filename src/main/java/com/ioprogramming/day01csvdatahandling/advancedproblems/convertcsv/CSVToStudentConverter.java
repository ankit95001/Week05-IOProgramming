package com.ioprogramming.day01csvdatahandling.advancedproblems.convertcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudentConverter {
    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 4) continue;

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());

                students.add(new Student(id, name, age, marks));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return students;
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/advancedproblems/convertcsv/student.csv";
        List<Student> students = readStudentsFromCSV(filePath);

        // Print all student objects
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
