package com.study.base.alg.arrays;

import java.util.Arrays;

/**
 * @Description： 数组合并
 * @Author：libing
 * @Date：2023/6/25 11:20
 */
public class MergeArrayTest {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {2, 4, 4, 5, 6, 8, 10};

        int[] mergeArray = mergeArray(a, b);

        int[] targetArray = mergeArrayQuickSort(a, b);
        System.out.println(Arrays.toString(targetArray));

        System.out.println(Arrays.toString(mergeArray));
    }

    private static int[] mergeArrayQuickSort(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            return b;
        }

        if (b == null || b.length == 0) {
            return a;
        }

        int i = a.length;
        int[] temp = Arrays.copyOf(a, a.length + b.length);
        for (int value : b) {
            temp[i] = value;
            i++;
        }
        return arraySort(temp);

    }

    private static int[] arraySort(int[] temp) {
        int start = 0;
        int end = temp.length - 1;
        quickSort(temp, start, end);
        return temp;
    }

    private static void quickSort(int[] temp, int start, int end) {
        if (end <= start) {
            return;
        }
        int i = start;
        int j = end;
        int key = temp[i];
        while (i != j) {
            //从右往左找小的换位置左移动
            while (i < j && temp[j] >= key) {
                j--;
            }
            swap(temp, i, j);
            //从左往右找大的的换位置右移动
            while (i < j && temp[i] <= key) {
                i++;
            }
            swap(temp, i, j);
        }
        quickSort(temp, start, i - 1);
        quickSort(temp, j + 1, end);
    }

    private static void swap(int[] array, int sourceIndex, int targetIndex) {
        int temp = array[sourceIndex];
        array[sourceIndex] = array[targetIndex];
        array[targetIndex] = temp;
    }

    private static int[] mergeArray(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            return b;
        }

        if (b == null || b.length == 0) {
            return a;
        }

        int[] target = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        //当两数组均未达到最大长度是比较两者之间最左边的元素小的放入新数组
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                target[k++] = a[i++];
            } else {
                target[k++] = b[j++];
            }
        }
        //当有任意一个数组提前结束则将剩余直接赋值
        while (i < a.length) {
            target[k++] = a[i++];
        }

        while (j < b.length) {
            target[k++] = b[j++];
        }
        return target;
    }
}
