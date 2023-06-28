package com.study.base.lock.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/26 19:56
 */
public class ThreadLoopLockABC {
    private static int number = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {

            lock.lock();
            try {
                do {
                    if (number % 3 != 1) {
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    conditionB.signal();
                    number++;
                } while (number < 29);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                do {
                    if (number % 3 != 2) {
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    conditionC.signal();
                    number++;
                } while (number < 30);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();

        new Thread(() -> {
            lock.lock();
            try {
                do {
                    if (number % 3 != 0) {
                        conditionC.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("------------------");
                    conditionA.signal();
                    number++;
                } while (number < 30);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }
}
