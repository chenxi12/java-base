package com.study.base.design.proxy;

import com.study.base.design.PrintService;
import com.study.base.design.PrintServiceImpl;
import com.study.base.design.ProxyInvocationHandler;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 10:06
 */
public class ProxyTest {
    public static void main(String[] args) {
        PrintService printService = new PrintServiceImpl();
//        PrintService cacheProxy = CacheProxy.getCacheProxy(printService);
        PrintService cacheProxy1 = ProxyInvocationHandler.getProxy(printService);
        cacheProxy1.print();
    }
}
