package com.ioprogramming.day01csvdatahandling.intermediateproblems.sortcsv;

import java.io.*;
import java.util.*;

class CSVSorter {
    public static List<String> sortEmployeesBySalary(String filePath) {
        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // Read header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    employeeData.add(data);
                }
            }

            // Sort employees by salary (descending order)
            employeeData.sort((a, b) -> Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim())));

            // Prepare output list with top 5 employees
            List<String> result = new ArrayList<>();
            result.add(header); // Add header
            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                result.add(String.join(",", employeeData.get(i)));
            }
            return result;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/intermediateproblems/sortcsv/employees.csv";
        List<String> sortedEmployees = sortEmployeesBySalary(filePath);

        System.out.println("Top 5 Highest-Paid Employees:");
        for (String record : sortedEmployees) {
            System.out.println(record);
        }
    }
}

