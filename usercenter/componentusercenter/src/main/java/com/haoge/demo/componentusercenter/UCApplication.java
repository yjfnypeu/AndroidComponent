package com.haoge.demo.componentusercenter;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.OnceApplication;

public class UCApplication extends OnceApplication {

    private static UCApplication application;
    public synchronized static UCApplication get () {
        if (application == null) {
            application = new UCApplication();
        }
        return application;
    }

    @Override
    public void onCreate() {
        application = this;
        super.onCreate();
        BaseApplication.get().invokeOnCreateOnce();
    }
}
