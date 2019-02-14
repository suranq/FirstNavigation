package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.beans.Like;
import com.example.firstnavigation.beans.ListComment;
import com.example.firstnavigation.beans.TopicComment;
import com.example.firstnavigation.contact.InfoTopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/31.
 */

public class InfoTopicModlue {

    public void getInfoTopic(String topicId, String userId, final InfoTopicCon.InfoTopicM infoTopicM){
        infoTopicM.setShowProgressbar();

        HttpManager.getHttpManager().getServer().getInfoTopic("topic/info", HttpUtils.getInfoTopic(topicId,userId)).compose(RxUtils.<BaseData<InfoTopic>>rxObserableSchedulerHelper())
                .compose(RxUtils.<InfoTopic>handleResule())
                .subscribe(new BaseObserver<InfoTopic>(infoTopicM) {
                    @Override
                    public void onNext(InfoTopic infoTopic) {
                        infoTopicM.setShowInfoTopic(infoTopic);
                    }
                });
    }

    public void getListComment(String json, final InfoTopicCon.InfoTopicM infoTopicM){
        infoTopicM.setShowProgressbar();

        HttpManager.getHttpManager().getServer().getListComment("comment/listComment",HttpUtils.getBody(json)).compose(RxUtils.<BaseData<ListComment>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListComment>handleResule())
                .subscribe(new BaseObserver<ListComment>(infoTopicM) {
                    @Override
                    public void onNext(ListComment listComment) {
                        infoTopicM.setShowListComment(listComment);
                    }
                });
    }

    public void getTopicComment(String json, final InfoTopicCon.InfoTopicM infoTopicM){
        infoTopicM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getTopicComment("users/comment", HttpUtils.getBody(json)).compose(RxUtils.<TopicComment>rxObserableSchedulerHelper())
//                .compose(RxUtils.<TopicComment>handleResule())
                .subscribe(new BaseObserver<TopicComment>(infoTopicM) {
                    @Override
                    public void onNext(TopicComment topicComment) {
                        infoTopicM.setShowTopicComment(topicComment);
                    }
                });
    }

    public void getFavourite(String json, final InfoTopicCon.InfoTopicM infoTopicM){
        infoTopicM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getFavourite("users/favourite", HttpUtils.getBody(json)).compose(RxUtils.<Favourite>rxObserableSchedulerHelper())
//                .compose(RxUtils.<TopicComment>handleResule())
                .subscribe(new BaseObserver<Favourite>(infoTopicM) {
                    @Override
                    public void onNext(Favourite favourite) {
                        infoTopicM.setShowFavourite(favourite);
                    }
                });
    }

    public void getFollow(String json, final InfoTopicCon.InfoTopicM infoTopicM){
        infoTopicM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getFollow("users/follow", HttpUtils.getBody(json)).compose(RxUtils.<Follow>rxObserableSchedulerHelper())
//                .compose(RxUtils.<TopicComment>handleResule())
                .subscribe(new BaseObserver<Follow>(infoTopicM) {
                    @Override
                    public void onNext(Follow follow) {
                        infoTopicM.setShowFollow(follow);
                    }
                });
    }

    public void getLike(String json, final InfoTopicCon.InfoTopicM infoTopicM){
        infoTopicM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getLike("users/like", HttpUtils.getBody(json)).compose(RxUtils.<Like>rxObserableSchedulerHelper())
//                .compose(RxUtils.<TopicComment>handleResule())
                .subscribe(new BaseObserver<Like>(infoTopicM) {
                    @Override
                    public void onNext(Like like) {
                        infoTopicM.setShowLike(like);
                    }
                });
    }

}
