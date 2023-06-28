package com.study.base.string;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/20 10:44
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverse(str));
    }

    private static String reverse(String string) {
        if (Objects.isNull(string)) {
            return "";
        }
        byte[] bytes = string.getBytes();
        int startIndex = bytes.length - 1;
        for (int i = 0; i < startIndex >> 1; i++) {
            byte temp = bytes[i];
            bytes[i] = bytes[startIndex - i];
            bytes[startIndex - i] = temp;
        }

        return new String(bytes);
    }
}
