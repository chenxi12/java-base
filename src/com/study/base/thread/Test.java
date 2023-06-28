package com.study.base.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/13 21:25
 */
public class Test {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }

}
