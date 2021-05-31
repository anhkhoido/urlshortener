package com.anhkhoido.shortener.urlshortener.businessRule;

import java.util.Random;

public class ShortUrlMaker {
    public static String generateTruncatedUrl(String address) {
        String result = address.substring(0, address.indexOf("/") + 2);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int choice = random.nextInt(3);
            if (choice == 0) {
                result += generateRandomLowercaseLetter();
            } else if (choice == 1) {
                result += generateRandomUppercaseLetter();
            } else if (choice == 2) {
                result += generateRandomDigit();
            }
        }
        return result;
    }

    private static String generateRandomLowercaseLetter() {
        Random random = new Random();
        int code = random.nextInt((122 - 97) + 1) + 1;
        String letter = Character.toString(code);
        return letter;
    }

    private static String generateRandomUppercaseLetter() {
        Random random = new Random();
        int code = random.nextInt((90 - 65) + 1) + 1;
        String letter = Character.toString(code);
        return letter;
    }

    private static String generateRandomDigit() {
        Random random = new Random();
        int code = random.nextInt((57 - 48) + 1) + 1;
        String digit = Character.toString(code);
        return digit;
    }
}
