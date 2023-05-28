package com.study.base.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/27 13:16
 */
public class ArraysBug {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.add(5);

        System.out.println(Arrays.toString(integers.toArray()));

    }
}
