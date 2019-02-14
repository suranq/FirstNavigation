package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.contact.TagsHotCon;
import com.example.firstnavigation.modlue.TagsHotModlue;
import com.google.gson.Gson;

/**
 * Created by 马明祥 on 2019/2/8.
 */

public class TagsHotPresenter<V extends TagsHotCon.TagsHotV>extends BasePresenter<TagsHotCon.TagsHotV> implements TagsHotCon.TagsHotP, TagsHotCon.TagsHotM {
    private TagsHotModlue mTagsHotModlue = new TagsHotModlue();
    @Override
    public void getTagsHot(String json) {
        if (mView != null){
            mView.showProgressbar();
            mTagsHotModlue.getTagsHot(json,this);
        }
    }

    @Override
    public void getTagsSearch(String json) {
        if (mView != null){
            mView.showProgressbar();
            mTagsHotModlue.getTagsSearch(json,this);
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
    public void setShowTagsHot(TagsHot tagsHot) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showTagsHot(tagsHot);
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
