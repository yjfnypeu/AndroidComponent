package com.haoge.demo.baselib;

import android.app.Application;

/**
 * 由于多个组件均含有各自的Application。使用多组件时需要手动派发Application的onCreate时间。使用此类做
 * 约束。避免同一个Application被多次调用
 */
public class OnceApplication extends Application {

    private boolean isFirstInvoke = false;

    public void invokeOnCreateOnce () {
        if (isFirstInvoke) return;
        onCreate();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        isFirstInvoke = true;
    }
}
