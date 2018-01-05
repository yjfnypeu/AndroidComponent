package com.lzh.zhihunewscomponent;

import com.lzh.zhihunewscomponent.pojo.NewsDetail;
import com.lzh.zhihunewscomponent.pojo.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhihuNews {

    @GET("4/news/latest")
    Call<NewsList> queryList();

    @GET("4/news/{id}")
    Call<NewsDetail> queryDetail(@Path("id") String id);
}
