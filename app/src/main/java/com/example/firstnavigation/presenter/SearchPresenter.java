package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.SearchBean;
import com.example.firstnavigation.contactCon.SearchCon;
import com.example.firstnavigation.modlue.SearchModlue;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class SearchPresenter<V extends SearchCon.SearchConV>extends BasePresenter<V> implements SearchCon.SearchConP, SearchCon.SearchConM {
    private SearchModlue mSearchModlue = new SearchModlue();
    @Override
    public void getSearch(String json) {
        if (mView != null){
            mView.showProgressbar();
            mSearchModlue.getSearchMod(json,this);
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
    public void setShowSearch(SearchBean searchBean) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showSearch(searchBean);
        }
    }
}
