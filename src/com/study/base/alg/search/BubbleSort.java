package com.study.base.alg.search;

import java.util.Arrays;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/22 14:39
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 3, 3, 2, 1};
        int endIndex = arr.length - 1;
        for (int i = 0; i < endIndex; i++) {
            for (int j = 0; j < endIndex - i; j++) {
                int startValue = arr[j];
                int nextValue = arr[j + 1];
                if (startValue > nextValue) {
                    arr[j] = nextValue;
                    arr[j + 1] = startValue;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
