package com.haoge.demo.baselib.pipe;

import com.haoge.demo.baselib.pipe.core.Pipe;

/**
 * @author haoge on 2018/1/5.
 */

public interface CorePipe extends Pipe{

    boolean isLogin();

    void logout();
}
