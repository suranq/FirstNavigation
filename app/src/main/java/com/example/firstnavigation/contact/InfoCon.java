package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.beans.Info;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public interface InfoCon {

    interface InfoConV extends BaseView {
        void showInfo(Info info);
    }

    interface InfoConP{
        void getInfo(String userId,String newsId);
    }

    interface InfoConM extends BaseModuleHttpFinish {
        void setShowInfo(Info info);
    }

}
