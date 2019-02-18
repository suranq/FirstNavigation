package com.example.firstnavigation.presenter;

import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.HomeList;
import com.example.firstnavigation.beans.HomePage;
import com.example.firstnavigation.contact.HomePageCon;
import com.example.firstnavigation.modlue.HomePageModlue;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class HomeListPresenter<V extends HomePageCon.HomePageV>extends BasePresenter<HomePageCon.HomePageV> implements HomePageCon.HomePageP, HomePageCon.HomePageM {
    private HomePageModlue mHomePageModlue = new HomePageModlue();
    @Override
    public void getHomePage(String userId, String lookUserId) {
        if (mView != null){
            mView.showProgressbar();
            mHomePageModlue.getHomePage(userId,lookUserId,this);
        }
    }

    @Override
    public void getHomeList(String json) {
        if (mView != null){
            mView.showProgressbar();
            mHomePageModlue.getHomeList(json,this);
        }
    }

    @Override
    public void getFollow(String json) {
        if (mView != null){
            mView.showProgressbar();
            mHomePageModlue.getFollow(json,this);
        }
    }

    @Override
    public void setShowProgressbar() {
        if (mView != null){
            mView.showProgressbar();
        }
    }

    @Override
    public void setHideProgressbar() {
        if (mView != null){
            mView.hideProgressbar();
        }
    }

    @Override
    public void setShowError(String error) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showError(error);
        }
    }

    @Override
    public void setShowHomePage(HomePage homePage) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showHomePage(homePage);
        }
    }

    @Override
    public void setShowHomeList(HomeList homeList) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showHomeList(homeList);
        }
    }

    @Override
    public void setShowFollow(Follow follow) {
        if (mView != null){
            mView.hideProgressbar();
            mView.showFollow(follow);
        }
    }
}
