package com.javatechie.report.chiper;

import java.util.Random;

public class ChyperShao_Vai {

    public static String randomPassword(){
        String SALTCHARS = "ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890";


        StringBuilder salt = new StringBuilder();
        Random random = new Random();

        while (salt.length()<18){
            int index= (int) (random.nextFloat()*SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        String saltStr = salt.toString();
        return saltStr;
    }
}
