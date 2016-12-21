package com.haoge.demo.componentsocial;

import android.app.Activity;
import android.os.Bundle;

import com.haoge.demo.baselib.Constant;
import com.lzh.nonview.router.anno.RouterRule;

@RouterRule(value = "haoge://loginresult")
public class LoginResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);
    }
}
