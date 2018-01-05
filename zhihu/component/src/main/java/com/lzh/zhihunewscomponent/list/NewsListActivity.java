package com.lzh.zhihunewscomponent.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.haoge.demo.baselib.BaseActivity;
import com.haoge.demo.baselib.router.interceptors.LoginInterceptor;
import com.haoge.demo.baselib.router.routings.Routing;
import com.haoge.demo.baselib.tool.ToastTool;
import com.lzh.nonview.router.anno.RouteInterceptors;
import com.lzh.nonview.router.anno.RouterRule;
import com.lzh.zhihunewscomponent.NewsApplication;
import com.lzh.zhihunewscomponent.R;
import com.lzh.zhihunewscomponent.R2;
import com.lzh.zhihunewscomponent.ZhihuNews;
import com.lzh.zhihunewscomponent.pojo.NewsList;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RouteInterceptors(LoginInterceptor.class)
@RouterRule(Routing.NEWS_LIST)
public class NewsListActivity extends BaseActivity {

    @BindView(R2.id.news_list)
    ListView newsList;
    @BindView(R2.id.empty)
    View empty;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhihu_activity_news_list);

        newsList.setEmptyView(empty);

        queryList();
    }

    private void updateList(List<NewsList.StoriesBean> stories) {
        String[] titles = new String[stories.size()];
        for (int i = 0; i < stories.size(); i++) {
            titles[i] = stories.get(i).title;
        }
        newsList.setAdapter(new ArrayAdapter<>(this, R.layout.zhihu_item_news_list, titles));
    }

    private void queryList() {
        ZhihuNews zhihuNews = NewsApplication.getRetrofit().create(ZhihuNews.class);
        Call<NewsList> call = zhihuNews.queryList();
        call.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                NewsList body = response.body();
                updateList(body.stories);
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                t.printStackTrace();
                ToastTool.show("获取新闻列表失败");
            }
        });
    }


}
