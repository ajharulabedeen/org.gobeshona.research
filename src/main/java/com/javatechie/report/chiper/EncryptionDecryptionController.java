package com.javatechie.report.chiper;

import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class EncryptionDecryptionController {

    private static final String key = "YourSecretKey123"; // Replace with your own key
    private static final String iv = "YourIV1234567890"; // Replace with your own IV

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody String data) {
        try {
            byte[] keyBytes = key.getBytes("UTF-8");
            byte[] ivBytes = iv.getBytes("UTF-8");

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encryptedBytes = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while encrypting: " + e.getMessage();
        }
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody String encryptedData) {
        String text = "";
        String encryptedText_ = encryptedData; // Replace with the encrypted text from JavaScript

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
            text =  decryptedText;
            System.out.println("Decrypted: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
