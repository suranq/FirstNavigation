package com.example.firstnavigation.https;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.beans.HeadImage;
import com.example.firstnavigation.beans.Hot;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.beans.LoadTopic;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.beans.SearchBean;
import com.example.firstnavigation.beans.Topic;

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

    /**
     * 评论列表
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<CommentList>>getCommentList(@Url String url,@Body RequestBody requestBody);

    /**
     * 热门新闻
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<Hot>>getHot(@Url String url,@Body RequestBody requestBody);

    /**
     * 搜索新闻
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<SearchBean>>getSearch(@Url String url,@Body RequestBody requestBody);

    /**
     * 搜索话题
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<Topic>>getTopic(@Url String url,@Body RequestBody requestBody);

    /**
     * 话题列表
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<LoadTopic>>getLoadTopic(@Url String url,@Body RequestBody requestBody);

    /**
     * 话题详情
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<InfoTopic>>getInfoTopic(@Url String url,@Body RequestBody requestBody);
}
