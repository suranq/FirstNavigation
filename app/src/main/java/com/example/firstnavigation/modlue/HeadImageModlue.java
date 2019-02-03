package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.HeadImage;
import com.example.firstnavigation.contact.HeadImageCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

import java.io.File;
import java.util.Map;

/**
 * Created by 马明祥 on 2019/1/20.
 */

public class HeadImageModlue {

    public void getUploadHeadImage(Map<String,Object> map, final HeadImageCon.ListNewsConM listNewsConM) {

        listNewsConM.setShowProgressbar();

        String userId = (String) map.get("userId");
        File file = (File) map.get("file");

        HttpManager.getHttpManager().getServer().getHeadImage("users/uploadHeadImage",HttpUtils.getUpLoadHeadImg(userId,file))
                .compose(RxUtils.<BaseData<HeadImage>>rxObserableSchedulerHelper())
                .compose(RxUtils.<HeadImage>handleResule())
                .subscribe(new BaseObserver<HeadImage>(listNewsConM) {
                    @Override
                    public void onNext(HeadImage value) {
                        listNewsConM.setShowListNews(value);
                    }
                });
    }

}
