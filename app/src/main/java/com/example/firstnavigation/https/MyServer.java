package com.example.firstnavigation.https;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.beans.Center;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.HeadImage;
import com.example.firstnavigation.beans.Hot;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.beans.InsertTopic;
import com.example.firstnavigation.beans.Like;
import com.example.firstnavigation.beans.ListComment;
import com.example.firstnavigation.beans.ListFollow;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.beans.ListNotify;
import com.example.firstnavigation.beans.ListProfession;
import com.example.firstnavigation.beans.LoadTopic;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.beans.SearchBean;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.beans.Topic;
import com.example.firstnavigation.beans.TopicComment;
import com.example.firstnavigation.beans.UpDataInfo;
import com.example.firstnavigation.beans.UserInfo;
import com.example.firstnavigation.beans.UserListComment;
import com.example.firstnavigation.beans.UserNews;
import com.example.firstnavigation.beans.UserTopic;

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
    Observable<RelevantNews> getRelevantNews(@Url String url,@Body RequestBody requestBody);

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

    /**
     * 话题评论
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<ListComment>>getListComment(@Url String url,@Body RequestBody requestBody);

    /**
     * 发布话题
     * */
    @POST
//    @Headers("Content-Type:multipart/form-data")
    Observable<BaseData<InsertTopic>>getInsertTopic(@Url String url,@Body RequestBody requestBody);

    /**
     * 个人信息
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<Center>>getCenter(@Url String url,@Body RequestBody requestBody);

    /**
     * 个人设置
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<UserInfo>>getUserInfo(@Url String url,@Body RequestBody requestBody);

    /**
     * 收藏新闻
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<UserNews>>getUserNews(@Url String url,@Body RequestBody requestBody);

    /**
     * 收藏话题
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<UserTopic>>getUserTopic(@Url String url,@Body RequestBody requestBody);

    /**
     * 关注列表
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<ListFollow>>getListFollow(@Url String url, @Body RequestBody requestBody);

    /**
     * 职业列表
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<ListProfession>>getListProfession(@Url String url,@Body RequestBody requestBody);

    /**
     * 热门标签
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<TagsHot>getTagsHot(@Url String url, @Body RequestBody requestBody);

    /**
     * 搜索标签
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<TagsSearch>>getTagsSearch(@Url String url,@Body RequestBody requestBody);

    /**
     * 话题评论发布
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<TopicComment>getTopicComment(@Url String url,@Body RequestBody requestBody);

    /**
     * 收藏话题
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<Favourite>getFavourite(@Url String url,@Body RequestBody requestBody);

    /**
     * 我的评论
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseData<UserListComment>>getUserListComment(@Url String url,@Body RequestBody requestBody);

    /**
     * 修改信息
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<UpDataInfo>getUpdataInfo(@Url String url,@Body RequestBody requestBody);

    /**
     * 消息通知
     * */
    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<ListNotify>getListNotify(@Url String url,@Body RequestBody requestBody);

    /**
     * 关注用户
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<Follow>getFollow(@Url String url,@Body RequestBody requestBody);

    /**
     * 点赞用户
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<Like>getLike(@Url String url,@Body RequestBody requestBody);

    /**
     * 更多关注
     * */
    @POST
    @Headers("Content-Type:application/json")
    Observable<BaseData<MoreFollow>>getMoreFollow(@Url String url,@Body RequestBody requestBody);
}
