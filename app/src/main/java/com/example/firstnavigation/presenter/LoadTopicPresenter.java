package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.LoadTopic;
import com.example.firstnavigation.contact.LoadTopicCon;
import com.example.firstnavigation.modlue.LoadTopicModlue;

/**
 * Created by 马明祥 on 2019/1/27.
 */

public class LoadTopicPresenter<V extends LoadTopicCon.LoadTopicV>extends BasePresenter<V> implements LoadTopicCon.LoadTopicP, LoadTopicCon.LoadTopicM {
    private LoadTopicModlue mLoadTopicModlue = new LoadTopicModlue();
    @Override
    public void getLoadTopic(String json) {
        if (mView != null){
            mView.showProgressbar();
            mLoadTopicModlue.getLoadTopicMod(json,this);
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
        }
    }

    @Override
    public void setShowLoadTopic(LoadTopic loadTopic) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showLoadTTopic(loadTopic);
        }
    }
}
