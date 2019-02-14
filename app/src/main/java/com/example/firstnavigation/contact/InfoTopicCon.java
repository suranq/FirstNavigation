package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.beans.Like;
import com.example.firstnavigation.beans.ListComment;
import com.example.firstnavigation.beans.TopicComment;

/**
 * Created by 马明祥 on 2019/1/31.
 */

public interface InfoTopicCon {

    interface InfoTopicV extends BaseView{
        void showInfoTopic(InfoTopic infoTopic);
        void showListComment(ListComment listComment);
        void showTopicComment(TopicComment topicComment);
        void showFavourite(Favourite favourite);
        void showFollow(Follow follow);
        void showLike(Like like);
    }

    interface InfoTopicP{
        void getInfoTopic(String topicId,String userId);
        void getListComment(String json);
        void getTopicComment(String json);
        void getFavourite(String json);
        void getFollow(String json);
        void getLike(String json);
    }

    interface InfoTopicM extends BaseModuleHttpFinish{
        void setShowInfoTopic(InfoTopic infoTopic);
        void setShowListComment(ListComment listComment);
        void setShowTopicComment(TopicComment topicComment);
        void setShowFavourite(Favourite favourite);
        void setShowFollow(Follow follow);
        void setShowLike(Like like);
    }

}
