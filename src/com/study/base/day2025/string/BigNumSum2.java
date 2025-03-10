package com.study.base.day2025.string;

/**
 * 如果两个字符串长度不一致，较短的字符串在高位补零
 *
 * @author LiBing
 * @since 2025-03-10 下午8:08
 */
public class BigNumSum2 {
    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "99";

        String sum = bigSum(str1, str2);
        System.out.println(sum);
    }

    private static String bigSum(String str1, String str2) {
        // 用于存储结果
        StringBuilder result = new StringBuilder();

        // 初始化进位为 0
        int carry = 0;

        int i = str1.length() - 1;
        int j = str2.length() - 1;

        //缺位补0
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? str1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? str2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            int num = sum % 10;

            result.append(num);
            carry = sum / 10;
        }
        return result.reverse().toString();
    }
}
