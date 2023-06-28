package com.study.base.function;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/14 21:28
 */
public class ParallelStream {
    public static void main(String[] args) {
        long b=System.currentTimeMillis();
        //71ms
		IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrime).count();
		//354ms
//        IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).count();
        long e=System.currentTimeMillis();
        System.out.println("spend:"+(e-b)+"ms");
        try {
            return;
        }finally {
            System.out.println("123");
        }
    }
}
