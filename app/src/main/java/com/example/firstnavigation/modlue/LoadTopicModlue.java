package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.LoadTopic;
import com.example.firstnavigation.contact.LoadTopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/27.
 */

public class LoadTopicModlue {

    public void getLoadTopicMod(String json, final LoadTopicCon.LoadTopicM loadTopicM){
        loadTopicM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getLoadTopic("topic/loadTopic", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<LoadTopic>>rxObserableSchedulerHelper())
                .compose(RxUtils.<LoadTopic>handleResule())
                .subscribe(new BaseObserver<LoadTopic>(loadTopicM) {
                    @Override
                    public void onNext(LoadTopic loadTopic) {
                        loadTopicM.setShowLoadTopic(loadTopic);
                    }
                });
    }

}
