package com.study.base.thread;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/13 21:44
 */
public class AtomicDemo implements Runnable {
    private int serialNumber = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber++;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }


}
