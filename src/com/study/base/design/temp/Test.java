package com.study.base.design.temp;

import com.study.base.design.PrintService;
import com.study.base.design.PrintServiceImpl;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 13:31
 */
public class Test {
    public static void main(String[] args) {
        PrintService printService = new PrintServiceImpl();
        PrintService cacheProxy = CacheProxy.getCacheProxy(printService);
        cacheProxy.print();
    }
}
