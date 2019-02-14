package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.Center;
import com.example.firstnavigation.contact.CenterCon;
import com.example.firstnavigation.modlue.CenterModlue;

/**
 * Created by 马明祥 on 2019/2/9.
 */

public class CenterPresenter<V extends CenterCon.CenterConV>extends BasePresenter<CenterCon.CenterConV> implements CenterCon.CenterConP, CenterCon.CenterConM {
    private CenterModlue mCenterModlue = new CenterModlue();
    @Override
    public void getCenterCon(String userId) {
        if (mView != null){
            mView.showProgressbar();
            mCenterModlue.getCenter(userId,this);
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
    public void setShowCenterCon(Center center) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showCenterCon(center);
        }
    }
}
