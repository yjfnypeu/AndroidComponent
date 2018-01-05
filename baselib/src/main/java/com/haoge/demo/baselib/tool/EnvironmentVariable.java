package com.haoge.demo.baselib.tool;

import android.content.Context;

import java.lang.reflect.Field;

/**
 * 由于组件化中。无法获取主app的BuildConfig进行使用。很多时候我们需要判断Debug还是Release环境进行使用。
 * 所以在此。我们需要初始化的时候直接通过反射读取主app的BuilderConfig提供使用
 * @author haoge on 2018/1/5.
 */
public final class EnvironmentVariable {

    public final static boolean DEBUG;

    static {
        boolean debug = false;
        Context context = SingleContainer.getApplicationContext();
        try {
            Class<?> buildConfig = Class.forName(context.getPackageName() + ".BuildConfig");
            Field debugField = buildConfig.getField("DEBUG");
            debug = (boolean) debugField.get(buildConfig);
        } catch (Exception e) {
            debug = false;
        } finally {
            DEBUG = debug;
        }
    }

}
