package com.study.base.alg.sort;

import java.util.Arrays;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/14 16:17
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 5, 3, 4, 6, 2};
        //寻找最小元素
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    int temp = array[i];
                    array[i] = minValue;
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
