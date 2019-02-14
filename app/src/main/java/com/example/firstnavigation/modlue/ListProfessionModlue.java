package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.ListProfession;
import com.example.firstnavigation.contact.ListProfessionCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class ListProfessionModlue {
    public void getListProfession(String json, final ListProfessionCon.ListProfessionM listProfessionM){
        listProfessionM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getListProfession("users/listProfession", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<ListProfession>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListProfession>handleResule())
                .subscribe(new BaseObserver<ListProfession>(listProfessionM) {
                    @Override
                    public void onNext(ListProfession listProfession) {
                        listProfessionM.setShowListProfession(listProfession);
                    }
                });
    }
}
