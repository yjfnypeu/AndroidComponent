package com.lzh.zhihunewscomponent;

import com.lzh.zhihunewscomponent.pojo.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author haoge on 2018/1/5.
 */

public interface ZhihuNews {

    @GET("4/news/latest")
    Call<NewsList> queryList();

}
