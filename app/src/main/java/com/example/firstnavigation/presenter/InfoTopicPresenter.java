package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.beans.Like;
import com.example.firstnavigation.beans.ListComment;
import com.example.firstnavigation.beans.TopicComment;
import com.example.firstnavigation.contact.InfoTopicCon;
import com.example.firstnavigation.modlue.InfoTopicModlue;

/**
 * Created by 马明祥 on 2019/1/31.
 */

public class InfoTopicPresenter<V extends InfoTopicCon.InfoTopicV>extends BasePresenter<InfoTopicCon.InfoTopicV> implements InfoTopicCon.InfoTopicP, InfoTopicCon.InfoTopicM {
    private InfoTopicModlue mInfoTopicModlue = new InfoTopicModlue();
    @Override
    public void getInfoTopic(String topicId, String userId) {
        if (mView != null){
            mView.showProgressbar();
            mInfoTopicModlue.getInfoTopic(topicId,userId,this);
        }
    }

    @Override
    public void getListComment(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoTopicModlue.getListComment(json,this);
        }
    }

    @Override
    public void getTopicComment(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoTopicModlue.getTopicComment(json,this);
        }
    }

    @Override
    public void getFavourite(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoTopicModlue.getFavourite(json,this);
        }
    }

    @Override
    public void getFollow(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoTopicModlue.getFollow(json,this);
        }
    }

    @Override
    public void getLike(String json) {
        if (mView != null){
            mView.showProgressbar();
            mInfoTopicModlue.getLike(json,this);
        }
    }

    @Override
    public void setShowProgressbar() {
        if (mView != null){
            mView.showProgressbar();
        }
    }

    @Override
    public void setHideProgressbar() {
        if (mView != null){
            mView.hideProgressbar();
        }
    }

    @Override
    public void setShowError(String error) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showError(error);
        }
    }

    @Override
    public void setShowInfoTopic(InfoTopic infoTopic) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showInfoTopic(infoTopic);
        }
    }

    @Override
    public void setShowListComment(ListComment listComment) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showListComment(listComment);
        }
    }

    @Override
    public void setShowTopicComment(TopicComment topicComment) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showTopicComment(topicComment);
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
    public void setShowFollow(Follow follow) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showFollow(follow);
        }
    }

    @Override
    public void setShowLike(Like like) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showLike(like);
        }
    }
}
