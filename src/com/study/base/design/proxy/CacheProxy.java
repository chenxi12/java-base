package com.study.base.design.proxy;

import com.study.base.design.BaseProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 10:03
 */
public class CacheProxy extends BaseProxy<Object> {
    private CacheProxy(Object proxy) {
        super(proxy);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getCacheProxy(T cache) {
        if (Objects.isNull(cache)) {
            return null;
        }
        return (T) Proxy.newProxyInstance(cache.getClass().getClassLoader(), cache.getClass().getInterfaces(), new CacheProxy(cache));
    }

    @Override
    public Object invoke(Method method, Object[] params) throws Throwable {
        System.out.println("白日依山尽");
        Object invoke = method.invoke(this.getProxy(), params);
        System.out.println("欲穷千里目");
        return invoke;
    }
}
