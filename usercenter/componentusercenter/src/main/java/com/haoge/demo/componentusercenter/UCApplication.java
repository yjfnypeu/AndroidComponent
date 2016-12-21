package com.haoge.demo.componentusercenter;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.Constant;
import com.haoge.demo.baselib.OnceApplication;
import com.lzh.nonview.router.anno.RouteConfig;

// 指定usercenter组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = Constant.PACK.USERCENTER)
public class UCApplication extends OnceApplication {

    private static UCApplication application;
    public synchronized static UCApplication get () {
        if (application == null) {
            application = new UCApplication();
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
