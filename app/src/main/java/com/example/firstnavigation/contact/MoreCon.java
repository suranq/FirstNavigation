package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.MoreFollow;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public interface MoreCon {
    interface MoreFollowV extends BaseView {
        void showMoreFollow(MoreFollow moreFollow);
    }

    interface MoreFollowP{
        void getMoreFollow(String json);
    }

    interface MoreFollowM extends BaseModuleHttpFinish {
        void setShowMoreFollow(MoreFollow moreFollow);
    }
}
