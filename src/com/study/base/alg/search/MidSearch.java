package com.study.base.alg.search;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/22 14:11
 */
public class MidSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8};
        int target = 1;
        System.out.println(getIndex(arr, target));
    }

    private static int getIndex(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = (endIndex + startIndex) >> 1;
            int value = arr[midIndex];
            if (value == target) {
                return midIndex;
            }
            if (target < value) {
                endIndex = midIndex - 1;
            }
            if (target > value) {
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }

}


