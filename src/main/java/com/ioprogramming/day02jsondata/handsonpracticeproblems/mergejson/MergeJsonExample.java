package com.ioprogramming.day02jsondata.handsonpracticeproblems.mergejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonExample {

    public static String mergeJsonObjects(String json1, String json2) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node1 = objectMapper.readTree(json1);
            JsonNode node2 = objectMapper.readTree(json2);

            // Merge the two JSON objects
            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) node1);
            mergedNode.setAll((ObjectNode) node2);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
        } catch (Exception e) {
            return "Error merging JSON: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String json1 = "{ \"name\": \"Ankit\", \"email\": \"ankit@example.com\" }";
        String json2 = "{ \"age\": 25, \"city\": \"Bhopal\" }";

        String mergedJson = mergeJsonObjects(json1, json2);
        System.out.println("Merged JSON:\n" + mergedJson);
    }
}

