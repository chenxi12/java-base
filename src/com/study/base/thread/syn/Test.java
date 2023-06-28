package com.study.base.thread.syn;

import java.util.concurrent.TimeUnit;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/19 14:53
 */
public class Test {

    synchronized static void print() {
        System.out.println("Hello");
        try {
            Thread.sleep(1000L * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(Test::print).start();
        new Thread(Test::print).start();
        new Thread(Test::print).start();
    }
}
