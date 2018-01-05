package com.lzh.corecomponent;

import com.haoge.demo.baselib.pipe.CorePipe;

/**
 * @author haoge on 2018/1/5.
 */

public class CorePipeImpl implements CorePipe {
    @Override
    public boolean isLogin() {
        return UserManager.isLogin;
    }
}
