package com.haoge.demo.baselib;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.haoge.demo.baselib.delegate.IApplicationDelegate;
import com.haoge.demo.baselib.delegate.ApplicationDispatcher;


/**
 * 由于多个组件均含有各自的Application。使用多组件时需要手动派发Application的onCreate时间。使用此类做
 * 约束。避免同一个Application被多次调用
 */
public abstract class ApplicationDelegate extends Application implements IApplicationDelegate {
    @Override
    public final void onCreate() {
        super.onCreate();
        ApplicationDispatcher.get().performCreate();
    }

    @Override
    protected final void attachBaseContext(Context base) {
        ApplicationDispatcher.get().init(this);
        ApplicationDispatcher.get().link(this);
        ApplicationDispatcher.get().performAttachBaseContext(base);
        super.attachBaseContext(base);
    }

    @Override
    public final void onTerminate() {
        ApplicationDispatcher.get().performTerminal();
        super.onTerminate();
    }

    @Override
    public final void onConfigurationChanged(Configuration newConfig) {
        ApplicationDispatcher.get().performConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public final void onLowMemory() {
        ApplicationDispatcher.get().performLowMemory();
        super.onLowMemory();
    }

    @Override
    public final void onTrimMemory(int level) {
        ApplicationDispatcher.get().performTrimMemory(level);
        super.onTrimMemory(level);
    }

    @Override
    public Context getApplicationContext() {
        return ApplicationDispatcher.get().getApplicationContext();
    }

    @Override
    public void attachBaseContextDelegate(Context base) {
        Log.d(getClass().getCanonicalName(),"attachBaseContextDelegate invoked!");
    }

    @Override
    public void onTerminateDelegate() {
        Log.d(getClass().getCanonicalName(),"onTerminateDelegate invoked!");
    }

    @Override
    public void onConfigurationChangedDelegate(Configuration newConfig) {
        Log.d(getClass().getCanonicalName(),"onConfigurationChangedDelegate invoked!");
    }

    @Override
    public void onLowMemoryDelegate() {
        Log.d(getClass().getCanonicalName(),"onLowMemoryDelegate invoked!");
    }

    @Override
    public void onTrimMemoryDelegate(int level) {
        Log.d(getClass().getCanonicalName(),"onTrimMemoryDelegate invoked!");
    }
}
