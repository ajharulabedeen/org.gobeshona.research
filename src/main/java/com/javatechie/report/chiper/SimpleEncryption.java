package com.javatechie.report.chiper;

public class SimpleEncryption {

    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Check if the character is a digit
            if (Character.isDigit(c)) {
                // If it's a digit, add 4 to its ASCII value and convert back to char
                encrypted.append((char) (c + 4));
            } else {
                // For other characters, shift by 3 as before
                encrypted.append((char) (c + 3));
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String encrypted) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            // Check if the character is a digit
            if (Character.isDigit(c)) {
                // If it's a digit, subtract 4 to get back the original digit
                decrypted.append((char) (c - 4));
            } else {
                // For other characters, shift by 3 to decrypt as before
                decrypted.append((char) (c - 3));
            }
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        String originalString = "123456";
        String encryptedString = encrypt(originalString);
        System.out.println("Encrypted: " + encryptedString);

        String decryptedString = decrypt(encryptedString);
        System.out.println("Decrypted: " + decryptedString);
    }
}
