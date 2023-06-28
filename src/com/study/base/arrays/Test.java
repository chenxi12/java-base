package com.study.base.arrays;

import java.lang.reflect.Proxy;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/19 21:27
 */
public class Test {
    public static void main(String[] args) {
        PrintService printService = new PrintServiceImpl();
        PrintService proxy = PrintInvocationHandler.getProxy(printService);
        proxy.print();

    }
}
