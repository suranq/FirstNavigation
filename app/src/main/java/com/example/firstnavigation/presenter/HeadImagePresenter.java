package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.HeadImage;
import com.example.firstnavigation.contact.HeadImageCon;
import com.example.firstnavigation.modlue.HeadImageModlue;

import java.util.Map;

/**
 * Created by 马明祥 on 2019/1/20.
 */

public class HeadImagePresenter<V extends HeadImageCon.ListNewsConV> extends BasePresenter<V> implements HeadImageCon.ListNewsConP, HeadImageCon.ListNewsConM {
    private HeadImageModlue mHeadImageModlue = new HeadImageModlue();
    @Override
    public void getHeadImage(Map<String,Object> map) {
        if (mView != null){
            mView.showProgressbar();
            mHeadImageModlue.getUploadHeadImage(map,this);
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
    public void setShowListNews(HeadImage headImage) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showListNews(headImage);
        }
    }
}
