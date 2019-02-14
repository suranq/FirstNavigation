package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.ListNotify;
import com.example.firstnavigation.contact.ListNotifyCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/13.
 */

public class ListNotifyModlue {
    public void getListNotify(String userId, final ListNotifyCon.ListNotifyM listNotifyM){
        listNotifyM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getListNotify("users/listNotify", HttpUtils.getCenter(userId)).compose(RxUtils.<ListNotify>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ListNotify>(listNotifyM) {
                    @Override
                    public void onNext(ListNotify listNotify) {
                        listNotifyM.setShowListNotify(listNotify);
                    }
                });
    }
}
