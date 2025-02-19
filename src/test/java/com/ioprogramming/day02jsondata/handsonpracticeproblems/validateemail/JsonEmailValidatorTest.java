package com.ioprogramming.day02jsondata.handsonpracticeproblems.validateemail;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JsonEmailValidatorTest {

    @Test
    public void testValidEmail() {
        String validJson = "{\"email\": \"ankit@example.com\"}";
        assertTrue(JsonEmailValidator.validateEmailJson(validJson));
    }

    @Test
    public void testInvalidEmail() {
        String invalidJson = "{\"email\": \"invalid-email\"}";
        assertFalse(JsonEmailValidator.validateEmailJson(invalidJson));
    }

    @Test
    public void testMissingEmailField() {
        String missingFieldJson = "{}";
        assertFalse(JsonEmailValidator.validateEmailJson(missingFieldJson));
    }
}

