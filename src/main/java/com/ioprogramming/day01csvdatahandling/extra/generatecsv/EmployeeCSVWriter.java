package com.ioprogramming.day01csvdatahandling.extra.generatecsv;

import java.io.*;
import java.util.*;


class EmployeeCSVWriter {
    public static void writeToCSV(String filePath) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 60000),
                new Employee(2, "Bob", "HR", 50000),
                new Employee(3, "Charlie", "Finance", 70000),
                new Employee(4, "David", "IT", 65000),
                new Employee(5, "Emma", "Marketing", 55000)
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Employee ID,Name,Department,Salary"); // Writing header
            writer.newLine();

            for (Employee emp : employees) {
                writer.write(emp.toCSVString());
                writer.newLine();
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/extra/generatecsv/employees_report.csv";
        writeToCSV(filePath);
    }
}

