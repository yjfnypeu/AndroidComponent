package com.haoge.demo.baselib.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 使用JMToast作为统一吐司处理.支持在任意线程中直接弹吐司.连续吐司自动隐藏上一次的显示最新的吐司
 * Created by zhihaol on 16/7/15.
 */
public class ToastTool {

    private static ToastTool jmToast;
    private Toast toast;

    @SuppressLint("ShowToast")
    public ToastTool() {
        Context context = SingleContainer.getApplicationContext();
        this.toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    private static ToastTool getInstance() {
        if (jmToast == null) {
            synchronized (ToastTool.class) {
                if (jmToast == null) {
                    jmToast = new ToastTool();
                }
            }
        }
        return jmToast;
    }

    public static void show(final String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        SingleContainer.getMainHandler().post(new Runnable() {

            @Override
            public void run() {
                ToastTool instance = getInstance();
                instance.toast.setText(msg);
                instance.toast.show();
            }
        });
    }

    public static void show(@StringRes int resId) {
        show(SingleContainer.getApplicationContext().getResources().getString(resId));
    }
}
