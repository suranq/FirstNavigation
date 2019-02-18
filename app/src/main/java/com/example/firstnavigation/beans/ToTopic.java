package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/16.
 */

public class ToTopic {
    private String userId;
    private String title;
    private String tagList;
    private String shareLink;
    private List<String> fileList;

    public ToTopic(String userId, String title, String tagList, String shareLink, List<String> fileList) {
        this.userId = userId;
        this.title = title;
        this.tagList = tagList;
        this.shareLink = shareLink;
        this.fileList = fileList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagList() {
        return tagList;
    }

    public void setTagList(String tagList) {
        this.tagList = tagList;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }
}
