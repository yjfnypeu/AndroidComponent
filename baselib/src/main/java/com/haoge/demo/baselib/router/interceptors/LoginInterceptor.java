package com.haoge.demo.baselib.router.interceptors;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import com.haoge.demo.baselib.pipe.CorePipe;
import com.haoge.demo.baselib.pipe.core.PipeManager;
import com.haoge.demo.baselib.router.routings.Routing;
import com.lzh.compiler.parceler.Parceler;
import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.extras.RouteBundleExtras;
import com.lzh.nonview.router.interceptors.RouteInterceptor;

/**
 * 路由拦截器：用于在使用路由启动页面之前，进行登录判断。若未登录。则先跳转至登录页面。待登录成功后再启动页面
 * @author haoge on 2018/1/5.
 */
public class LoginInterceptor implements RouteInterceptor{
    @Override
    public boolean intercept(Uri uri, RouteBundleExtras extras, Context context) {
        // 使用Pipe进行通信。获取核心业务组件中的登录信息进行判断
        return !PipeManager.get(CorePipe.class).isLogin();
    }

    @Override
    public void onIntercepted(Uri uri, RouteBundleExtras extras, Context context) {
        // 拦截成功，在此启动登录页面。
        Bundle bundle = Parceler.createFactory(null)
                // 传递待开启的页面的uri与extras数据。登录成功后可根据此数据进行路由重启。
                .put("uri", uri)
                .put("extras", extras)
                .getBundle();

        Router.create(Routing.LOGIN)
                .getBaseRoute()
                .addExtras(bundle)
                .open(context);
    }
}
