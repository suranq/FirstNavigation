package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.UserListComment;
import com.example.firstnavigation.contact.UserListCommentCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class UserListCommentModlue {
    public void getUserListComment(String userId, final UserListCommentCon.UserListCommentM userListCommentM){
        userListCommentM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getUserListComment("users/listComment", HttpUtils.getCenter(userId)).compose(RxUtils.<BaseData<UserListComment>>rxObserableSchedulerHelper())
                .compose(RxUtils.<UserListComment>handleResule())
                .subscribe(new BaseObserver<UserListComment>(userListCommentM) {
                    @Override
                    public void onNext(UserListComment userListComment) {
                        userListCommentM.setShowUserListComment(userListComment);
                    }
                });
    }
}
