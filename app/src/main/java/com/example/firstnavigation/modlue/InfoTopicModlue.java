package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.InfoTopic;
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

}
