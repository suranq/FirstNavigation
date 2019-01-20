package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.contact.ListNewsCon;
import com.example.firstnavigation.modlue.ListNewsModlue;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class ListNewsPresenter<V extends ListNewsCon.ListNewsConV> extends BasePresenter<V> implements ListNewsCon.ListNewsConP, ListNewsCon.ListNewsConM {
    private ListNewsModlue mListNewsModlue = new ListNewsModlue();
    @Override
    public void getListNews(String json) {
        if (mView != null){
            mView.showProgressbar();
            mListNewsModlue.getListNews(json,this);
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
    public void setShowListNews(ListNews listNews) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showListNews(listNews);
        }
    }
}
