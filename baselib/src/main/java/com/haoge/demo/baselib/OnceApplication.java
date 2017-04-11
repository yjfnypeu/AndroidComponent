package com.haoge.demo.baselib;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 由于多个组件均含有各自的Application。使用多组件时需要手动派发Application的onCreate时间。使用此类做
 * 约束。避免同一个Application被多次调用
 */
public abstract class OnceApplication extends Application {
    private static LinkedList<OnceApplication> container = new LinkedList<>();
    private static Application application;
    @Override
    public final void onCreate() {
        super.onCreate();
        application = this;
        link(this);
        Collections.sort(container, new Comparator<OnceApplication>() {
            @Override
            public int compare(OnceApplication o1, OnceApplication o2) {
                return o1.getLevel() - o2.getLevel();
            }
        });
        performCreate();
    }

    protected void link (OnceApplication delegate) {
        if (container.contains(delegate)) {
            return;
        }
        container.add(delegate);
        Class[] classes = delegate.subDelegates();
        for (Class clz : classes) {
            try {
                if (OnceApplication.class.isAssignableFrom(clz) && !hasApplication(clz)) {
                    OnceApplication sub = (OnceApplication) clz.newInstance();
                    delegate.link(sub);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }

    }

    private boolean hasApplication (Class clz) {
        for (OnceApplication delegate : container){
            if (delegate.getClass().equals(clz)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置level。对于触发调用onCreate等生命周期时，将根据level<i><b>从低到高</b></i>进行链式调用。
     * @return level
     */
    protected abstract int getLevel ();

    protected abstract Class[] subDelegates();

    @Override
    public boolean equals(Object o) {
        // 以类名作为对比依据
        return this.getClass().getCanonicalName().equals(o.getClass().getCanonicalName());
    }

    private void performCreate () {
        for (OnceApplication delegate : container) {
            delegate.onCreateDelegate();
        }
    }

    @Override
    public final void onTerminate() {
        performTerminal();
        super.onTerminate();
    }

    private void performTerminal () {
        for (OnceApplication delegate : container) {
            delegate.onTerminalDelegate();
        }
    }

    @Override
    public final void onConfigurationChanged(Configuration newConfig) {
        performConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    private void performConfigurationChanged (Configuration newConfig) {
        for (OnceApplication delegate : container) {
            delegate.onConfigurationChangedDelegate(newConfig);
        }
    }

    @Override
    public final void onLowMemory() {
        performLowMemory();
        super.onLowMemory();
    }

    private void performLowMemory () {
        for (OnceApplication delegate : container) {
            delegate.onLowMemoryDelegate();
        }
    }

    @Override
    public final void onTrimMemory(int level) {
        performTrimMemory(level);
        super.onTrimMemory(level);
    }

    private void performTrimMemory (int level) {
        for (OnceApplication delegate : container) {
            delegate.onTrimMemoryDelegate(level);
        }
    }

    protected abstract void onCreateDelegate();
    protected void onTerminalDelegate() {}
    protected void onConfigurationChangedDelegate(Configuration newConfig) {}
    protected void onLowMemoryDelegate() {}
    protected void onTrimMemoryDelegate(int level) {}

    @Override
    public Context getApplicationContext() {
        return application;
    }

}
