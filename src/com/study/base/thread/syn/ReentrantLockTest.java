package com.study.base.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/19 16:41
 */
public class ReentrantLockTest {
    private static ReentrantLock LOCK = new ReentrantLock();
    private static Condition oddA = LOCK.newCondition();
    private static Condition oddB = LOCK.newCondition();

    static int num = 1;


    public static void main(String[] args) {
        String str = "123";
        while (true) {
            new Thread(() -> {
                LOCK.lock();
                while (num % 2 == 0) {
                    try {
                        oddA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num > 10) {
                    return;
                }
                oddB.signal();
                System.out.println(Thread.currentThread().getName() + "--" + num++);
                LOCK.unlock();
            }, "A").start();


            new Thread(() -> {
                LOCK.lock();
                while (num % 2 != 0) {
                    try {
                        oddB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num > 10) {
                    return;
                }
                oddA.signal();
                System.out.println(Thread.currentThread().getName() + "--" + num++);

                LOCK.unlock();
            }, "B").start();
        }
    }
}
