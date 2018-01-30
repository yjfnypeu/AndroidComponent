package com.haoge.demo.baselib.tool;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 *
 * @author haoge on 2018/1/5.
 */
public final class SingleContainer {
    static SingleContainer INSTANCE = new SingleContainer();
    public Handler mainHandler;
    public Context context;

    public static Handler getMainHandler () {
        if (INSTANCE.mainHandler == null) {
            INSTANCE.mainHandler = new Handler(Looper.getMainLooper());
        }
        return INSTANCE.mainHandler;
    }

    public static void init(Context context) {
        if (context != null && INSTANCE.context == null) {
            INSTANCE.context = context.getApplicationContext();
        }
    }

    public static Context getApplicationContext () {
        if (INSTANCE.context == null) {
            throw new IllegalStateException("请先调用 init(context)方法初始化");
        }
        return INSTANCE.context;
    }
}
