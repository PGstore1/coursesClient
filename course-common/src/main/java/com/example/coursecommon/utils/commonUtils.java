package com.example.coursecommon.utils;

public class commonUtils {
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * str.length());
            char c = str.charAt(index);
            sb.append(c);
        }
        return sb.toString();
    }
}
