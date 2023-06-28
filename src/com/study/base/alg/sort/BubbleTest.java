package com.study.base.alg.sort;

import java.util.Arrays;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/14 15:30
 */
public class BubbleTest {
    public static void main(String[] args) {
        int[] array = {5, 5, 3, 4, 6, 2};
        //循环次数
        for (int i = 0; i < array.length - 1; i++) {
            //一轮出一个最大的
            for (int j = 0; j < array.length - 1 - i; j++) {
                //可以理解为双指针同步数后移一位
                //后者大于前者 ，交换位置
                if (array[j + 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
