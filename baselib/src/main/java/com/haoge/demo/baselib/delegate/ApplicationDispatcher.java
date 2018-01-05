package com.haoge.demo.baselib.delegate;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class ApplicationDispatcher {

    private static LinkedList<IApplicationDelegate> container = new LinkedList<>();
    Application application;

    /**
     * 初始化。设置可用的Application
     * @param context application context
     */
    public void init (Context context) {
        application = (Application) context;
    }

    /**
     * 配置添加代理类与其所有的子代理类进入链表。并根据代理类的level进行排序。以便派发生命周期代理函数
     * @param delegate delegate instance
     */
    public void link (IApplicationDelegate delegate) {
        if (container.contains(delegate)) {
            return;
        }
        container.add(delegate);
        Class[] classes = delegate.subDelegates();
        for (Class clz : classes) {
            try {
                if (IApplicationDelegate.class.isAssignableFrom(clz) && !hasApplication(clz)) {
                    IApplicationDelegate sub = (IApplicationDelegate) clz.newInstance();
                    link(sub);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        Collections.sort(container, new Comparator<IApplicationDelegate>() {
            @Override
            public int compare(IApplicationDelegate lhs, IApplicationDelegate rhs) {
                return lhs.getLevel() - rhs.getLevel();
            }
        });
    }

    private boolean hasApplication (Class clz) {
        for (IApplicationDelegate delegate : container){
            if (delegate.getClass().equals(clz)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 触发调用attachBaseContext的代理周期函数。
     * @param base base context
     */
    public void performAttachBaseContext (Context base) {
        for (IApplicationDelegate delegate : container) {
            delegate.attachBaseContextDelegate(base);
        }
    }

    /**
     * 触发调用onCreate的代理周期函数。
     */
    public void performCreate () {
        for (IApplicationDelegate delegate : container) {
            delegate.onCreateDelegate();
        }
    }

    /**
     * 触发调用onTerminate的代理周期函数。
     */
    public void performTerminal () {
        for (IApplicationDelegate delegate : container) {
            delegate.onTerminateDelegate();
        }
    }

    /**
     * 触发调用onConfigurationChanged的代理周期函数。
     */
    public void performConfigurationChanged (Configuration newConfig) {
        for (IApplicationDelegate delegate : container) {
            delegate.onConfigurationChangedDelegate(newConfig);
        }
    }

    /**
     * 触发调用onLowMemory的代理周期函数。
     */
    public void performLowMemory () {
        for (IApplicationDelegate delegate : container) {
            delegate.onLowMemoryDelegate();
        }
    }

    /**
     * 触发调用onTrimMemory的代理周期函数。
     */
    public void performTrimMemory (int level) {
        for (IApplicationDelegate delegate : container) {
            delegate.onTrimMemoryDelegate(level);
        }
    }

    public Context getApplicationContext () {
        return application;
    }

    @SuppressLint("StaticFieldLeak")
    private static ApplicationDispatcher dispatcher = new ApplicationDispatcher();
    private ApplicationDispatcher () {}
    public static ApplicationDispatcher get() {
        return dispatcher;
    }

}
