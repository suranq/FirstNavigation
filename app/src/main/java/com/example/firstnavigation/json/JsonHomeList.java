package com.example.firstnavigation.json;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class JsonHomeList {

    /**
     * userId : efe7538b97f14d11952f5a13e1c7f7cd
     * lookUserId : 049de01db14a4c8184faa0aca7facf8a
     * cursor : 0
     */

    private String userId;
    private String lookUserId;
    private String cursor;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLookUserId() {
        return lookUserId;
    }

    public void setLookUserId(String lookUserId) {
        this.lookUserId = lookUserId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
