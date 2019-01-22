package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.contact.RelevantNewsCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class RelevantNewsModlue {

    public void getRelevantNews(String newsId, final RelevantNewsCon.RelevantNewsM relevantNewsM) {

        relevantNewsM.setShowProgressbar();

        HttpManager.getHttpManager().getServer().getRelevantNews("news/relevant", HttpUtils.getBodyRelevant(newsId)).compose(RxUtils.<BaseData<RelevantNews>>rxObserableSchedulerHelper())
                .compose(RxUtils.<RelevantNews>handleResule())
                .subscribe(new BaseObserver<RelevantNews>(relevantNewsM) {
                    @Override
                    public void onNext(RelevantNews relevantNews) {
                        relevantNewsM.setShowRelevantNews(relevantNews);
                    }
                });

    }

}
