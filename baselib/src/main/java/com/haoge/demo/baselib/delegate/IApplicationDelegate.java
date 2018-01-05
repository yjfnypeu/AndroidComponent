package com.haoge.demo.baselib.delegate;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.IntDef;

public interface IApplicationDelegate {

    int LEVEL_BASE_LIB = 0;
    int LEVEL_LIB = 1;
    int LEVEL_BIZ = 2;
    int LEVEL_APP = 3;

    @IntDef({LEVEL_BASE_LIB,LEVEL_LIB,LEVEL_BIZ,LEVEL_APP})
    @interface Level {}

    /**
     * 获取此代理类的等级。对于注册的所有代理实例。将会根据此level由低到高进行排序使用
     * @return level number
     */
    @Level int getLevel();

    /**
     * 配置此代理的所依赖的子代理。
     * @return IApplicationDelegate 的Class[]
     */
    Class[] subDelegates();

    // ===============以下为各个代理方法。==============
    void attachBaseContextDelegate(Context base);
    void onCreateDelegate();
    void onTerminateDelegate();
    void onConfigurationChangedDelegate(Configuration newConfig);
    void onLowMemoryDelegate();
    void onTrimMemoryDelegate(int level);
}
