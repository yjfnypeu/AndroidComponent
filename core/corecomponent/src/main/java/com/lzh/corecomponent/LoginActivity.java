package com.lzh.corecomponent;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.haoge.demo.baselib.BaseActivity;
import com.lzh.compiler.parceler.annotation.Arg;
import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.extras.RouteBundleExtras;

public class LoginActivity extends BaseActivity {

    EditText username;
    EditText password;

    @Arg
    Uri uri;
    @Arg
    RouteBundleExtras extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findView(R.id.username);
        password = findView(R.id.password);
    }

    public void onLoginClick(View view) {
        if (TextUtils.isEmpty(username.getText())
                || TextUtils.isEmpty(password.getText())) {
            Toast.makeText(this, "用户名、密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        UserManager.isLogin = true;
        UserManager.username = username.getText().toString();
        UserManager.password = password.getText().toString();

        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        if (uri != null) {
            // uri不为null。恢复启动路由
            Router.resume(uri, extras).open(this);
        }
    }
}
