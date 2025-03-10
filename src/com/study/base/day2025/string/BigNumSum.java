package com.study.base.day2025.string;

/**
 * @author LiBing
 * @since 2025-03-04 下午4:46
 */
public class BigNumSum {
    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "99";

        String sum = bigSum(str1, str2);
        System.out.println(sum);
    }

    private static String bigSum(String str1, String str2) {
        if (null == str1 || "".equals(str1)) {
            return str2;
        }
        if (null == str2 || "".equals(str2)) {
            return str1;
        }
        char[] bytes1 = str1.toCharArray();
        char[] bytes2 = str2.toCharArray();
        StringBuilder res = new StringBuilder("");
        //判断是否有进位
        boolean flag = false;
        int index1 = bytes1.length - 1;
        int index2 = bytes2.length - 1;
        while (index1 >= 0 && index2 >= 0) {
            int b1 = bytes1[index1--] - '0';
            int b2 = bytes2[index2--] - '0';
            int re = b1 + b2;
            re = flag ? re + 1 : re;
            flag = re >= 10;
            res.append(re % 10);
        }
        while (index1 >= 0) {
            int b1 = bytes1[index1--] - '0';
            int b2 = flag ? 1 : 0;
            b1 = b1 + b2;
            flag = b1 >= 10;
            res.append(b1 % 10);
        }
        while (index2 >= 0) {
            int b1 = bytes2[index2--] - '0';
            int b2 = flag ? 1 : 0;
            b1 = b1 + b2;
            flag = b1 >= 10;
            res.append(b1 % 10);
        }
        if (flag) {
            res.append("1");
        }
        return res.reverse().toString();
    }
}
