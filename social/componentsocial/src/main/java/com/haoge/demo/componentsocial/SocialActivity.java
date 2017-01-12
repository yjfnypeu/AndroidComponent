package com.haoge.demo.componentsocial;

import android.os.Bundle;
import android.view.View;

import com.haoge.demo.baselib.activity.BaseActivity;
import com.lzh.nonview.router.Router;

import butterknife.OnClick;

public class SocialActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
    }

    @OnClick(R2.id.to_login)
    void onLoginClick () {
        Router.create("haoge://login.com?username=&password=123456").getActivityRoute()
                .requestCode(100)
                .open(SocialActivity.this);
    }
}
