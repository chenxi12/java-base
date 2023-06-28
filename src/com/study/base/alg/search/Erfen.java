package com.study.base.alg.search;

/**
 * @Description： 二分查找
 * @Author：libing
 * @Date：2023/5/29 11:20
 */
public class Erfen {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 8};
        int target = 6;

        //查找7的位置
        int startIndex = 0;
        int endIndex = ints.length - 1;
        while (startIndex < endIndex) {
            int midIndex = (endIndex + startIndex) >> 1;
            int value = ints[midIndex];
            if (target == value) {
                System.out.println(midIndex);
                return;
            }
            if (target < value) {
                endIndex = midIndex - 1;
            }
            if (target > value) {
                startIndex = midIndex + 1;
            }
        }
    }
}
