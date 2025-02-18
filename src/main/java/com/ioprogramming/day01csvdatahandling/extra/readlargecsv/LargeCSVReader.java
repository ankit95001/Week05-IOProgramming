package com.ioprogramming.day01csvdatahandling.extra.readlargecsv;

import java.io.*;

class LargeCSVReader {
    public static void readLargeCSVFile(String filePath, int chunkSize) {
        int recordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                recordCount++;
                batchCount++;

                System.out.println("Processing record: " + recordCount);

                if (batchCount == chunkSize) {
                    System.out.println("Processed " + chunkSize + " records so far...");
                    batchCount = 0;
                }
            }
            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/extra/readlargecsv/large_dataset.csv";
        int chunkSize = 100;
        readLargeCSVFile(filePath, chunkSize);
    }
}

