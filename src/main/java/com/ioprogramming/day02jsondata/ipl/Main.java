package com.ioprogramming.day02jsondata.ipl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jsonInputFile = "src/main/java/com/ioprogramming/day02jsondata/ipl/ipl_matches.json";
        String jsonOutputFile = "src/main/java/com/ioprogramming/day02jsondata/ipl/censored_ipl_matches.json";
        String csvInputFile = "src/main/java/com/ioprogramming/day02jsondata/ipl/ipl_matches.csv";
        String csvOutputFile = "src/main/java/com/ioprogramming/day02jsondata/ipl/censored_ipl_matches.csv";

        // Process JSON
        List<IPLMatch> matchesJson = IPLJsonProcessor.readJson(jsonInputFile);
        List<IPLMatch> censoredJsonMatches = IPLCensorService.applyCensorship(matchesJson);
        IPLJsonProcessor.writeJson(jsonOutputFile, censoredJsonMatches);
        System.out.println("Censored JSON saved to: " + jsonOutputFile);

        // Process CSV
        List<IPLMatch> matchesCsv = IPLCsvProcessor.readCsv(csvInputFile);
        List<IPLMatch> censoredCsvMatches = IPLCensorService.applyCensorship(matchesCsv);
        IPLCsvProcessor.writeCsv(csvOutputFile, censoredCsvMatches);
        System.out.println("Censored CSV saved to: " + csvOutputFile);
    }
}

