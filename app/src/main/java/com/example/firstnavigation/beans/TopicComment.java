package com.example.firstnavigation.beans;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class TopicComment {
    private String code;
    private String message;
    private String data;

    public TopicComment(String code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
