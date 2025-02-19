package com.ioprogramming.day02jsondata.ipl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class IPLMatchTest {

    private ObjectMapper objectMapper;
    private IPLMatch match;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();

        // Sample Score Data
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Mumbai Indians", 178);
        scores.put("Chennai Super Kings", 182);

        // Create a sample IPLMatch object
        match = new IPLMatch(101, "Mumbai Indians", "Chennai Super Kings", scores, "Chennai Super Kings", "MS Dhoni");
    }

    // ✅ Test JSON Serialization
    @Test
    void testSerializeIPLMatchToJson() throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(match);
        assertNotNull(json);
        assertTrue(json.contains("Mumbai Indians"));
        assertTrue(json.contains("Chennai Super Kings"));
    }

    // ✅ Test JSON Deserialization
    @Test
    void testDeserializeJsonToIPLMatch() throws JsonProcessingException {
        String json = """
        {
            "matchId": 101,
            "team1": "Mumbai Indians",
            "team2": "Chennai Super Kings",
            "score": {
                "Mumbai Indians": 178,
                "Chennai Super Kings": 182
            },
            "winner": "Chennai Super Kings",
            "playerOfMatch": "MS Dhoni"
        }
        """;

        IPLMatch deserializedMatch = objectMapper.readValue(json, IPLMatch.class);
        assertNotNull(deserializedMatch);
        assertEquals("Mumbai Indians", deserializedMatch.getTeam1());
        assertEquals("Chennai Super Kings", deserializedMatch.getWinner());
        assertEquals("MS Dhoni", deserializedMatch.getPlayer_of_match());
    }

    // ✅ Test Censorship Rule - Masking Team Names
    @Test
    void testCensorTeamNames() {
        IPLCensorService.applyCensorship(Collections.singletonList(match));

        assertEquals("Mumbai ***", match.getTeam1());
        assertEquals("Chennai ***", match.getTeam2());
    }

    // ✅ Test Censorship Rule - Redacting Player of the Match
    @Test
    void testCensorPlayerOfMatch() {
        IPLCensorService.applyCensorship(Collections.singletonList(match));

        assertEquals("REDACTED", match.getPlayer_of_match());
    }
}

