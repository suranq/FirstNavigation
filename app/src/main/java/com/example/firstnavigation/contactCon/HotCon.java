package com.example.firstnavigation.contactCon;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.Hot;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public interface HotCon {

    interface HotConV extends BaseView {
        void showListNews(Hot hot);
    }

    interface HotConP{
        void getHeadImage(String json);
    }

    interface HotConM extends BaseModuleHttpFinish {
        void setShowListNews(Hot hot);
    }

}
