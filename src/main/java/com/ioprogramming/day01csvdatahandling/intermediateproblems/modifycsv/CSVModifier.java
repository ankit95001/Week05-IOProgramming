package com.ioprogramming.day01csvdatahandling.intermediateproblems.modifycsv;

import java.io.*;
import java.util.*;

class CSVModifier {
    public static void updateSalaries(String inputFile, String outputFile) {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine();
            updatedLines.add(line); // Add header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String department = data[2].trim();
                    double salary = Double.parseDouble(data[3].trim());

                    if ("IT".equalsIgnoreCase(department)) {
                        salary *= 1.10;
                    }

                    updatedLines.add(String.format("%s,%s,%s,%.2f", data[0], data[1], department, salary));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String updatedLine : updatedLines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFile = "src/main/java/com/ioprogramming/day01csvdatahandling/intermediateproblems/modifycsv/employees.csv";
        String outputFile = "src/main/java/com/ioprogramming/day01csvdatahandling/intermediateproblems/modifycsv/updated_employees.csv";
        updateSalaries(inputFile, outputFile);
        System.out.println("Updated salaries saved in " + outputFile);
    }
}

