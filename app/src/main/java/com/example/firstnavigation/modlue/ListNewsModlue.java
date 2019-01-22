package com.example.firstnavigation.modlue;

import android.util.Log;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.contact.ListNewsCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class ListNewsModlue {

    public void getListNewsMod(String json,final ListNewsCon.ListNewsConM listNewsConM){

        listNewsConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getListNews("news/listNewsChannel", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<ListNews>>rxObserableSchedulerHelper())
                .compose(RxUtils.<ListNews>handleResule())
                .subscribe(new BaseObserver<ListNews>(listNewsConM) {
                    @Override
                    public void onNext(ListNews listNews) {
                        listNewsConM.setShowListNews(listNews);
                    }
                });
    }

}
