package com.study.base.string;

import java.util.Stack;

/**
 * @Description： 字符串反转
 * @Author：libing
 * @Date：2023/5/27 11:04
 */
public class StringReverseDemo {
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverse1(str));
        System.out.println(reverse2(str));
        System.out.println(reverse3(str));
    }

    private static String reverse1(String str) {
        if ("".equals(str) || null == str) {
            return "";
        }
        byte[] bytes = str.getBytes();
        int strIndex = str.length() - 1;
        for (int i = 0; i < strIndex >> 1; i++) {
            byte temp = bytes[i];
            bytes[i] = bytes[strIndex - i];
            bytes[strIndex - i] = temp;
        }
        return new String(bytes);
    }

    /**
     * 双指针法
     *
     * @param str
     * @return
     */
    private static String reverse2(String str) {
        if ("".equals(str) || null == str) {
            return "";
        }
        byte[] bytes = str.getBytes();
        int startIndex = 0;
        int lastIndex = str.length() - 1;
        while (startIndex < lastIndex) {
            byte temp = bytes[startIndex];
            bytes[startIndex] = bytes[lastIndex];
            bytes[lastIndex] = temp;
            startIndex++;
            lastIndex--;
        }
        return new String(bytes);
    }

    /**
     * 栈
     *
     * @param str
     * @return
     */
    private static String reverse3(String str) {
        if ("".equals(str) || null == str) {
            return "";
        }
        var result = new StringBuilder();
        char[] bytes = str.toCharArray();
        Stack<Character> byteStack = new Stack<>();
        for (int i = 0; i < bytes.length; i++) {
            byteStack.push(bytes[i]);
        }
        while (!byteStack.empty()){
            char pop = byteStack.pop();
            result.append(pop);
        }
        return result.toString();
    }


}
