package com.haoge.demo.androidcomponentdemo;

import com.haoge.demo.baselib.OnceApplication;
import com.haoge.demo.componentsocial.SocialApplication;
import com.haoge.demo.componentusercenter.UCApplication;

public class MainApplication extends OnceApplication {

    @Override
    public int getLevel() {
        return LEVEL_APP;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[]{UCApplication.class, SocialApplication.class};
    }

    @Override
    public void onCreateDelegate() {

    }
}
