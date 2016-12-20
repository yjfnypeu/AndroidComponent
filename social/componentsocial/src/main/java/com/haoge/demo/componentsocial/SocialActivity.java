package com.haoge.demo.componentsocial;

import android.os.Bundle;
import android.view.View;

import com.haoge.demo.baselib.activity.BaseActivity;
import com.lzh.nonview.router.Router;

public class SocialActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        getView(R.id.to_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.create("haoge://login.com?username=haoge&password=123456").open(SocialActivity.this);
            }
        });
    }
}
