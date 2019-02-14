package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.ListNotify;

/**
 * Created by 马明祥 on 2019/2/13.
 */

public interface ListNotifyCon {
    interface ListNotifyV extends BaseView{
        void showListNotify(ListNotify listNotify);
    }

    interface ListNotifyP{
        void getListNotify(String userId);
    }

    interface ListNotifyM extends BaseModuleHttpFinish{
        void setShowListNotify(ListNotify listNotify);
    }
}
