package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.HomeList;
import com.example.firstnavigation.beans.HomePage;
import com.example.firstnavigation.contact.HomePageCon;
import com.example.firstnavigation.contact.InfoTopicCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class HomePageModlue {

    public void getHomePage(String userId, String lookUserId, final HomePageCon.HomePageM homePageM){
        homePageM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getHomePage("users/homePage/info", HttpUtils.getHomePage(userId,lookUserId)).compose(RxUtils.<BaseData<HomePage>>rxObserableSchedulerHelper())
                .compose(RxUtils.<HomePage>handleResule())
                .subscribe(new BaseObserver<HomePage>(homePageM) {
                    @Override
                    public void onNext(HomePage homePage) {
                        homePageM.setShowHomePage(homePage);
                    }
                });
    }

    public void getHomeList(String json, final HomePageCon.HomePageM homePageM){
        homePageM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getHomeList("users/homePage/list",HttpUtils.getBody(json)).compose(RxUtils.<BaseData<HomeList>>rxObserableSchedulerHelper())
                .compose(RxUtils.<HomeList>handleResule())
                .subscribe(new BaseObserver<HomeList>(homePageM) {
                    @Override
                    public void onNext(HomeList homeList) {
                        homePageM.setShowHomeList(homeList);
                    }
                });
    }

    public void getFollow(String json, final HomePageCon.HomePageM homePageM){
        homePageM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getFollow("users/follow", HttpUtils.getBody(json)).compose(RxUtils.<Follow>rxObserableSchedulerHelper())
//                .compose(RxUtils.<TopicComment>handleResule())
                .subscribe(new BaseObserver<Follow>(homePageM) {
                    @Override
                    public void onNext(Follow follow) {
                        homePageM.setShowFollow(follow);
                    }
                });
    }
}
