package com.study.base.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/14 20:42
 */
public class Test {
    public static void main(String[] args) {
        int[] attr = {1, 2, 3};

        Arrays.stream(attr).map(i -> i + 1).forEach(System.out::println);
        System.out.println("--------------------");
        Arrays.stream(attr).forEach(System.out::println);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
        Arrays.stream(attr).map(i -> i + 1).boxed().collect(Collectors.toList()).forEach(System.out::println);

        final int num = 2;
//        num++;
//        System.out.println(num);

        Function<Integer, Integer> function = (from) -> from * num;
        Integer apply = function.apply(3);
        System.out.println(apply);

        System.out.println(Math.sqrt(12));

    }
}
