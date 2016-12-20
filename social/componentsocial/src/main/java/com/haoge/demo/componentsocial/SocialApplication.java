package com.haoge.demo.componentsocial;

import android.app.Application;

import com.haoge.demo.baselib.router.JMRouteManager;

/**
 * Created by haoge on 2016/12/20.
 */

public class SocialApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JMRouteManager.get().init();
    }
}
