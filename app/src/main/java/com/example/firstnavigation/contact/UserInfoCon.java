package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.UpDataInfo;
import com.example.firstnavigation.beans.UserInfo;

/**
 * Created by 马明祥 on 2019/2/10.
 */

public interface UserInfoCon {
    interface UserInfoV extends BaseView {
        void showUserInfo(UserInfo userInfo);
        void showUpDataInfo(UpDataInfo upDataInfo);
    }

    interface UserInfoP{
        void getUserInfo(String userId);
        void getUpDataInfo(String json);
    }

    interface UserInfoM extends BaseModuleHttpFinish {
        void setShowUserInfo(UserInfo userInfo);
        void setShowUpDataInfo(UpDataInfo upDataInfo);
    }
}
