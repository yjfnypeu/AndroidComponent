package com.haoge.demo.androidcomponentdemo;

import com.haoge.demo.baselib.OnceApplication;
import com.haoge.demo.componentsocial.SocialApplication;
import com.haoge.demo.componentusercenter.UCApplication;

/**
 * Created by haoge on 2016/12/20.
 */

public class MainApplication extends OnceApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        UCApplication.get().invokeOnCreateOnce();
        SocialApplication.get().invokeOnCreateOnce();
    }
}
