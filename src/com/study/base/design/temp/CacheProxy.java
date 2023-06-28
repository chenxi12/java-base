package com.study.base.design.temp;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 13:39
 */
public class CacheProxy extends BaseProxy<Object> {

    private CacheProxy(Object target) {
        super(target);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getCacheProxy(T cache) {
        return (T) Proxy.newProxyInstance(cache.getClass().getClassLoader(), cache.getClass().getInterfaces(), new CacheProxy(cache));
    }

    @Override
    protected Object invoke(Method method, Object[] params) throws Throwable {
        System.out.println("pre do something");
        //
        Object invoke = method.invoke(this.getTarget(), params);
        System.out.println("after do something");
        return invoke;
    }
}
