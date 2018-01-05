package com.haoge.demo.componentsocial;

import android.os.Bundle;
import android.view.View;

import com.haoge.demo.baselib.BaseActivity;
import com.lzh.nonview.router.Router;

public class SocialActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        findViewById(R.id.to_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.create("haoge://login.com?username=&password=123456").getActivityRoute()
                        .requestCode(100)
                        .open(SocialActivity.this);
            }
        });
    }
}
