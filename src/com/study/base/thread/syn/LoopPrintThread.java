package com.study.base.thread.syn;


/**
 * @Description： a 打印 1357 b 打印2468
 * @Author：libing
 * @Date：2023/6/19 15:24
 */
public class LoopPrintThread {
    private final static Object LOCK = new Object();
    private static int num;
    private static int maxnum = 100;

     void print(int targetNum) {
         while (true) {
             synchronized (LOCK) {
                 while (num % 3 != targetNum) {
                     if (num >= maxnum) {
                         break;
                     }
                     try {
                         LOCK.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 if (num >= maxnum) {
                     break;
                 }
                 num++;
                 System.out.println(Thread.currentThread().getName() + ": " + num);
                 LOCK.notifyAll();
             }
         }
    }

    public static void main(String[] args) {
        LoopPrintThread loopPrintThread = new LoopPrintThread();
        new Thread(() -> {
            loopPrintThread.print(0);
        }, "A").start();
        new Thread(() -> {
            loopPrintThread.print(1);
        }, "B").start();
        new Thread(() -> {
            loopPrintThread.print(2);
        }, "C").start();
    }
}
