package com.haoge.demo.baselib;

import com.haoge.demo.baselib.router.JMRouteManager;

public final class BaseApplication extends OnceApplication {
    private static BaseApplication application;
    public synchronized static BaseApplication get () {
        if (application == null) {
            application = new BaseApplication();
        }
        return application;
    }
    @Override
    public void onCreate() {
        application = this;
        super.onCreate();
        JMRouteManager.get().init();
    }
}
