package com.study.base.function;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/14 21:29
 */
public class PrimeUtil {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; Math.sqrt(number) >= i; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
