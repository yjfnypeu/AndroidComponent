package com.haoge.demo.baselib;

import com.haoge.demo.baselib.router.JMRouteManager;

public final class BaseApplication extends OnceApplication {

    @Override
    public int getLevel() {
        return LEVEL_BASE_LIB;
    }

    @Override
    public Class[] subDelegates() {
        return null;
    }

    @Override
    public void onCreateDelegate() {
        JMRouteManager.get().init();
    }

}
