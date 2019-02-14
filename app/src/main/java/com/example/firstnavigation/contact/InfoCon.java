package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.beans.TopicComment;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public interface InfoCon {

    interface InfoConV extends BaseView {
        void showInfo(Info info);
        void showRelevantNews(RelevantNews relevantNews);
        void showCommentList(CommentList commentList);
        void showFavourite(Favourite favourite);
        void showTopicComment(TopicComment topicComment);
    }

    interface InfoConP{
        void getInfo(String userId,String newsId);
        void getRelevantNews(String newsId);
        void getCommentList(String json);
        void getFavourite(String json);
        void getTopicComment(String json);
    }

    interface InfoConM extends BaseModuleHttpFinish {
        void setShowInfo(Info info);
        void setShowRelevantNews(RelevantNews relevantNews);
        void setShowCommentList(CommentList commentList);
        void setShowFavourite(Favourite favourite);
        void setShowTopicComment(TopicComment topicComment);
    }

}
