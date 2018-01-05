package com.haoge.demo.componentusercenter;

import android.content.res.Configuration;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.ApplicationDelegate;
import com.haoge.demo.baselib.router.ComponentPackages;
import com.lzh.nonview.router.anno.RouteConfig;

// 指定usercenter组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = ComponentPackages.USERCENTER)
public class UCApplication extends ApplicationDelegate {

    @Override
    public int getLevel() {
        return LEVEL_BIZ;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[] {BaseApplication.class};
    }

    @Override
    public void onCreateDelegate() {
    }

    @Override
    public void onTerminateDelegate() {
        super.onTerminateDelegate();
    }

    @Override
    public void onConfigurationChangedDelegate(Configuration newConfig) {
    }

    @Override
    public void onLowMemoryDelegate() {
    }

    @Override
    public void onTrimMemoryDelegate(int level) {
    }
}
