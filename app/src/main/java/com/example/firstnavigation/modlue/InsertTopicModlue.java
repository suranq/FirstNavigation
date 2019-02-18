package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.InsertTopic;
import com.example.firstnavigation.beans.ToTopic;
import com.example.firstnavigation.contact.InsertTopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by 马明祥 on 2019/2/7.
 */

public class InsertTopicModlue {

    public void getInsertTopic(ToTopic toTopic, final InsertTopicCon.InsertTopicM insertTopicM) {
        insertTopicM.setShowProgressbar();

        String userId = toTopic.getUserId();
        String title = toTopic.getTitle();
        String tagList = toTopic.getTagList();
        String shareLink = toTopic.getShareLink();
        List<String> fileList = toTopic.getFileList();

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userId", userId)
                .addFormDataPart("title", title)
                .addFormDataPart("tagList", tagList);

        for (int i = 0; i < fileList.size(); i++) {
            String path = fileList.get(i);
            File file = new File(path);
            if (file.exists()) {
                RequestBody body = RequestBody.create(MediaType.parse("image/png"), file);
                builder.addFormDataPart("fileList", file.getName(), body);
            }
        }
        RequestBody body = builder.build();
        HttpManager.getHttpManager().getServer().getInsertTopic("topic/insertTopic", body)
                .compose(RxUtils.<InsertTopic>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<InsertTopic>(insertTopicM) {
                    @Override
                    public void onNext(InsertTopic insertTopic) {
                        insertTopicM.setShowInsertTopic(insertTopic);
                    }
                });
    }

}
