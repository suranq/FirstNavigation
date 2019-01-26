package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.Hot;
import com.example.firstnavigation.contactCon.HotCon;
import com.example.firstnavigation.modlue.HotModlue;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class HotPresenter<V extends HotCon.HotConV> extends BasePresenter<V> implements HotCon.HotConP, HotCon.HotConM {
    private HotModlue mHotModlue = new HotModlue();

    @Override
    public void getHeadImage(String json) {
        if (mView != null) {
            mView.showProgressbar();
            mHotModlue.getHotMod(json, this);
        }
    }

    @Override
    public void setShowProgressbar() {
        if (mView != null) {
            mView.showProgressbar();
        }
    }

    @Override
    public void setHideProgressbar() {
        if (mView != null) {
            mView.hideProgressbar();
        }
    }

    @Override
    public void setShowError(String error) {
        if (mView != null) {
            mView.hideProgressbar();
        }
    }

    @Override
    public void setShowListNews(Hot hot) {
        if (mView != null) {
            mView.hideProgressbar();
            mView.showListNews(hot);
        }
    }
}
