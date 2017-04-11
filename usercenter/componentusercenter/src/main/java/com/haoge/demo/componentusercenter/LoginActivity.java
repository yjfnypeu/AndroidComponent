package com.haoge.demo.componentusercenter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.haoge.demo.baselib.activity.BaseActivity;
import com.lzh.compiler.parceler.annotation.Arg;
import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.anno.RouterRule;

import butterknife.BindView;
import butterknife.OnClick;

@RouterRule({"haoge://login.com","xiange://dadiao.cn"})
public class LoginActivity extends BaseActivity {
    @Arg
    String username;
    @Arg
    String password;
    @BindView(R2.id.username)
    TextView userTv;
    @BindView(R2.id.password)
    TextView pwdTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        System.out.println("LoginActivity onCreateDelegate");
        userTv.setText(username);
        pwdTv.setText(password);
    }

    @OnClick(R2.id.login)
    void onLoginClick (View v) {
        Router.create("haoge://loginresult").open(LoginActivity.this);
    }
}
