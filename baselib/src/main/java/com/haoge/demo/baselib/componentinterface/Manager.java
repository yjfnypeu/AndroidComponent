package com.haoge.demo.baselib.componentinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by haoge on 2017/1/11.
 */

public class Manager {

    public static <T> T proxy (Class<T> clz) {
        boolean anInterface = clz.isInterface();
        if (!anInterface) return null;
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{clz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return null;
            }
        });
    }
}
