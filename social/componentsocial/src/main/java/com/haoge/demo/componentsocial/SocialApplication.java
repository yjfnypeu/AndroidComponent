package com.haoge.demo.componentsocial;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.Constant;
import com.haoge.demo.baselib.OnceApplication;
import com.lzh.nonview.router.anno.RouteConfig;

// 指定social组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = Constant.PACK.SOCIAL)
public class SocialApplication extends OnceApplication {

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


}
