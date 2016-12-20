package com.haoge.demo.componentsocial;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.OnceApplication;

public class SocialApplication extends OnceApplication {
    private static SocialApplication application;
    public synchronized static SocialApplication get () {
        if (application == null) {
            application = new SocialApplication();
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
