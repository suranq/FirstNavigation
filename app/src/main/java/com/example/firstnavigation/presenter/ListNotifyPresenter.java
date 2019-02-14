package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.ListNotify;
import com.example.firstnavigation.contact.ListNotifyCon;
import com.example.firstnavigation.modlue.ListNotifyModlue;

/**
 * Created by 马明祥 on 2019/2/13.
 */

public class ListNotifyPresenter<V extends ListNotifyCon.ListNotifyV>extends BasePresenter<ListNotifyCon.ListNotifyV> implements ListNotifyCon.ListNotifyP, ListNotifyCon.ListNotifyM {
    private ListNotifyModlue mListNotifyModlue = new ListNotifyModlue();
    @Override
    public void getListNotify(String userId) {
        if (mView != null){
            mView.showProgressbar();
            mListNotifyModlue.getListNotify(userId,this);
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
    public void setShowListNotify(ListNotify listNotify) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showListNotify(listNotify);
        }
    }
}
