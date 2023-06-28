package com.study.base.lock.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/26 20:37
 */
public class AlternateDemo  {
    private int num = 1;//当前正在执行线程的标记

    private Lock lock =  new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int loop){

        lock.lock();

        try {
            //1.判断
            if(num != 1){
                condition1.await();
            }

            //2.打印
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+"第"+loop+"轮"+"-第"+i+"次");
            }

            //3.唤醒
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void loopB(int loop){

        lock.lock();

        try {
            //1.判断
            if(num != 2){
                condition2.await();
            }

            //2.打印
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+"第"+loop+"轮"+"-第"+i+"次");
            }

            //3.唤醒
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void loopC(int loop){

        lock.lock();

        try {
            //1.判断
            if(num != 3){
                condition3.await();
            }

            //2.打印
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+"第"+loop+"轮"+"-第"+i+"次");
            }
            System.out.println("---------------------------");
            //3.唤醒
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
}
