package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.contact.DownListCon;
import com.example.firstnavigation.contact.ListNewsCon;
import com.example.firstnavigation.modlue.DownListModlue;
import com.example.firstnavigation.modlue.ListNewsModlue;

/**
 * Created by 马明祥 on 2019/1/21.
 */

public class DownListPresenter<V extends DownListCon.DownListConV> extends BasePresenter<V> implements DownListCon.DownListConP,DownListCon.DownListConM {
    private DownListModlue mDownListModlue = new DownListModlue();

    @Override
    public void getDownList(String json) {
        if (mView != null) {
            mView.showProgressbar();
            mDownListModlue.getDownListMod(json, this);
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
            mView.showError(error);
        }
    }

    @Override
    public void setShowDownList(DownList downList) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showDownList(downList);
        }
    }
}
