package com.haoge.component.demo;

import com.haoge.demo.baselib.delegate.ApplicationDelegate;
import com.haoge.demo.componentusercenter.UCApplication;
import com.lzh.corecomponent.CoreApplication;

/**
 * @author haoge on 2018/1/5.
 */

public class App extends ApplicationDelegate {
    @Override
    public int getLevel() {
        return LEVEL_APP;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[] {UCApplication.class, CoreApplication.class};
    }

    @Override
    public void onCreateDelegate() {

    }
}
