package com.cmic.firstapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PasswordCheckerTest {

    private final PasswordChecker checker = new PasswordChecker();

    @Test
    void testPasswordTooShort() {
        assertFalse(checker.checkPassword("Abc1"));
        assertFalse(checker.checkPassword("A1b2C3"));
        assertFalse(checker.checkPassword("aB3"));
    }

    @Test
    void testPasswordTooLong() {
        String longPassword = "Abcdefghijklmnopqrstu1"; // 21 chars
        assertFalse(checker.checkPassword(longPassword));
    }

    @Test
    void testPasswordNoDigit() {
        assertFalse(checker.checkPassword("Abcdefgh"));
        assertFalse(checker.checkPassword("PasswordOnly"));
    }

    @Test
    void testPasswordNoUppercase() {
        assertFalse(checker.checkPassword("abcdefgh1"));
        assertFalse(checker.checkPassword("password123"));
    }

    @Test
    void testPasswordNoLowercase() {
        assertFalse(checker.checkPassword("ABCDEFGH1"));
        assertFalse(checker.checkPassword("PASSWORD123"));
    }

    @Test
    void testPasswordValid() {
        assertTrue(checker.checkPassword("Abcdefg1"));
        assertTrue(checker.checkPassword("A1bcdefgh"));
        assertTrue(checker.checkPassword("Password123"));
        assertTrue(checker.checkPassword("A1b2C3d4"));
        assertTrue(checker.checkPassword("ValidPASS123"));
    }

    @Test
    void testPasswordEdgeLengths() {
        // 8 chars, valid
        assertTrue(checker.checkPassword("A1bcdefg"));
        // 20 chars, valid
        assertTrue(checker.checkPassword("Abcdefghij123456KLMN"));
        // 7 chars, invalid
        assertFalse(checker.checkPassword("A1bcdef"));
        // 21 chars, invalid
        assertFalse(checker.checkPassword("Abcdefghij123456KLMNO"));
    }
}