package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.contact.MoreFollowCon;
import com.example.firstnavigation.modlue.MoreFollowModlue;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MoreFollowPresenter<V extends MoreFollowCon.MoreFollowV>extends BasePresenter<MoreFollowCon.MoreFollowV> implements MoreFollowCon.MoreFollowP, MoreFollowCon.MoreFollowM {
    private MoreFollowModlue mMoreFollowModlue = new MoreFollowModlue();
    @Override
    public void getTagsHot(String json) {
        if (mView != null){
            mView.showProgressbar();
            mMoreFollowModlue.getTagsHot(json,this);
        }
    }

    @Override
    public void getMoreFollow(String json) {
        if (mView != null){
            mView.showProgressbar();
            mMoreFollowModlue.getMoreFollow(json,this);
        }
    }

    @Override
    public void getTagsSearch(String json) {
        if (mView != null){
            mView.showProgressbar();
            mMoreFollowModlue.getTagsSearch(json,this);
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
    public void setShowTagsHot(TagsHot tagsHot) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showTagsHot(tagsHot);
        }
    }

    @Override
    public void setShowMoreFollow(MoreFollow moreFollow) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showMoreFollow(moreFollow);
        }
    }

    @Override
    public void setShowTagsSearch(TagsSearch tagsSearch) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showTagsSearch(tagsSearch);
        }
    }
}
