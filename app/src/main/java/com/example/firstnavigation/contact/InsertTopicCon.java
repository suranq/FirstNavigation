package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.InsertTopic;
import com.example.firstnavigation.beans.ToTopic;

/**
 * Created by 马明祥 on 2019/2/7.
 */

public interface InsertTopicCon {
    interface InsertTopicV extends BaseView{
        void showInsertTopic(InsertTopic insertTopic);
    }

    interface InsertTopicP{
        void getInsertTopic(ToTopic toTopic);
    }

    interface InsertTopicM extends BaseModuleHttpFinish{
        void setShowInsertTopic(InsertTopic insertTopic);
    }
}
