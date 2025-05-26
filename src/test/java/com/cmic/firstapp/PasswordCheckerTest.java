package com.cmic.firstapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for the {@link PasswordChecker} class.
 * <p>
 * This test suite verifies the password validation logic implemented in the PasswordChecker.
 * The tests cover the following scenarios:
 * <ul>
 *     <li>Passwords that are too short (less than 8 characters).</li>
 *     <li>Passwords that are too long (more than 20 characters).</li>
 *     <li>Passwords missing at least one digit.</li>
 *     <li>Passwords missing at least one uppercase letter.</li>
 *     <li>Passwords missing at least one lowercase letter.</li>
 *     <li>Valid passwords that meet all requirements.</li>
 *     <li>Edge cases for minimum and maximum allowed password lengths.</li>
 * </ul>
 * <p>
 * Each test method asserts that the {@code checkPassword} method returns the expected result
 * for various input cases.
 */
class PasswordCheckerTest {

    private PasswordChecker checker;

    @BeforeEach
    public void setUp() {
        checker = new PasswordChecker();
    }

    @Test
    public void testPasswordTooShort() {
        assertFalse(checker.checkPassword("Abc1"));
        assertFalse(checker.checkPassword("A1b2C3"));
        assertFalse(checker.checkPassword("aB3"));
    }

    @Test
    public void testPasswordTooLong() {
        String longPassword = "Abcdefghijklmnopqrstu1"; // 21 chars
        assertFalse(checker.checkPassword(longPassword));
    }

    @Test
    public void testPasswordNoDigit() {
        assertFalse(checker.checkPassword("Abcdefgh"));
        assertFalse(checker.checkPassword("PasswordOnly"));
    }

    @Test
    public void testPasswordNoUppercase() {
        assertFalse(checker.checkPassword("abcdefgh1"));
        assertFalse(checker.checkPassword("password123"));
    }

    @Test
    public void testPasswordNoLowercase() {
        assertFalse(checker.checkPassword("ABCDEFGH1"));
        assertFalse(checker.checkPassword("PASSWORD123"));
    }

    @Test
    public void testPasswordValid() {
        assertTrue(checker.checkPassword("Abcdefg1"));
        assertTrue(checker.checkPassword("A1bcdefgh"));
        assertTrue(checker.checkPassword("Password123"));
        assertTrue(checker.checkPassword("A1b2C3d4"));
        assertTrue(checker.checkPassword("ValidPASS123"));
    }

    @Test
    public void testPasswordEdgeLengths() {
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