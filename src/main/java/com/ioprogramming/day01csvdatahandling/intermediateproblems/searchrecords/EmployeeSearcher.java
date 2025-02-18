package com.ioprogramming.day01csvdatahandling.intermediateproblems.searchrecords;

import java.io.*;

class EmployeeSearcher {
    public static String searchEmployee(String filePath, String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].trim().equalsIgnoreCase(name)) {
                    return String.format("Department: %s | Salary: %s", data[2].trim(), data[3].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return "Employee not found";
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/intermediateproblems/searchrecords/employees.csv";
        String nameToSearch = "Ankit";
        String result = searchEmployee(filePath, nameToSearch);
        System.out.println(result);
    }
}

