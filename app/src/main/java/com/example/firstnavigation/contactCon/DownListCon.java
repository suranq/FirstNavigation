package com.example.firstnavigation.contactCon;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.DownList;

/**
 * Created by 马明祥 on 2019/1/21.
 */

public interface DownListCon {

    interface DownListConV extends BaseView {
        void showDownList(DownList downList);
    }

    interface DownListConP{
        void getDownList(String json);
    }

    interface DownListConM extends BaseModuleHttpFinish {
        void setShowDownList(DownList downList);
    }

}
