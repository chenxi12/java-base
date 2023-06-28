package com.study.base.lock.syn;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/26 20:39
 */
public class Test {
    public static void main(String[] args) {

        final AlternateDemo ad = new AlternateDemo();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                ad.loopA(i);
            }

        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                ad.loopB(i);
            }

        },"B").start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                ad.loopC(i);
            }
        },"C").start();

    }
}
