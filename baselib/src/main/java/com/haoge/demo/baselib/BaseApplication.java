package com.haoge.demo.baselib;

import com.haoge.demo.baselib.router.JMRouteManager;

public final class BaseApplication extends OnceApplication {

    @Override
    protected int getLevel() {
        return 0;
    }

    @Override
    protected Class[] subDelegates() {
        return null;
    }

    @Override
    protected void onCreateDelegate() {
        JMRouteManager.get().init();
    }

}
