package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.HomeList;
import com.example.firstnavigation.beans.HomePage;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public interface HomePageCon {
    interface HomePageV extends BaseView{
        void showHomePage(HomePage homePage);
        void showHomeList(HomeList homeList);
        void showFollow(Follow follow);
    }

    interface HomePageP{
        void getHomePage(String userId,String lookUserId);
        void getHomeList(String json);
        void getFollow(String json);
    }

    interface HomePageM extends BaseModuleHttpFinish{
        void setShowHomePage(HomePage homePage);
        void setShowHomeList(HomeList homeList);
        void setShowFollow(Follow follow);
    }
}
