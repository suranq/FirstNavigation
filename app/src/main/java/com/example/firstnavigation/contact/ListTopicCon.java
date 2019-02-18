package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.ListTopic;

/**
 * Created by 马明祥 on 2019/2/17.
 */

public interface ListTopicCon {
    interface ListTopicV extends BaseView{
        void showListTopic(ListTopic listTopic);
    }

    interface ListTopicP{
        void get(String userId,String cursor);
    }

    interface ListTopicM extends BaseModuleHttpFinish{
        void setShowListTopic(ListTopic listTopic);
    }
}
