package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class RelevantNews {

    /**
     * imageListThumb : ["http://www.ga.cn/uploads/allimg/180513/1_180513100600_1-lp.jpg"]
     * layoutType : 1
     * newsId : 659ac8cea0a94416894d6c90f371d2c6
     * origin :
     * pageviews : 17
     * publishTime : 2018-05-13
     * title : 2018年全球通用航空竞争情况分析 美国保持领先地位
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
