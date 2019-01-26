package com.example.firstnavigation.contactCon;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.Topic;

/**
 * Created by 马明祥 on 2019/1/25.
 */

public interface TopicCon {

    interface TopicV extends BaseView{
        void showTopic(Topic topic);
    }

    interface TopicP{
        void getShowTopic(String json);
    }

    interface TopicM extends BaseModuleHttpFinish{
        void setShowTopic(Topic topic);
    }

}
