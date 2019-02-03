package com.example.firstnavigation.presenter;

import android.util.Log;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.RelevantNews;
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
            Log.e("有了吗有了吗",newsId);
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
            Log.e("有了吗有了吗",relevantNews.getTitle());
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
}
