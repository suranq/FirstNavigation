package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.ListFollow;
import com.example.firstnavigation.contact.ListFollowCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class ListFollowModlue {

    public void getListFollow(String userId, final ListFollowCon.ListFollowM listFollowM){
        listFollowM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getListFollow("users/listFollow", HttpUtils.getCenter(userId)).compose(RxUtils.<BaseData<ListFollow>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListFollow>handleResule())
                .subscribe(new BaseObserver<ListFollow>(listFollowM) {
                    @Override
                    public void onNext(ListFollow listFollow) {
                        listFollowM.setShowListFollow(listFollow);
                    }
                });
    }

}
