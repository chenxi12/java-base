package com.study.base.lock.syn;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/26 19:42
 */
public class ThreadLoopABC {
    private static final Object lock = new Object();

    private static int times = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            do {
                synchronized (lock) {
                    if (times % 3 == 1) {
                        lock.notifyAll();
                        System.out.println(Thread.currentThread().getName());
                        times++;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } while (times < 30);
        }, "A").start();

        new Thread(() -> {
            do {
                synchronized (lock) {
                    if (times % 3 == 2) {
                        lock.notifyAll();
                        System.out.println(Thread.currentThread().getName());
                        times++;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } while (times < 30);
        }, "B").start();

        new Thread(() -> {
            do {
                synchronized (lock) {
                    if (times % 3 == 0) {
                        lock.notifyAll();
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("-----");
                        times++;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } while (times < 30);

        }, "C").start();
    }
}
