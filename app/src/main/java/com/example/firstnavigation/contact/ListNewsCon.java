package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.ListNews;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public interface ListNewsCon {

    interface ListNewsConV extends BaseView{
        void showListNews(ListNews listNews);
    }

    interface ListNewsConP{
        void getListNews(String json);
    }

    interface ListNewsConM extends BaseModuleHttpFinish{
        void setShowListNews(ListNews listNews);
    }

}
