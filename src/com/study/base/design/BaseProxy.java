package com.study.base.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 9:54
 */
public abstract class BaseProxy<T> implements InvocationHandler {
    private final T proxy;

    public BaseProxy(T proxy) {
        this.proxy = proxy;
    }

    public T getProxy() {
        return proxy;
    }

    public abstract Object invoke(Method method, Object[] params) throws Throwable;

    @Override
    public Object invoke(Object obj, Method method, Object[] param) throws Throwable {
        return this.invoke(method, param);
    }

}
