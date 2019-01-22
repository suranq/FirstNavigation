package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.contact.RelevantNewsCon;
import com.example.firstnavigation.modlue.RelevantNewsModlue;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class RelevantNewsPresenter<V extends RelevantNewsCon.RelevantNewsV>extends BasePresenter<V> implements RelevantNewsCon.RelevantNewsP, RelevantNewsCon.RelevantNewsM {
    private RelevantNewsModlue mRelevantNewsModlue = new RelevantNewsModlue();
    @Override
    public void getRelevantNews(String newsId) {
        if (mView != null){
            mView.showProgressbar();
            mRelevantNewsModlue.getRelevantNews(newsId,this);
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
            mView.showError(error);
        }
    }

    @Override
    public void setShowRelevantNews(RelevantNews relevantNews) {
        if (mView != null){
            mView.showRelevantNews(relevantNews);
        }
    }
}
