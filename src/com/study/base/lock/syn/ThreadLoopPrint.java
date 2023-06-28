package com.study.base.lock.syn;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：A 1, 3, 5, 7, 9
 * @Author：libing
 * @Date：2023/6/26 16:09
 */
public class ThreadLoopPrint {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadLoopRun threadLoopRun = new ThreadLoopRun(lock);
        new Thread(threadLoopRun, "A").start();
        new Thread(threadLoopRun, "B").start();


//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("all Thread end....");
    }
}
