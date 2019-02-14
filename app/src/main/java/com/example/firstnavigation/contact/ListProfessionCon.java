package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.ListProfession;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public interface ListProfessionCon {

    interface ListProfessionV extends BaseView{
        void showListProfession(ListProfession listProfession);
    }

    interface ListProfessionP{
        void getListProfession(String json);
    }

    interface ListProfessionM extends BaseModuleHttpFinish{
        void setShowListProfession(ListProfession listProfession);
    }

}
