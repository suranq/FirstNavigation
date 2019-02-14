package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.Center;
import com.example.firstnavigation.contact.CenterCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/9.
 */

public class CenterModlue {

    public void getCenter(String userId, final CenterCon.CenterConM centerConM){
        centerConM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getCenter("users/center", HttpUtils.getCenter(userId)).compose(RxUtils.<BaseData<Center>>rxObserableSchedulerHelper())
                .compose(RxUtils.<Center>handleResule())
                .subscribe(new BaseObserver<Center>(centerConM) {
                    @Override
                    public void onNext(Center center) {
                        centerConM.setShowCenterCon(center);
                    }
                });
    }

}
