package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.Question;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public interface QuestionCon {
    interface QuestionV extends BaseView{
        void showQuestion(Question question);
    }

    interface QuestionP{
        void getQuestion(String json);
    }

    interface QuestionM extends BaseModuleHttpFinish{
        void setShowQuestion(Question question);
    }
}
