package com.study.base.alg.max;

/**
 * @Description： 连续子序列最大和 动态规划
 * @Author：libing
 * @Date：2023/6/22 18:56
 */
public class MaxSequence {
    private static int getMax(int[] array) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < array.length ; i++) {
            temp += array[i];
            if (temp <= 0) {
                temp = 0;
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array1 = {-1, -3, -2, -4, -5};
        int[] array2 = {1, -3, 2, 4, 5, -12, -5, 99};
        System.out.println(getMax(array1));
        System.out.println(getMax(array2));
    }
}
