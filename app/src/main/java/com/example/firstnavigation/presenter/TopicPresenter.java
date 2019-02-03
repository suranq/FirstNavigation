package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.Topic;
import com.example.firstnavigation.contact.TopicCon;
import com.example.firstnavigation.modlue.TopicModlue;

/**
 * Created by 马明祥 on 2019/1/25.
 */

public class TopicPresenter<V extends TopicCon.TopicV> extends BasePresenter<V> implements TopicCon.TopicP, TopicCon.TopicM {
    private TopicModlue mTopicModlue = new TopicModlue();

    @Override
    public void getShowTopic(String json) {
        if (mView != null) {
            mView.showProgressbar();
            mTopicModlue.getTopic(json, this);
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
    public void setShowTopic(Topic topic) {
        if (mView != null) {
            mView.hideProgressbar();
            mView.showTopic(topic);
        }
    }
}
