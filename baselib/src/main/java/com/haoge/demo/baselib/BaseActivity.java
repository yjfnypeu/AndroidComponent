package com.haoge.demo.baselib;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lzh.compiler.parceler.Parceler;
import com.lzh.datasupport.DataSupport;

import butterknife.ButterKnife;

/**
 * @author haoge on 2018/1/5.
 */
public class BaseActivity extends Activity{

    // 对
    static DataSupport checker = DataSupport.create().throwable(false);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Parceler.toEntity(this, getIntent());
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
