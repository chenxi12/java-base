package com.study.base.thread;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/14 13:29
 */
public class Demo {
    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; j < 5; j++) {
            int temp = i;
            i = i + 1;
            i = temp;
            System.out.println(i);
        }

    }
}
