package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.RelevantNews;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public interface RelevantNewsCon {

    interface RelevantNewsV extends BaseView {
        void showRelevantNews(RelevantNews relevantNews);
    }

    interface RelevantNewsP{
        void getRelevantNews(String newsId);
    }

    interface RelevantNewsM extends BaseModuleHttpFinish {
        void setShowRelevantNews(RelevantNews relevantNews);
    }

}
