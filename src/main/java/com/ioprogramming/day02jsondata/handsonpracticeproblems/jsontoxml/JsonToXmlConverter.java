package com.ioprogramming.day02jsondata.handsonpracticeproblems.jsontoxml;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {

    public static String convertJsonToXml(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            return XML.toString(json, "root");
        } catch (Exception e) {
            System.out.println("Error converting JSON to XML: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Ankit\", \"age\": 24, \"email\": \"ankit@example.com\" }";

        String xmlResult = convertJsonToXml(jsonString);
        System.out.println("Converted XML:\n" + xmlResult);
    }
}

