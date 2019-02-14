package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.UserListComment;
import com.example.firstnavigation.contact.UserListCommentCon;
import com.example.firstnavigation.modlue.UserListCommentModlue;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class UserListCommentPresenter<V extends UserListCommentCon.UserListCommentV>extends BasePresenter<UserListCommentCon.UserListCommentV> implements UserListCommentCon.UserListCommentP, UserListCommentCon.UserListCommentM {
    private UserListCommentModlue mUserListCommentModlue = new UserListCommentModlue();
    @Override
    public void getUserListComment(String userId) {
        if (mView != null){
            mView.showProgressbar();
            mUserListCommentModlue.getUserListComment(userId,this);
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
    public void setShowUserListComment(UserListComment userListComment) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showUserListComment(userListComment);
        }
    }
}
