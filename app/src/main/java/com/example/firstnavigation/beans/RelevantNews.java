package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class RelevantNews {

    /**
     * imageListThumb : ["null"]
     * layoutType : 0
     * newsId : 5b203a3d58ae47af857684beacfb68e1
     * origin :
     * pageviews : 0
     * publishTime : 2017-11-16
     * title : 乌兰县茶卡航空文化 体验中心项目开工建设
     */

    private String layoutType;
    private String newsId;
    private String origin;
    private int pageviews;
    private String publishTime;
    private String title;
    private List<String> imageListThumb;

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPageviews() {
        return pageviews;
    }

    public void setPageviews(int pageviews) {
        this.pageviews = pageviews;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImageListThumb() {
        return imageListThumb;
    }

    public void setImageListThumb(List<String> imageListThumb) {
        this.imageListThumb = imageListThumb;
    }
}
