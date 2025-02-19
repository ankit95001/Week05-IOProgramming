package com.ioprogramming.day02jsondata.handsonpracticeproblems.jsontoxml;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JsonToXmlConverterTest {

    @Test
    public void testConvertJsonToXml() {
        String jsonString = "{ \"name\": \"Ankit\", \"age\": 24, \"email\": \"ankit@example.com\" }";
        String expectedXml = "<root><name>Ankit</name><age>24</age><email>ankit@example.com</email></root>";

        String actualXml = JsonToXmlConverter.convertJsonToXml(jsonString);
        assertEquals(expectedXml, actualXml);
    }

    @Test
    public void testInvalidJson() {
        String invalidJson = "{ name: \"Ankit\" ";
        assertNull(JsonToXmlConverter.convertJsonToXml(invalidJson));
    }
}

