package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.UserNews;
import com.example.firstnavigation.beans.UserTopic;
import com.example.firstnavigation.contact.CollectCon;
import com.example.firstnavigation.modlue.CollectModlue;

/**
 * Created by 马明祥 on 2019/2/10.
 */

public class CollectPresenter<V extends CollectCon.CollectV>extends BasePresenter<CollectCon.CollectV> implements CollectCon.CollectP, CollectCon.CollectM {
    private CollectModlue mCollectModlue = new CollectModlue();
    @Override
    public void getUserNews(String userId, String cursor) {
        if (mView != null){
            mView.showProgressbar();
            mCollectModlue.getUserNews(userId,cursor,this);
        }
    }

    @Override
    public void getUserTopic(String userId, String cursor) {
        if (mView != null){
            mView.showProgressbar();
            mCollectModlue.getUserTopic(userId,cursor,this);
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
    public void setShowUserNews(UserNews userNews) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showUserNews(userNews);
        }
    }

    @Override
    public void setShowUserTopic(UserTopic userTopic) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showUserTopic(userTopic);
        }
    }
}
