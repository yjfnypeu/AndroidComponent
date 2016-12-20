package com.haoge.demo.baselib.router;

import android.net.Uri;
import android.util.Log;

import com.haoge.demo.baselib.Constant;
import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.exception.NotFoundException;
import com.lzh.nonview.router.module.RouteCreator;
import com.lzh.nonview.router.route.RouteCallback;

public class JMRouteManager {
    private static final String TAG = JMRouteManager.class.getSimpleName();
    private static JMRouteManager manager = new JMRouteManager();
    public static JMRouteManager get() {
        return manager;
    }

    private boolean inited = false;

    public void init () {
        if (inited) {
            return;
        }
        inited = true;
        loadRouteRulesIfExist();

        initRouteBaseConfig();
    }

    private void initRouteBaseConfig() {
        Router.setGlobalRouteCallback(new RouteCallback() {
            @Override
            public void notFound(Uri uri, NotFoundException e) {
                Log.e(TAG,"open url with " + uri + "failed.not found");
                e.printStackTrace();
            }

            @Override
            public void onOpenSuccess(Uri uri, String clzName) {
                Log.d(TAG,"open url with " + uri + "successful, claName=" + clzName);
            }

            @Override
            public void onOpenFailed(Uri uri, Exception e) {
                Log.d(TAG,"open url with " + uri + "failed," + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void loadRouteRulesIfExist() {
        String[] packs = Constant.PACK.Packages;
        String clzNameRouteRules = ".RouterRuleCreator";
        for (String pack : packs) {
            try {
                Class<?> creator = Class.forName(pack + clzNameRouteRules);
                RouteCreator instance = (RouteCreator) creator.newInstance();
                Router.addRouteCreator(instance);
            } catch (Exception ignore) {
            }
        }
    }
}
