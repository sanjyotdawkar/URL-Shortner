package com.shortener;


import java.util.Random;

public class HashGenerator {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateHash() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return sb.toString();
    }
}
