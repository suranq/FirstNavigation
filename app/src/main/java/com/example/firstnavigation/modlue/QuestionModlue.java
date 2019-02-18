package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.Question;
import com.example.firstnavigation.contact.QuestionCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class QuestionModlue {
    public void getQuestion(String json, final QuestionCon.QuestionM questionM){
        HttpManager.getHttpManager().getServer().getQuestion("users/question", HttpUtils.getBody(json)).compose(RxUtils.<Question>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Question>(questionM) {
                    @Override
                    public void onNext(Question question) {
                        questionM.setShowQuestion(question);
                    }
                });
    }
}
