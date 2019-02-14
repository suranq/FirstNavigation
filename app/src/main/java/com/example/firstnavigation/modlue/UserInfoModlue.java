package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.Center;
import com.example.firstnavigation.beans.UpDataInfo;
import com.example.firstnavigation.beans.UserInfo;
import com.example.firstnavigation.contact.CenterCon;
import com.example.firstnavigation.contact.UserInfoCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

import retrofit2.http.Url;

/**
 * Created by 马明祥 on 2019/2/10.
 */

public class UserInfoModlue {

    public void getCenter(String userId, final UserInfoCon.UserInfoM userInfoM){
        userInfoM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getUserInfo("users/info", HttpUtils.getCenter(userId)).compose(RxUtils.<BaseData<UserInfo>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserInfo>handleResule())
                .subscribe(new BaseObserver<UserInfo>(userInfoM) {
                    @Override
                    public void onNext(UserInfo userInfo) {
                        userInfoM.setShowUserInfo(userInfo);
                    }
                });
    }

    public void getUpDataInfo(String json, final UserInfoCon.UserInfoM userInfoM){
        userInfoM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getUpdataInfo("users/updateInfo", HttpUtils.getBody(json)).compose(RxUtils.<UpDataInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<UpDataInfo>(userInfoM) {
                    @Override
                    public void onNext(UpDataInfo upDataInfo) {
                        userInfoM.setShowUpDataInfo(upDataInfo);
                    }
                });
    }

}
