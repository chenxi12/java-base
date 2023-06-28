package com.study.base.alg.sort;

import java.util.Arrays;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/14 17:07
 */
public class QuickSort {

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int k = arr[start];
        int i = start, j = end;
        while (i != j) {
            while (i < j && arr[j] >= k)
                --j;
            swap(arr, i, j);
            while (i < j && arr[i] <= k)
                ++i;
            swap(arr, i, j);
        }
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 0, 1, 0, 3, -1, 23, -56, 7};
        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(arr, 0, arr.length - 1);
        quickSort.quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void quick(int[] arr, int start, int end) {
        //每次递归都是从0开始最后一个结束所以暂存起来
        if (start >= end)
            return;
        int i = start;
        int j = end;
        int key = arr[start];

        while (i != j) {
            //从右往左直到遇到比key小的值停止，然后交换值
            while (i < j && arr[j] >= key) {
                j--;
            }
            swap(arr, i, j);
            //从左网游找大值，然后交换值
            while (i < j && arr[i] <= key) {
                i++;
            }
            swap(arr, i, j);
        }
        //从中间两侧开始执行
        //左
        quick(arr, start, i - 1);
        //右
        quick(arr, j + 1, end);
    }


}
