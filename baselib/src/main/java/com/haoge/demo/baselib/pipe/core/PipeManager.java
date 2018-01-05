package com.haoge.demo.baselib.pipe.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于管理各个组件的数据通道的管理器。
 */
public final class PipeManager {

    private static Map<Class,Pipe> pipes = new HashMap<>();
    public static  <T extends Pipe> T get (Class<T> clz) {
        if (!clz.isInterface()) {
            throw new RuntimeException(String.format("clz %s should be a interface class",clz.getCanonicalName()));
        }

        T pipe = findPipeFromMap(clz);
        if (pipe == null) {
            // to avoid NullPointException.returns a default proxy instance to be used
            //noinspection unchecked
            return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz},DefaultInvocationHandler.get());
        }
        return pipe;
    }

    /**
     * 注册Pipe实例到对应的协议接口上。
     */
    public static <T extends Pipe> void register (Class<T> clz,T t) {
        putIntoPipeMap(clz,t);
    }

    /**
     * 判断此clz是否已被注册。可供使用
     */
    public static boolean isRegister(Class clz) {
        return findPipeFromMap(clz) != null;
    }

    private static <T extends Pipe> T findPipeFromMap(Class<T> clz) {

        //noinspection unchecked
        T obj = (T) pipes.get(clz);
        if (obj == null) {
            pipes.remove(clz);
            return null;
        }
        return obj;
    }

    private static <T extends Pipe> void putIntoPipeMap (Class<T> clz,T t) {
        pipes.remove(clz);
        //noinspection unchecked
        pipes.put(clz, t);
    }

    private static class DefaultInvocationHandler implements InvocationHandler {
        private static DefaultInvocationHandler instance = new DefaultInvocationHandler();
        public static DefaultInvocationHandler get () {
            return instance;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            triggerCallback(args);
            return getBasicReturns(method);
        }

        private void triggerCallback(Object[] args) {
            for (int i = 0; i < (args == null ? 0 : args.length); i++) {
                Object arg = args[i];
                if (arg != null && arg instanceof PipeCallback) {
                    PipeCallback callback = (PipeCallback) arg;
                    callback.onError(new PipeException("You've not registered for this pipe class"));
                }
            }
        }

        Object getBasicReturns (Method method) {
            Class<?> returnType = method.getReturnType();
            if (returnType == int.class) {
                return 0;
            } else if (returnType == boolean.class) {
                return false;
            } else if (returnType == byte.class) {
                return (byte)0;
            } else if (returnType == short.class) {
                return (short)0;
            } else if (returnType == long.class) {
                return (long)0;
            } else if (returnType == char.class) {
                return (char)0;
            } else if (returnType == float.class) {
                return (float)0;
            } else if (returnType == double.class) {
                return (double)0;
            } else if (returnType == String.class) {
                return "";// avoid NullPointException
            } else {
                return null;
            }
        }
    }
}
