package com.haoge.demo.componentusercenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.haoge.demo.baselib.BaseActivity;
import com.haoge.demo.baselib.pipe.CorePipe;
import com.haoge.demo.baselib.pipe.core.PipeManager;
import com.haoge.demo.baselib.router.routings.Routing;
import com.haoge.demo.baselib.tool.ToastTool;
import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.anno.RouterRule;

@RouterRule(Routing.SETTING)
public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (PipeManager.get(CorePipe.class).isLogin()) {
            findViewById(R.id.logout).setVisibility(View.VISIBLE);
            findViewById(R.id.toLoginActivity).setVisibility(View.GONE);
        } else {
            findViewById(R.id.logout).setVisibility(View.GONE);
            findViewById(R.id.toLoginActivity).setVisibility(View.VISIBLE);
        }
    }

    public void onClearCacheClick(View view) {
        ToastTool.show("劳资是假的清理缓存");
    }

    public void onAboutClick(View view) {
        ToastTool.show("劳资是假的关于");
    }

    public void onUpdateClick(View view) {
        ToastTool.show("劳资是假的更新");
    }

    public void onLogoutClick(View view) {
        PipeManager.get(CorePipe.class).logout();
        Router.create(Routing.LOGIN).open(this);
    }

    public void toLoginActivity(View view) {
        Router.create(Routing.LOGIN).open(this);
    }
}
