package com.lzh.zhihunewscomponent.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.haoge.demo.baselib.BaseActivity;
import com.haoge.demo.baselib.router.interceptors.LoginInterceptor;
import com.haoge.demo.baselib.router.routings.Routing;
import com.haoge.demo.baselib.tool.ToastTool;
import com.lzh.compiler.parceler.annotation.Arg;
import com.lzh.nonview.router.anno.RouteInterceptors;
import com.lzh.nonview.router.anno.RouterRule;
import com.lzh.zhihunewscomponent.NewsApplication;
import com.lzh.zhihunewscomponent.R;
import com.lzh.zhihunewscomponent.R2;
import com.lzh.zhihunewscomponent.ZhihuNews;
import com.lzh.zhihunewscomponent.pojo.NewsDetail;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author haoge on 2018/1/5.
 */
@RouteInterceptors(LoginInterceptor.class)
@RouterRule(Routing.NEWS_DETAIL)
public class NewsDetailActivity extends BaseActivity {

    @BindView(R2.id.webView)
    WebView webView;

    @Arg
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhihu_activity_news_details);

        queryDetail();
    }

    private void queryDetail() {
        Call<NewsDetail> call = NewsApplication.getRetrofit().create(ZhihuNews.class).queryDetail(id);
        call.enqueue(new Callback<NewsDetail>() {
            @Override
            public void onResponse(Call<NewsDetail> call, Response<NewsDetail> response) {
                NewsDetail body = response.body();
                webView.loadData(body.body, "", "utf-8");
            }

            @Override
            public void onFailure(Call<NewsDetail> call, Throwable t) {
                t.printStackTrace();
                ToastTool.show("请求详情数据失败");
                finish();
            }
        });
    }
}
