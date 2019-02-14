package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class ListFollow {

    private List<FollowListBean> followList;

    public List<FollowListBean> getFollowList() {
        return followList;
    }

    public void setFollowList(List<FollowListBean> followList) {
        this.followList = followList;
    }

    public static class FollowListBean {
        /**
         * followId : b5674249b7cf456388048ff6d8ddfff0
         * followTime : 2019-02-05
         * followUid : e8bbadbd51c44a139c789fb1ef062b94
         * headImagePath : http://39.107.254.232/firstga/images/head/2019-02-08/e8bbadbd51c44a139c789fb1ef062b94_1549614873345.jpg
         * nickname : 白
         * personalProfile : 嗯呐呗
         */

        private String followId;
        private String followTime;
        private String followUid;
        private String headImagePath;
        private String nickname;
        private String personalProfile;

        public String getFollowId() {
            return followId;
        }

        public void setFollowId(String followId) {
            this.followId = followId;
        }

        public String getFollowTime() {
            return followTime;
        }

        public void setFollowTime(String followTime) {
            this.followTime = followTime;
        }

        public String getFollowUid() {
            return followUid;
        }

        public void setFollowUid(String followUid) {
            this.followUid = followUid;
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

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }
    }
}
