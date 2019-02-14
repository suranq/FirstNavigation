package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MoreFollow {

    /**
     * cursor : 2
     * moreFollowList : [{"followers":9,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-10-16/f6b1f90fbef24225a3134027472dfc74_1539652214263.jpg","nickname":"567890","userId":"f6b1f90fbef24225a3134027472dfc74"},{"followers":9,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-14/c383f4c9026d471da0184ad5b24c0365_1550074950470.png","nickname":"法号：老秃驴","userId":"c383f4c9026d471da0184ad5b24c0365"},{"followers":7,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-10-15/ef65f6b253ca489692f83d5d001bc5ad_1539604917889.jpeg","nickname":"别改我名字","userId":"ef65f6b253ca489692f83d5d001bc5ad"},{"followers":6,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-10-13/b21b6cc7b8b84ffc8fb2b6580b1bb1fe_1539401283346.gif","nickname":"MPF","userId":"b21b6cc7b8b84ffc8fb2b6580b1bb1fe"},{"followers":6,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-10-15/12eccff70db24f418aa457c57df0d989_1539600336923.jpg","nickname":"顾北清歌寒","userId":"12eccff70db24f418aa457c57df0d989"},{"followers":6,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-10-11/fb0327c3c8154d829f11c99db9f3eba3_1539259607652.jpg","nickname":"宇宙最帅","userId":"fb0327c3c8154d829f11c99db9f3eba3"},{"followers":5,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-11/606e6a420c054eba9dc2db267bb631c1_1549881882609.jpg","nickname":"user72172169","userId":"606e6a420c054eba9dc2db267bb631c1"},{"followers":3,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-10-12/1c4a230c5a624d6f88e24e1e78bcdb35_1539323978690.jpg","nickname":"ELA","userId":"1c4a230c5a624d6f88e24e1e78bcdb35"},{"followers":3,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-10-15/6078c28e847a4f7d871a62d3ab445540_1539594709766.jpg","nickname":"","userId":"6078c28e847a4f7d871a62d3ab445540"},{"followers":3,"headImagePath":"http://39.107.254.232/firstga/imagesnull","nickname":null,"userId":"42b75ca285a64b279d91b45ef03539ba"}]
     */

    private String cursor;
    private List<MoreFollowListBean> moreFollowList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<MoreFollowListBean> getMoreFollowList() {
        return moreFollowList;
    }

    public void setMoreFollowList(List<MoreFollowListBean> moreFollowList) {
        this.moreFollowList = moreFollowList;
    }

    public static class MoreFollowListBean {
        /**
         * followers : 9
         * headImagePath : http://39.107.254.232/firstga/images/head/2018-10-16/f6b1f90fbef24225a3134027472dfc74_1539652214263.jpg
         * nickname : 567890
         * userId : f6b1f90fbef24225a3134027472dfc74
         */

        private int followers;
        private String headImagePath;
        private String nickname;
        private String userId;

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
