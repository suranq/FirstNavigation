package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.contact.MoreCon;
import com.example.firstnavigation.modlue.MoreModlue;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MorePresenter<V extends MoreCon.MoreFollowV>extends BasePresenter<MoreCon.MoreFollowV> implements MoreCon.MoreFollowP, MoreCon.MoreFollowM {
    private MoreModlue mMoreModlue = new MoreModlue();
    @Override
    public void getMoreFollow(String json) {
        if (mView != null){
            mView.showProgressbar();
            mMoreModlue.getMoreFollow(json,this);
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
    public void setShowMoreFollow(MoreFollow moreFollow) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showMoreFollow(moreFollow);
        }
    }
}
