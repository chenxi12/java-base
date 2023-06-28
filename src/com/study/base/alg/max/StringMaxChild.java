package com.study.base.alg.max;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description：最大子串
 * @Author：libing
 * @Date：2023/6/25 15:00
 */
public class StringMaxChild {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // 存放字符
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        int max = 0; // 最大不重复字符长度
        int left = 0; // 上一个重复字符所在的位置（数组下标 + 1）
        for(int i = 0; i < s.length(); i++) {
            // 判断在map 中是否已经保存过字符
            if(map.containsKey(s.charAt(i))) {
                // 取最大值： map.get(s.charAt(i)) + 1 表示上一个重复字符的位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 记录每个字符位置，如果重复则覆盖
            map.put(s.charAt(i), i);
            // 记录最大的不重复字符串长度。
            // (i - left + 1 ) == (i+1 - left) 表示：当前阶段最大的不重复字符串长度, + 1 的原因是 数组下标为0
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcdchijk";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    public int sub(String s) {
        // 定义一个map保存字符与坐标信息
        Map<Character, Integer> map = new HashMap<>();
        // 最大长度
        int maxLength = 0;
        int num = s.length();
        int start = -1, end = 0;

        // 当前字符
        char curChar;
        for (; end < num; end++) {
            curChar = s.charAt(end);
            // 校验字符在map中是否存在
            if (map.containsKey(curChar)) {
                // 已存在，则需要将start向后滑动
                start = Math.max(map.get(curChar), start);
            }
            maxLength = Math.max(maxLength, end - start);
            map.put(curChar, end);
        }
        return maxLength;
    }
}
