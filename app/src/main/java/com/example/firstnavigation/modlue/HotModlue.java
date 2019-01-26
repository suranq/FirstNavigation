package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.Hot;
import com.example.firstnavigation.contactCon.HotCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class HotModlue {

    public void getHotMod(String json, final HotCon.HotConM hotConM) {
        hotConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getHot("search/hot", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<Hot>>rxObserableSchedulerHelper())
                .compose(RxUtils.<Hot>handleResule())
                .subscribe(new BaseObserver<Hot>(hotConM) {
                    @Override
                    public void onNext(Hot hot) {
                        hotConM.setShowListNews(hot);
                    }
                });
    }
}
