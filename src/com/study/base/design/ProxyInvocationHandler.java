package com.study.base.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 10:57
 */
public class ProxyInvocationHandler<T> implements InvocationHandler {

    private final T target;

    private ProxyInvocationHandler(T target) {
        this.target = target;
    }

    private T getTarget() {
        return target;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(T cache) {
        if (Objects.isNull(cache)) {
            return null;
        }
        return (T) Proxy.newProxyInstance(cache.getClass().getClassLoader(), cache.getClass().getInterfaces(), new ProxyInvocationHandler(cache));
    }

    @Override
    public Object invoke(Object o, Method method, Object[] params) throws Throwable {
        //查询缓存如果不为空则返回,使用代理进行查缓存
        System.out.println("查询缓存");
        //执行查询数据库
        Object invoke = method.invoke(this.getTarget(), params);
        System.out.println("添加缓存");
        return invoke;
    }


}
