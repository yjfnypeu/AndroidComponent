package com.haoge.demo.androidcomponentdemo;

import android.app.Application;

import com.haoge.demo.componentsocial.SocialApplication;
import com.haoge.demo.componentusercenter.UCApplication;

/**
 * Created by haoge on 2016/12/20.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new UCApplication().onCreate();
        new SocialApplication().onCreate();
    }
}
