package com.ioprogramming.day01csvdatahandling.basicproblems.writecsv;

import java.io.*;
import java.util.*;



class CSVWriter {
    public static void writeCSV(String filePath, List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n"); // Header
            for (Employee emp : employees) {
                writer.write(emp.toString() + "\n");
            }
            System.out.println("CSV file written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ankit", "HR", 50000),
                new Employee(2, "Anand", "Engineering", 70000),
                new Employee(3, "Aakrati", "Marketing", 60000),
                new Employee(4, "Avinash", "Finance", 65000),
                new Employee(5, "Yaman", "Sales", 55000)
        );

        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/basicproblems/writecsv/data.csv";
        writeCSV(filePath, employees);
    }
}

