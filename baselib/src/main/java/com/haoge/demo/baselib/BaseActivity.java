package com.haoge.demo.baselib;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.haoge.demo.baselib.tool.EnvironmentVariable;
import com.lzh.compiler.parceler.Parceler;
import com.lzh.datasupport.DataSupport;

import butterknife.ButterKnife;

/**
 * @author haoge on 2018/1/5.
 */
public class BaseActivity extends Activity{

    // 对
    static DataSupport checker = DataSupport.create()
            // Debug环境时，当检查失败时，直接抛出异常。
            .throwable(EnvironmentVariable.DEBUG);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parceler.toEntity(this, getIntent());
        checker.check(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Parceler.toBundle(this, outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Parceler.toEntity(this, savedInstanceState);
    }

    protected final <V extends View> V findView(int resId) {
        return (V) findViewById(resId);
    }
}
