package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.Topic;
import com.example.firstnavigation.contact.TopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/25.
 */

public class TopicModlue {

    public void getTopic(String json, final TopicCon.TopicM topicM){
        HttpManager.getHttpManager().getServer().getTopic("topic/search", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<Topic>>rxObserableSchedulerHelper())
                .compose(RxUtils.<Topic>handleResule())
                .subscribe(new BaseObserver<Topic>(topicM) {
                    @Override
                    public void onNext(Topic topic) {
                        topicM.setShowTopic(topic);
                    }
                });
    }

}
