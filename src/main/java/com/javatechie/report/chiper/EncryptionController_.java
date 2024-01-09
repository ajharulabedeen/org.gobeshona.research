//package com.javatechie.report.controller;
//
//import com.javatechie.report.service.EncryptionExample;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class EncryptionController_ {
//
//    @PostMapping("/encrypt")
//    public String encryptText(@RequestBody String plainText) {
//        try {
//            System.out.println(plainText);
//            return EncryptionExample.encrypt(plainText);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error encrypting text";
//        }
//    }
//
//    @PostMapping("/decrypt")
//    public String decryptText(@RequestBody String encryptedText) {
//        try {
//            return EncryptionExample.decrypt(encryptedText);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error decrypting text";
//        }
//    }
//}