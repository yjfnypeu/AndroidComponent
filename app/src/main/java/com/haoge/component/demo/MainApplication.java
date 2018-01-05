package com.haoge.component.demo;

import com.haoge.demo.baselib.delegate.ApplicationDelegate;
import com.haoge.demo.componentusercenter.UCApplication;
import com.lzh.corecomponent.CoreApplication;
import com.lzh.zhihunewscomponent.NewsApplication;

public class MainApplication extends ApplicationDelegate {

    @Override
    public int getLevel() {
        return LEVEL_APP;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[]{UCApplication.class, NewsApplication.class, CoreApplication.class};
    }

    @Override
    public void onCreateDelegate() {

    }
}
