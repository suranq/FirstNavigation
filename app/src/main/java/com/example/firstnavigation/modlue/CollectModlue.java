package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.UserNews;
import com.example.firstnavigation.beans.UserTopic;
import com.example.firstnavigation.contact.CollectCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/10.
 */

public class CollectModlue {

    public void getUserNews(String userId, String cursor, final CollectCon.CollectM collectM) {
        collectM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getUserNews("users/favourite/news", HttpUtils.getCollect(userId, cursor)).compose(RxUtils.<BaseData<UserNews>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserNews>handleResule())
                .subscribe(new BaseObserver<UserNews>(collectM) {
                    @Override
                    public void onNext(UserNews userNews) {
                        collectM.setShowUserNews(userNews);
                    }
                });
    }

    public void getUserTopic(String userId, String cursor, final CollectCon.CollectM collectM) {
        collectM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getUserTopic("users/favourite/topic", HttpUtils.getCollect(userId, cursor)).compose(RxUtils.<BaseData<UserTopic>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserTopic>handleResule())
                .subscribe(new BaseObserver<UserTopic>(collectM) {
                    @Override
                    public void onNext(UserTopic userTopic) {
                        collectM.setShowUserTopic(userTopic);
                    }
                });
    }

}
