package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.ListTopic;
import com.example.firstnavigation.contact.ListTopicCon;
import com.example.firstnavigation.modlue.ListTopicModlue;

/**
 * Created by 马明祥 on 2019/2/17.
 */

public class ListTopicPresenter<V extends ListTopicCon.ListTopicV>extends BasePresenter<ListTopicCon.ListTopicV> implements ListTopicCon.ListTopicP, ListTopicCon.ListTopicM {
    private ListTopicModlue mListTopicModlue = new ListTopicModlue();
    @Override
    public void get(String userId, String cursor) {
        if (mView != null){
            mView.showProgressbar();
            mListTopicModlue.getListTopic(userId,cursor,this);
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
    public void setShowListTopic(ListTopic listTopic) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showListTopic(listTopic);
        }
    }
}
