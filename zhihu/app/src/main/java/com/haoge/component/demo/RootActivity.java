package com.haoge.component.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.haoge.demo.baselib.BaseActivity;
import com.haoge.demo.baselib.router.routings.Routing;
import com.lzh.nonview.router.Router;

/**
 * @author haoge on 2018/1/5.
 */

public class RootActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
    }

    public void onNewsListClick(View view) {
        Router.create(Routing.NEWS_LIST).open(this);
    }
}
