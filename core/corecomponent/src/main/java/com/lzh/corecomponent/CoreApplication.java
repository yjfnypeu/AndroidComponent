package com.lzh.corecomponent;

import com.haoge.demo.baselib.delegate.ApplicationDelegate;
import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.pipe.CorePipe;
import com.haoge.demo.baselib.pipe.core.PipeManager;

public class CoreApplication extends ApplicationDelegate{

    @Override
    public int getLevel() {
        return LEVEL_BIZ;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[]{BaseApplication.class};
    }

    @Override
    public void onCreateDelegate() {
        PipeManager.register(CorePipe.class, new CorePipeImpl());
    }
}
