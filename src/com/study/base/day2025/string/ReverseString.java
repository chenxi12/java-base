package com.study.base.day2025.string;

/**
 * @author LiBing
 * @since 2025-02-28 下午6:05
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "abcdefg";
        String revStr = getRevStr(str);
        System.out.println(revStr);
    }

    private static String getRevStr(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        int startIndex = 0;
        int endIndex = str.length();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length >> 1; i++) {
            byte temp = bytes[i];
            endIndex = endIndex - 1;
            bytes[i] = bytes[endIndex];
            bytes[endIndex] = temp;
        }
        return new String(bytes);
    }
}
