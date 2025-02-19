package com.ioprogramming.day02jsondata.handsonpracticeproblems.readjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class JsonReaderExample {

    public static void printJsonKeysAndValues(File jsonFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            printJsonRecursive(rootNode, "");
        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }

    private static void printJsonRecursive(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonRecursive(field.getValue(), prefix + field.getKey() + ": ");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJsonRecursive(node.get(i), prefix + "[" + i + "]: ");
            }
        } else {
            System.out.println(prefix + node.asText());
        }
    }

    public static void main(String[] args) {
        File jsonFile = new File("src/main/java/com/ioprogramming/day02jsondata/handsonpracticeproblems/readjson/data.json");
        printJsonKeysAndValues(jsonFile);
    }
}


