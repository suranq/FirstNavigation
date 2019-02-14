package com.example.firstnavigation.modlue;

import android.util.Log;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.beans.TopicComment;
import com.example.firstnavigation.contact.InfoCon;
import com.example.firstnavigation.contact.InfoTopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class InfoModlue {

    public void getDownListMod(String userId, String newsId, final InfoCon.InfoConM infoConM) {

        infoConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getInfo("news/info", HttpUtils.getBody2(userId, newsId)).compose(RxUtils.<BaseData<Info>>rxObserableSchedulerHelper())
                .compose(RxUtils.<Info>handleResule())
                .subscribe(new BaseObserver<Info>(infoConM) {
                    @Override
                    public void onNext(Info info) {
                        infoConM.setShowInfo(info);
                    }
                });
    }

    public void getRelevantNews(String newsId, final InfoCon.InfoConM infoConM) {
        infoConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getRelevantNews("news/relevant", HttpUtils.getBodyRelevant(newsId)).compose(RxUtils.<RelevantNews>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<RelevantNews>(infoConM) {
                    @Override
                    public void onNext(RelevantNews relevantNews) {
                        infoConM.setShowRelevantNews(relevantNews);
                    }
                });

    }

    public void getCommentList(String json, final InfoCon.InfoConM infoConM) {
        infoConM.setShowProgressbar();

        HttpManager.getHttpManager().getServer().getCommentList("comment/listComment", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<CommentList>>rxObserableSchedulerHelper())
                .compose(RxUtils.<CommentList>handleResule())
                .subscribe(new BaseObserver<CommentList>(infoConM) {
                    @Override
                    public void onNext(CommentList commentList) {
                        infoConM.setShowCommentList(commentList);
                    }
                });
    }

    public void getFavourite(String json, final InfoCon.InfoConM infoConM){
        infoConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getFavourite("users/favourite", HttpUtils.getBody(json)).compose(RxUtils.<Favourite>rxObserableSchedulerHelper())
//                .compose(RxUtils.<TopicComment>handleResule())
                .subscribe(new BaseObserver<Favourite>(infoConM) {
                    @Override
                    public void onNext(Favourite favourite) {
                        infoConM.setShowFavourite(favourite);
                    }
                });
    }

    public void getTopicComment(String json, final InfoCon.InfoConM infoConM){
        infoConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getTopicComment("users/comment", HttpUtils.getBody(json)).compose(RxUtils.<TopicComment>rxObserableSchedulerHelper())
//                .compose(RxUtils.<TopicComment>handleResule())
                .subscribe(new BaseObserver<TopicComment>(infoConM) {
                    @Override
                    public void onNext(TopicComment topicComment) {
                        infoConM.setShowTopicComment(topicComment);
                    }
                });
    }

}
