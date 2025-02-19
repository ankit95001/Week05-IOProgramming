package com.ioprogramming.day02jsondata.ipl;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class IPLCensorServiceTest {

    @Test
    void testCensorshipOnMultipleMatches() {
        // Create sample matches
        List<IPLMatch> matches = new ArrayList<>();

        Map<String, Integer> scores1 = new HashMap<>();
        scores1.put("Mumbai Indians", 178);
        scores1.put("Chennai Super Kings", 182);

        IPLMatch match1 = new IPLMatch(101, "Mumbai Indians", "Chennai Super Kings", scores1, "Chennai Super Kings", "MS Dhoni");

        Map<String, Integer> scores2 = new HashMap<>();
        scores2.put("Royal Challengers Bangalore", 200);
        scores2.put("Delhi Capitals", 190);

        IPLMatch match2 = new IPLMatch(102, "Royal Challengers Bangalore", "Delhi Capitals", scores2, "Royal Challengers Bangalore", "Virat Kohli");

        matches.add(match1);
        matches.add(match2);

        // Apply censorship
        IPLCensorService.applyCensorship(matches);

        // Verify team name masking
        assertEquals("Mumbai ***", match1.getTeam1());
        assertEquals("Chennai ***", match1.getTeam2());
        assertEquals("Royal ***", match2.getTeam1());
        assertEquals("Delhi ***", match2.getTeam2());

        // Verify player name redaction
        assertEquals("REDACTED", match1.getPlayer_of_match());
        assertEquals("REDACTED", match2.getPlayer_of_match());
    }
}

