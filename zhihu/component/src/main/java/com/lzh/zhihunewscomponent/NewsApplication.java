package com.lzh.zhihunewscomponent;

import com.haoge.demo.baselib.BaseApplication;
import com.haoge.demo.baselib.delegate.ApplicationDelegate;
import com.haoge.demo.baselib.router.ComponentPackages;
import com.lzh.nonview.router.anno.RouteConfig;
import com.zyr.library.FastJsonConverterFactory;

import retrofit2.Retrofit;

@RouteConfig(pack = ComponentPackages.ZHIHU)
public class NewsApplication extends ApplicationDelegate{

    static Retrofit retrofit;

    @Override
    public int getLevel() {
        return LEVEL_BIZ;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[] {BaseApplication.class};
    }

    @Override
    public void onCreateDelegate() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://news-at.zhihu.com/api/")
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
