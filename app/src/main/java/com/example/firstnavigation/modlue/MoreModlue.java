package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.contact.MoreCon;
import com.example.firstnavigation.contact.MoreFollowCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MoreModlue {
    public void getMoreFollow(String json, final MoreCon.MoreFollowM moreFollowM) {
        moreFollowM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getMoreFollow("users/moreFollow", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<MoreFollow>>rxObserableSchedulerHelper())
                .compose(RxUtils.<MoreFollow>handleResule())
                .subscribe(new BaseObserver<MoreFollow>(moreFollowM) {
                    @Override
                    public void onNext(MoreFollow moreFollow) {
                        moreFollowM.setShowMoreFollow(moreFollow);
                    }
                });
    }
}
