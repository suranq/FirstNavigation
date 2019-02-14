package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.UserListComment;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public interface UserListCommentCon {

    interface UserListCommentV extends BaseView{
        void showUserListComment(UserListComment userListComment);
    }

    interface UserListCommentP{
        void getUserListComment(String userId);
    }

    interface UserListCommentM extends BaseModuleHttpFinish{
        void setShowUserListComment(UserListComment userListComment);
    }

}
