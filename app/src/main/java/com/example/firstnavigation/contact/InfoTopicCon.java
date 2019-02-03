package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.InfoTopic;

/**
 * Created by 马明祥 on 2019/1/31.
 */

public interface InfoTopicCon {

    interface InfoTopicV extends BaseView{
        void showInfoTopic(InfoTopic infoTopic);
    }

    interface InfoTopicP{
        void getInfoTopic(String topicId,String userId);
    }

    interface InfoTopicM extends BaseModuleHttpFinish{
        void setShowInfoTopic(InfoTopic infoTopic);
    }

}
