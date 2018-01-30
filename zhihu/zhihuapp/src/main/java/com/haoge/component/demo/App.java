package com.haoge.component.demo;

import com.haoge.demo.baselib.delegate.ApplicationDelegate;
import com.lzh.corecomponent.CoreApplication;
import com.lzh.zhihunewscomponent.NewsApplication;

/**
 * @author haoge on 2018/1/5.
 */

public class App extends ApplicationDelegate{
    @Override
    public int getLevel() {
        return LEVEL_APP;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[] {NewsApplication.class, CoreApplication.class};
    }

    @Override
    public void onCreateDelegate() {

    }
}
