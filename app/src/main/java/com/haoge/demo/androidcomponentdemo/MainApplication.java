package com.haoge.demo.androidcomponentdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

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

    @Override
    public void attachBaseContextDelegate(Context base) {}

    @Override
    public void onTerminateDelegate() {}

    @Override
    public void onConfigurationChangedDelegate(Configuration newConfig) {}

    @Override
    public void onLowMemoryDelegate() {}

    @Override
    public void onTrimMemoryDelegate(int level) {}
}
