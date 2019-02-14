package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.InsertTopic;
import com.example.firstnavigation.contact.InsertTopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.json.JsonInsertTopic;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/7.
 */

public class InsertTopicModlue {

    public void getInsertTopic(JsonInsertTopic jsonInsertTopic, final InsertTopicCon.InsertTopicM insertTopicM){
        insertTopicM.setShowProgressbar();

        String userId = jsonInsertTopic.getUserId();
        List<String> fileList = jsonInsertTopic.getFileList();
        String shareLink = jsonInsertTopic.getShareLink();
        String title = jsonInsertTopic.getTitle();
        String tagList = jsonInsertTopic.getTagList();

        HttpManager.getHttpManager().getServer().getInsertTopic("topic/insertTopic", HttpUtils.getInserTpoic(userId,title,tagList,fileList,shareLink))
                .compose(RxUtils.<BaseData<InsertTopic>>rxObserableSchedulerHelper())
                .compose(RxUtils.<InsertTopic>handleResule())
                .subscribe(new BaseObserver<InsertTopic>(insertTopicM) {
                    @Override
                    public void onNext(InsertTopic insertTopic) {
                        insertTopicM.setShowInsertTopic(insertTopic);
                    }
                });
    }

}
