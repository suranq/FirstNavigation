package com.example.firstnavigation.https;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.beans.HeadImage;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.beans.RelevantNews;

import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public interface MyServer {

    String URL = "https://www.firstgainfo.com/firstga/app/";

    /**
     * 新闻频道
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<ListNews>> getListNews(@Url String url, @Body RequestBody requestBody);

    /**
     * 上传头像
     * */
    @POST
//    @Headers("Content-Type:multipart/form-data")
    Observable<BaseData<HeadImage>> getHeadImage(@Url String url, @Body RequestBody requestBody);

    /**
     * 新闻列表
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<DownList>>getDownList(@Url String url, @Body RequestBody requestBody);

    /**
     * 新闻详情
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<Info>>getInfo(@Url String url,@Body RequestBody requestBody);

    /**
     * 相关新闻
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<RelevantNews>> getRelevantNews(@Url String url,@Body RequestBody requestBody);

}
