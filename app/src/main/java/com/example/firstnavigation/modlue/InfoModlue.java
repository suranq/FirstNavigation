package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.contact.DownListCon;
import com.example.firstnavigation.contact.InfoCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class InfoModlue {

    public void getDownListMod(String userId,String newsId, final InfoCon.InfoConM infoConM) {

        infoConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getInfo("news/info", HttpUtils.getBody2(userId,newsId)).compose(RxUtils.<BaseData<Info>>rxObserableSchedulerHelper())
                .compose(RxUtils.<Info>handleResule())
                .subscribe(new BaseObserver<Info>(infoConM) {
                    @Override
                    public void onNext(Info info) {
                        infoConM.setShowInfo(info);
                    }
                });
    }

}
