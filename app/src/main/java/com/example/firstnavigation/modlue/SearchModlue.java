package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.SearchBean;
import com.example.firstnavigation.contact.SearchCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class SearchModlue {

    public void getSearchMod(String json, final SearchCon.SearchConM searchConM) {
        searchConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getSearch("news/search", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<SearchBean>>rxObserableSchedulerHelper())
                .compose(RxUtils.<SearchBean>handleResule())
                .subscribe(new BaseObserver<SearchBean>(searchConM) {
                    @Override
                    public void onNext(SearchBean searchBean) {
                        searchConM.setShowSearch(searchBean);
                    }
                });
    }

}
