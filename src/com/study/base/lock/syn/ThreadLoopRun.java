package com.study.base.lock.syn;

import lombok.Data;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/26 16:10
 */
@Data
public class ThreadLoopRun implements Runnable {
    private final Object lock;

    private int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (i >= 11) {
                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + " end...");
                    return;
                }
                if (i % 2 != 0 ) {
                    try {
                        lock.notifyAll();
                        System.out.println(Thread.currentThread().getName() + "--" + i++);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "--" + i++);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
