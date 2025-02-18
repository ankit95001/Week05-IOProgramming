package com.ioprogramming.day01csvdatahandling.extra.detectduplicates;

import java.io.*;
import java.util.*;

class DuplicateCSVChecker {
    public static void detectDuplicates(String filePath) {
        Map<String, String> recordMap = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            System.out.println("Header: " + line);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();

                if (recordMap.containsKey(id)) {
                    duplicates.add(line);
                } else {
                    recordMap.put(id, line);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String duplicate : duplicates) {
                    System.out.println(duplicate);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/extra/detectduplicates/large_dataset.csv"; // Ensure this file exists
        detectDuplicates(filePath);
    }
}

