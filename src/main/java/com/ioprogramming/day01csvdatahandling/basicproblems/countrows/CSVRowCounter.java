package com.ioprogramming.day01csvdatahandling.basicproblems.countrows;

import java.io.*;

class CSVRowCounter {
    public static int countRows(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        String filePath = "src\\main\\java\\com\\ioprogramming\\day01csvdatahandling\\basicproblems\\countrows\\data.csv";
        int rowCount = countRows(filePath);
        System.out.println("Total records (excluding header): " + rowCount);
    }
}

