package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.ListProfession;
import com.example.firstnavigation.contact.ListProfessionCon;
import com.example.firstnavigation.modlue.ListProfessionModlue;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class ListProfessionPresenter<V extends ListProfessionCon.ListProfessionV> extends BasePresenter<ListProfessionCon.ListProfessionV> implements ListProfessionCon.ListProfessionP, ListProfessionCon.ListProfessionM {
    private ListProfessionModlue mListProfessionModlue = new ListProfessionModlue();
    @Override
    public void getListProfession(String json) {
        if (mView != null){
            mView.showProgressbar();
            mListProfessionModlue.getListProfession(json,this);
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
    public void setShowListProfession(ListProfession listProfession) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showListProfession(listProfession);
        }
    }
}
