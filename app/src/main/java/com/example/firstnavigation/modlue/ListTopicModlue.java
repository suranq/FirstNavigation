package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.ListTopic;
import com.example.firstnavigation.contact.ListTopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/17.
 */

public class ListTopicModlue {
    public void getListTopic(String userId, String cursor, final ListTopicCon.ListTopicM listTopicM){
        listTopicM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getListTopic("users/listTopic", HttpUtils.getCollect(userId,cursor)).compose(RxUtils.<BaseData<ListTopic>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListTopic>handleResule())
                .subscribe(new BaseObserver<ListTopic>(listTopicM) {
                    @Override
                    public void onNext(ListTopic listTopic) {
                        listTopicM.setShowListTopic(listTopic);
                    }
                });
    }
}
