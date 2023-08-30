package com.meli.software.utils;

import java.util.Random;


public class FuncionesVarias {

    public String generateRandomUsePassAlpNum(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
    public String generateRandomNumMinor() {
        Random random = new Random();
        Integer numMinor = random.nextInt(17 - 3 + 1) + 3;
        String numMinorString = numMinor.toString();
        return numMinorString;
    }

    public String generateRandomNumMayor() {
        Random random = new Random();
        Integer numMayor = random.nextInt(80 - 18 + 1) + 18;
        String numMayorString = numMayor.toString();
        return numMayorString;
    }
}