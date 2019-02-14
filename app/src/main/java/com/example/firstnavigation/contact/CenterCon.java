package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.Center;
import com.example.firstnavigation.beans.Hot;

/**
 * Created by 马明祥 on 2019/2/9.
 */

public interface CenterCon {

    interface CenterConV extends BaseView {
        void showCenterCon(Center center);
    }

    interface CenterConP{
        void getCenterCon(String userId);
    }

    interface CenterConM extends BaseModuleHttpFinish {
        void setShowCenterCon(Center center);
    }

}
