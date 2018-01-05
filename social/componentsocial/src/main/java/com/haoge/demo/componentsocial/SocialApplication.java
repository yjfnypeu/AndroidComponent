package com.haoge.demo.componentsocial;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.ApplicationDelegate;
import com.haoge.demo.baselib.router.ComponentPackages;
import com.lzh.nonview.router.anno.RouteConfig;

// 指定social组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = ComponentPackages.SOCIAL)
public class SocialApplication extends ApplicationDelegate {

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
