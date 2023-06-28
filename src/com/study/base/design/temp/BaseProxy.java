package com.study.base.design.temp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 13:31
 */
public abstract class BaseProxy<T> implements InvocationHandler {
    private final T target;

    public BaseProxy(T target) {
        this.target = target;
    }

    public T getTarget() {
        return target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return this.invoke(method, objects);
    }

    protected abstract Object invoke(Method method, Object[] params) throws Throwable;


}
