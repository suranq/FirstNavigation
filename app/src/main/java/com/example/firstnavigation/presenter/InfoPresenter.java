package com.example.firstnavigation.presenter;

import android.util.Log;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.beans.TopicComment;
import com.example.firstnavigation.contact.InfoCon;
import com.example.firstnavigation.modlue.InfoModlue;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class InfoPresenter<V extends InfoCon.InfoConV> extends BasePresenter<V> implements InfoCon.InfoConP, InfoCon.InfoConM {
    private InfoModlue mInfoModlue = new InfoModlue();
    @Override
    public void getInfo(String userId,String newsId) {
        if (mView != null){
            mView.showProgressbar();
            mInfoModlue.getDownListMod(userId,newsId,this);
        }
    }

    @Override
    public void getRelevantNews(String newsId) {
        if (mView != null){
            mView.showProgressbar();
            mInfoModlue.getRelevantNews(newsId,this);
        }
    }

    @Override
    public void getCommentList(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoModlue.getCommentList(json,this);
        }
    }

    @Override
    public void getFavourite(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoModlue.getFavourite(json,this);
        }
    }

    @Override
    public void getTopicComment(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoModlue.getTopicComment(json,this);
        }
    }

    @Override
    public void setShowProgressbar() {
        if (mView != null) {
            mView.showProgressbar();
        }
    }

    @Override
    public void setHideProgressbar() {
        if (mView != null) {
            mView.hideProgressbar();
        }
    }

    @Override
    public void setShowError(String error) {
        if (mView != null) {
            mView.hideProgressbar();
            mView.showError(error);
        }
    }

    @Override
    public void setShowInfo(Info info) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showInfo(info);
        }
    }

    @Override
    public void setShowRelevantNews(RelevantNews relevantNews) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showRelevantNews(relevantNews);
        }
    }

    @Override
    public void setShowCommentList(CommentList commentList) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showCommentList(commentList);
        }
    }

    @Override
    public void setShowFavourite(Favourite favourite) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showFavourite(favourite);
        }
    }

    @Override
    public void setShowTopicComment(TopicComment topicComment) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showTopicComment(topicComment);
        }
    }
}
