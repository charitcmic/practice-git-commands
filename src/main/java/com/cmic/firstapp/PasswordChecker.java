package com.cmic.firstapp;

public class PasswordChecker {
    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        // Check if the password is at most 20 characters long
        if (password.length() > 20) {
            return false;
        }

        return true;
    }

    
}
