//package com.javatechie.report.chiper;
//
//import org.springframework.web.bind.annotation.*;
//
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Base64;
//
//@RestController
//@RequestMapping("/api")
//public class EncryptionController {
//
//    private static final String secretKey = "ThisIsA32ByteSecretKeyForAES1234"; // 32-byte secret key for AES-256
//
//    @PostMapping("/encrypt")
//    public String encryptText(@RequestBody String plainText) {
//        try {
//            SecretKey key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//
//            // Generate a random IV
//            byte[] ivBytes = new byte[cipher.getBlockSize()];
//            IvParameterSpec iv = new IvParameterSpec(ivBytes);
//
//            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
//            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
//
//            // Encode IV and ciphertext separately
//            String base64IV = Base64.getEncoder().encodeToString(iv.getIV());
//            String base64CipherText = Base64.getEncoder().encodeToString(encryptedBytes);
//
//            return base64IV + ":" + base64CipherText;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error encrypting text";
//        }
//    }
//
//    @PostMapping("/decrypt")
//    public String decryptText(@RequestBody String encryptedText) {
//        try {
//            SecretKey key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//
//            // Separate IV and ciphertext
//            String[] parts = encryptedText.split(":");
//            byte[] ivBytes = Base64.getDecoder().decode(parts[0]);
//            byte[] encryptedBytes = Base64.getDecoder().decode(parts[1]);
//
//            IvParameterSpec iv = new IvParameterSpec(ivBytes);
//            cipher.init(Cipher.DECRYPT_MODE, key, iv);
//            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
//
//            return new String(decryptedBytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error decrypting text";
//        }
//    }
//}
