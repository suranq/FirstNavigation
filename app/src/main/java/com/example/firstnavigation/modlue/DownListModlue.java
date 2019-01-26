package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.contactCon.DownListCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/21.
 */

public class DownListModlue {

    public void getDownListMod(String json,final DownListCon.DownListConM downListConM){

        downListConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getDownList("news/downListNews", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<DownList>>rxObserableSchedulerHelper())
                .compose(RxUtils.<DownList>handleResule())
                .subscribe(new BaseObserver<DownList>(downListConM) {
                    @Override
                    public void onNext(DownList downList) {
                        downListConM.setShowDownList(downList);
                    }
                });
    }

}
