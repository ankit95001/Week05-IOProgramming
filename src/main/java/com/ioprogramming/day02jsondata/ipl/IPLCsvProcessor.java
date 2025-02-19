package com.ioprogramming.day02jsondata.ipl;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class IPLCsvProcessor {

    public static List<IPLMatch> readCsv(String filePath) {
        List<IPLMatch> matches = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            records.remove(0); // Removing header row

            for (String[] row : records) {
                int match_id = Integer.parseInt(row[0]);
                String team1 = row[1];
                String team2 = row[2];
                int scoreTeam1 = Integer.parseInt(row[3]);
                int scoreTeam2 = Integer.parseInt(row[4]);
                String winner = row[5];
                String playerOfMatch = row[6];

                Map<String, Integer> scoreMap = new HashMap<>();
                scoreMap.put(team1, scoreTeam1);
                scoreMap.put(team2, scoreTeam2);

                matches.add(new IPLMatch(match_id, team1, team2, scoreMap, winner, playerOfMatch));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matches;
    }

    public static void writeCsv(String filePath, List<IPLMatch> matches) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"match_id", "team1", "team2", "score_team1", "score_team2", "winner", "player_of_match"});

            for (IPLMatch match : matches) {
                Integer score1 = match.getScore().get(match.getTeam1().replace(" ***", ""));
                Integer score2 = match.getScore().get(match.getTeam2().replace(" ***", ""));

                writer.writeNext(new String[]{
                        String.valueOf(match.getMatch_id()),
                        match.getTeam1(),
                        match.getTeam2(),
                        String.valueOf(score1),
                        String.valueOf(score2),
                        match.getWinner(),
                        match.getPlayer_of_match()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

