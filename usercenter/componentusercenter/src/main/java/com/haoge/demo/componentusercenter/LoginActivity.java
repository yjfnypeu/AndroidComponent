package com.haoge.demo.componentusercenter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.haoge.demo.baselib.Constant;
import com.haoge.demo.baselib.activity.BaseActivity;
import com.lzh.compiler.parceler.annotation.Arg;
import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.anno.RouterRule;

import butterknife.BindView;

@RouterRule(value = "haoge://login.com",pack = Constant.PACK.USERCENTER)
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

        userTv.setText(username);
        pwdTv.setText(password);

        getView(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.create("haoge://loginresult").open(LoginActivity.this);
            }
        });
    }
}
