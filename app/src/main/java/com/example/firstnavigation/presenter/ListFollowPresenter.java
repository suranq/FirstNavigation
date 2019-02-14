package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.ListFollow;
import com.example.firstnavigation.contact.ListFollowCon;
import com.example.firstnavigation.modlue.ListFollowModlue;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class ListFollowPresenter<V extends ListFollowCon.ListFollowV>extends BasePresenter<ListFollowCon.ListFollowV> implements ListFollowCon.ListFollowP, ListFollowCon.ListFollowM {
    private ListFollowModlue mListFollowModlue = new ListFollowModlue();
    @Override
    public void getListFollow(String userId) {
        if (mView != null){
            mView.showProgressbar();
            mListFollowModlue.getListFollow(userId,this);
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
    public void setShowListFollow(ListFollow listFollow) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showListFollow(listFollow);
        }
    }
}
