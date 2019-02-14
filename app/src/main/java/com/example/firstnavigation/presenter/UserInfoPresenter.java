package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.UpDataInfo;
import com.example.firstnavigation.beans.UserInfo;
import com.example.firstnavigation.contact.UserInfoCon;
import com.example.firstnavigation.modlue.UserInfoModlue;

/**
 * Created by 马明祥 on 2019/2/10.
 */

public class UserInfoPresenter<V extends UserInfoCon.UserInfoV>extends BasePresenter<UserInfoCon.UserInfoV> implements UserInfoCon.UserInfoP, UserInfoCon.UserInfoM {
    private UserInfoModlue mUserInfoModlue = new UserInfoModlue();
    @Override
    public void getUserInfo(String userId) {
        if (mView != null){
            mView.showProgressbar();
            mUserInfoModlue.getCenter(userId,this);
        }
    }

    @Override
    public void getUpDataInfo(String json) {
        if (mView != null){
            mView.showProgressbar();
            mUserInfoModlue.getUpDataInfo(json,this);
        }
    }

    @Override
    public void setShowProgressbar() {
        if (mView != null){
            mView.showProgressbar();
        }
    }

    @Override
    public void setHideProgressbar() {
        if (mView != null){
            mView.hideProgressbar();
        }
    }

    @Override
    public void setShowError(String error) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showError(error);
        }
    }

    @Override
    public void setShowUserInfo(UserInfo userInfo) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showUserInfo(userInfo);
        }
    }

    @Override
    public void setShowUpDataInfo(UpDataInfo upDataInfo) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showUpDataInfo(upDataInfo);
        }
    }
}
