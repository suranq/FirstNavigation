package com.example.firstnavigation.beans;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class HomePage {

    /**
     * followers : 12
     * headImagePath : http://39.107.254.232/firstga/images/head/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550215507183.jpg
     * isFollowed : 1
     * nickname : 小北
     * personalProfile : 中国
     * topics : 263
     * userId : 049de01db14a4c8184faa0aca7facf8a
     */

    private int followers;
    private String headImagePath;
    private int isFollowed;
    private String nickname;
    private String personalProfile;
    private int topics;
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

    public int getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
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

    public int getTopics() {
        return topics;
    }

    public void setTopics(int topics) {
        this.topics = topics;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
