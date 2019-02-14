package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.ListFollow;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public interface ListFollowCon {

    interface ListFollowV extends BaseView{
        void showListFollow(ListFollow listFollow);
    }

    interface ListFollowP{
        void getListFollow(String userId);
    }

    interface ListFollowM extends BaseModuleHttpFinish{
        void setShowListFollow(ListFollow listFollow);
    }

}
