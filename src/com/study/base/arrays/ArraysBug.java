package com.study.base.arrays;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/27 13:16
 */
public class ArraysBug {

    public static void main(String[] args) {
        //Arrays asList得到的List不能有改变元素个数的行为包括add,remove,clear
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.add(5);

        List<Integer> integers1 = Objects.requireNonNull(integers);

        System.out.println(Arrays.toString(integers.toArray()));

    }
}
