package com.javatechie.report.chiper;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDecryptor {

    public static void main(String[] args) {
//        String encryptedText_ = "tz2U1iuDuVH4vMmgNJ55oA=="; // Replace with the encrypted text from JavaScript
//        String encryptedText_ = "8pz3UuSOtbqqd1WJk/NByw=="; // Replace with the encrypted text from JavaScript
        String encryptedText_ = "otvdOTPtAAtQG2tH2V4QoA=="; // Replace with the encrypted text from JavaScript

        try {
            String key = "YourSecretKey123"; // Replace with your own key
            String iv = "YourIV1234567890"; // Replace with your own IV

            // Convert the key and IV strings to bytes
            byte[] keyBytes = key.getBytes("UTF-8");
            byte[] ivBytes = iv.getBytes("UTF-8");

            // Decode Base64-encoded encrypted text
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText_);

            // Create the key and IV specs
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            // Initialize the cipher for decryption
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            // Decrypt the ciphertext
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // Convert the decrypted bytes to plaintext and print
            String decryptedText = new String(decryptedBytes, "UTF-8");
            System.out.println("Decrypted: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String Dchiphar(String encryptedText){
        String decryptedText=encryptedText;
        try {
            String key = "YourSecretKey123"; // Replace with your own key
            String iv = "YourIV1234567890"; // Replace with your own IV

            // Convert the key and IV strings to bytes
            byte[] keyBytes = key.getBytes("UTF-8");
            byte[] ivBytes = iv.getBytes("UTF-8");

            // Decode Base64-encoded encrypted text
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

            // Create the key and IV specs
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            // Initialize the cipher for decryption
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            // Decrypt the ciphertext
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // Convert the decrypted bytes to plaintext and print
            decryptedText = new String(decryptedBytes, "UTF-8");
            System.out.println("Decrypted: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }

}
