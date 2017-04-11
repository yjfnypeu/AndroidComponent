package com.haoge.demo.componentusercenter;

import android.content.res.Configuration;
import android.util.Log;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.Constant;
import com.haoge.demo.baselib.OnceApplication;
import com.lzh.nonview.router.anno.RouteConfig;

// 指定usercenter组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = Constant.PACK.USERCENTER)
public class UCApplication extends OnceApplication {

    @Override
    protected int getLevel() {
        return 5;
    }

    @Override
    protected Class[] subDelegates() {
        return new Class[] {BaseApplication.class};
    }

    @Override
    protected void onCreateDelegate() {
    }

    @Override
    protected void onTerminalDelegate() {
    }

    @Override
    protected void onConfigurationChangedDelegate(Configuration newConfig) {
    }

    @Override
    protected void onLowMemoryDelegate() {
    }

    @Override
    protected void onTrimMemoryDelegate(int level) {
    }
}
