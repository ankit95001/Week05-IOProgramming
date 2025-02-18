package com.ioprogramming.day01csvdatahandling.advancedproblems.validatecsv;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class CSVValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    public static void validateCSV(String filePath) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            System.out.println(header);
            String line;
            int rowNumber = 1;

            while ((line = br.readLine()) != null) {
                rowNumber++;
                String[] data = line.split(",");
                if (data.length < 4) {
                    System.out.println("Row " + rowNumber + ": Invalid number of columns - " + line);
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                boolean isValidEmail = emailPattern.matcher(email).matches();
                boolean isValidPhone = phonePattern.matcher(phone).matches();

                if (!isValidEmail || !isValidPhone) {
                    System.out.println("Row " + rowNumber + " is invalid: " + line);
                    if (!isValidEmail) {
                        System.out.println("Invalid Email: " + email);
                    }
                    if (!isValidPhone) {
                        System.out.println("Invalid Phone Number: " + phone);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/day01csvdatahandling/advancedproblems/validatecsv/employees.csv";
        validateCSV(filePath);
    }
}

