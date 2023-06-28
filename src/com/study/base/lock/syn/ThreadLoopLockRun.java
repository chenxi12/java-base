package com.study.base.lock.syn;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/26 17:00
 */
@Data
public class ThreadLoopLockRun {
    private static int number = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            do {
                lock.lock();
                try {
                    // 同步代码块
                    if (number % 2 == 0) {
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "--" + number++);
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } while (number < 10);
        }, "A").start();

        new Thread(() -> {
            do {
                lock.lock();
                try {
                    if (number % 2 != 0) {
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "--" + number++);
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } while (number < 10);
        }, "B").start();
    }
}
