package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.UserNews;
import com.example.firstnavigation.beans.UserTopic;

/**
 * Created by 马明祥 on 2019/2/10.
 */

public interface CollectCon {

    interface CollectV extends BaseView{
        void showUserNews(UserNews userNews);
        void showUserTopic(UserTopic userTopic);
    }

    interface CollectP{
        void getUserNews(String userId,String cursor);
        void getUserTopic(String userId,String cursor);
    }

    interface CollectM extends BaseModuleHttpFinish{
        void setShowUserNews(UserNews userNews);
        void setShowUserTopic(UserTopic userTopic);
    }

}
