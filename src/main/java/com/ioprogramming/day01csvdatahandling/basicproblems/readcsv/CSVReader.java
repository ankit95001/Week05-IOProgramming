package com.ioprogramming.day01csvdatahandling.basicproblems.readcsv;

import java.io.*;
import java.util.*;

class CSVReader {
    public static List<Student> readCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());
                    students.add(new Student(id, name, age, marks));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return students;
    }

    public static void printStudents(List<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/basicproblems/readcsv/large_dataset.csv";
        List<Student> students = readCSV(filePath);
        printStudents(students);
    }
}

