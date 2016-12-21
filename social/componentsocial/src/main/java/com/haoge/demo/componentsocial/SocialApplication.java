package com.haoge.demo.componentsocial;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.Constant;
import com.haoge.demo.baselib.OnceApplication;
import com.lzh.nonview.router.anno.RouteConfig;

// 指定social组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = Constant.PACK.SOCIAL)
public class SocialApplication extends OnceApplication {
    private static SocialApplication application;
    public synchronized static SocialApplication get () {
        if (application == null) {
            application = new SocialApplication();
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
