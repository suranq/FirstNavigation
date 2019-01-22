package com.example.firstnavigation.json;

/**
 * Created by 马明祥 on 2019/1/21.
 */

public class JsonDwonList {

    private String userId;
    private String channelId;
    private String cursor;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
