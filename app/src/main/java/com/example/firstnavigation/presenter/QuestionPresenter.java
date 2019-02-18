package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.Question;
import com.example.firstnavigation.contact.QuestionCon;
import com.example.firstnavigation.modlue.QuestionModlue;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class QuestionPresenter<V extends QuestionCon.QuestionV>extends BasePresenter<QuestionCon.QuestionV> implements QuestionCon.QuestionP, QuestionCon.QuestionM {
    private QuestionModlue mQuestionModlue = new QuestionModlue();
    @Override
    public void getQuestion(String json) {
        if (mView != null){
            mView.showProgressbar();
            mQuestionModlue.getQuestion(json,this);
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
    public void setShowQuestion(Question question) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showQuestion(question);
        }
    }
}
