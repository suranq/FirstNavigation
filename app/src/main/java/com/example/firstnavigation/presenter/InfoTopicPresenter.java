package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.contact.InfoTopicCon;
import com.example.firstnavigation.modlue.InfoTopicModlue;

/**
 * Created by 马明祥 on 2019/1/31.
 */

public class InfoTopicPresenter<V extends InfoTopicCon.InfoTopicV>extends BasePresenter<InfoTopicCon.InfoTopicV> implements InfoTopicCon.InfoTopicP, InfoTopicCon.InfoTopicM {
    private InfoTopicModlue mInfoTopicModlue = new InfoTopicModlue();
    @Override
    public void getInfoTopic(String topicId, String userId) {
        if (mView != null){
            mView.showProgressbar();
            mInfoTopicModlue.getInfoTopic(topicId,userId,this);
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
    public void setShowInfoTopic(InfoTopic infoTopic) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showInfoTopic(infoTopic);
        }
    }
}
