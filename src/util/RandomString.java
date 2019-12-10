package util;

import java.util.Random;

public class RandomString {
    private static String allowedChars = "abcdefghijklmnopqrstuvwxyz 1234567890";
    public static String generateRandomString(int length) {
        String generatedString = "";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            int nextInt = r.nextInt(allowedChars.length());
            generatedString += allowedChars.charAt(nextInt);
        }
        return generatedString;
    }
}
