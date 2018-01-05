package com.haoge.demo.componentusercenter;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.delegate.ApplicationDelegate;
import com.haoge.demo.baselib.router.ComponentPackages;
import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.RouterConfiguration;
import com.lzh.nonview.router.anno.RouteConfig;

// 指定usercenter组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = ComponentPackages.UC)
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
}
