package com.example.firstnavigation.contactCon;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.LoadTopic;

/**
 * Created by 马明祥 on 2019/1/27.
 */

public interface LoadTopicCon {
    interface LoadTopicV extends BaseView {
        void showLoadTTopic(LoadTopic loadTopic);
    }

    interface LoadTopicP {
        void getLoadTopic(String json);
    }

    interface LoadTopicM extends BaseModuleHttpFinish {
        void setShowLoadTopic(LoadTopic loadTopic);
    }
}
