package com.ioprogramming.day01csvdatahandling.intermediateproblems.filterrecords;

import java.io.*;
import java.util.*;


class CSVFilter {
    public static List<Student> filterHighScorers(String filePath) {
        List<Student> highScorers = new ArrayList<>();
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
                    if (marks > 80) {
                        highScorers.add(new Student(id,name, age,marks));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return highScorers;
    }

    public static void printHighScorers(List<Student> students) {
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/intermediateproblems/filterrecords/students.csv";
        List<Student> highScorers = filterHighScorers(filePath);
        System.out.println("Students scoring more than 80 marks:");
        printHighScorers(highScorers);
    }
}

