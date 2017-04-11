package com.haoge.demo.androidcomponentdemo;

import com.haoge.demo.baselib.OnceApplication;
import com.haoge.demo.componentsocial.SocialApplication;
import com.haoge.demo.componentusercenter.UCApplication;

public class MainApplication extends OnceApplication {

    @Override
    protected int getLevel() {
        return 10;
    }

    @Override
    protected Class[] subDelegates() {
        return new Class[]{UCApplication.class, SocialApplication.class};
    }

    @Override
    protected void onCreateDelegate() {

    }
}
