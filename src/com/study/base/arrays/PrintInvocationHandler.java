package com.study.base.arrays;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/19 21:25
 */
@AllArgsConstructor
public class PrintInvocationHandler<T> implements InvocationHandler {

    private final T target;

    private T getTarget() {
        return target;
    }

    public static <T> T getProxy(T cache) {
        return (T) Proxy.newProxyInstance(cache.getClass().getClassLoader(), cache.getClass().getInterfaces(), new PrintInvocationHandler(cache));
    }

    @Override
    public Object invoke(Object o, Method method, Object[] params) throws Throwable {
        System.out.println("查询缓存");
        return method.invoke(this.getTarget(), params);
    }


}
