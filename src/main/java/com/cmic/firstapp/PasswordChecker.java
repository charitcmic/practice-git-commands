package com.cmic.firstapp;

public class PasswordChecker {
    /**
     * Checks if the provided password meets the following criteria:
     * <ul>
     *   <li>Is at least 8 characters long</li>
     *   <li>Is at most 20 characters long</li>
     *   <li>Contains at least one digit (0-9)</li>
     *   <li>Contains at least one uppercase letter (A-Z)</li>
     *   <li>Contains at least one lowercase letter (a-z)</li>
     * </ul>
     *
     * @param password the password string to validate
     * @return {@code true} if the password meets all criteria, {@code false} otherwise
     */
    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        // Check if the password is at most 20 characters long
        if (password.length() > 20) {
            return false;
        }
        
        // Check if the password contains at least 1 number
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if the password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if the password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        return true;
    }


    /**
     * Checks the validity of the provided password according to the following rules:
     * <ul>
     *   <li>Password must be at least 8 characters long.</li>
     *   <li>Password must be at most 20 characters long.</li>
     *   <li>Password must contain at least one number.</li>
     *   <li>Password must contain at least one uppercase letter.</li>
     *   <li>Password must contain at least one lowercase letter.</li>
     * </ul>
     * If the password does not meet any of these requirements, an {@link Exception} is thrown
     * with a message indicating the reason for failure.
     *
     * @param password the password string to check
     * @throws Exception if the password does not meet the specified requirements
     */
    public void checkPasswordAndThrowReason(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("Password must be at least 8 characters long.");
        }

        if (password.length() > 20) {
            throw new Exception("Password must be at most 20 characters long.");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new Exception("Password must contain at least one number.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new Exception("Password must contain at least one uppercase letter.");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new Exception("Password must contain at least one lowercase letter.");
        }
    }
}
