package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.InsertTopic;
import com.example.firstnavigation.contact.InsertTopicCon;
import com.example.firstnavigation.json.JsonInsertTopic;
import com.example.firstnavigation.modlue.InsertTopicModlue;

/**
 * Created by 马明祥 on 2019/2/8.
 */

public class InsertTopicPresenter<V extends InsertTopicCon.InsertTopicV>extends BasePresenter<InsertTopicCon.InsertTopicV> implements InsertTopicCon.InsertTopicP, InsertTopicCon.InsertTopicM {
    private InsertTopicModlue mInsertTopicModlue = new InsertTopicModlue();
    @Override
    public void getInsertTopic(JsonInsertTopic jsonInsertTopic) {
        if (mView != null){
            mView.showProgressbar();
            mInsertTopicModlue.getInsertTopic(jsonInsertTopic,this);
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
    public void setShowInsertTopic(InsertTopic insertTopic) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showInsertTopic(insertTopic);
        }
    }
}
