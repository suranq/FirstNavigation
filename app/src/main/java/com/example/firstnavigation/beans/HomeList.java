package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class HomeList {

    /**
     * cursor : 1550214818803bb8b27dd75604bfd9e96b591f1acb6e9
     * topicList : [{"comments":0,"imageListThumb":null,"likes":1,"pageviews":8,"publishTime":"2019-02-15","shareLink":"https://www.baidu.com/","title":"哈哈","topicId":"315e6533933840f49cfc721d0e9efdfa"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550219118199.png"],"likes":0,"pageviews":7,"publishTime":"2019-02-15","shareLink":"https://home.firefoxchina.cn/?from=extra_start","title":"测试","topicId":"1ebfc2452c5848ff8877d8984887bd35"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550218823842.png","http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550218824186.jpg","http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550218824478.jpg"],"likes":0,"pageviews":7,"publishTime":"2019-02-15","shareLink":"https://home.firefoxchina.cn/?from=extra_start","title":"emmmmm","topicId":"cc88786012f44ec88a0c53786a19125a"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":2,"publishTime":"2019-02-15","shareLink":"https://home.firefoxchina.cn/?from=extra_start","title":"二营长你意大利炮呢","topicId":"fa09b16668d34fed8b41fe24bf1ab52a"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550217949484.png","http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550217949841.jpg","http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550217950137.jpg"],"likes":0,"pageviews":3,"publishTime":"2019-02-15","shareLink":null,"title":"测试","topicId":"3101e9855510433bb549945d896a9cc3"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":2,"publishTime":"2019-02-15","shareLink":"https://home.firefoxchina.cn/?from=extra_start","title":"\"发布话题\"","topicId":"4e802f4c01a34559aeb1c0036406e5b3"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":3,"publishTime":"2019-02-15","shareLink":"https://home.firefoxchina.cn/?from=extra_start","title":"\"发布话题\"","topicId":"280ba35b89f14b4580874c0ed1bce219"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":0,"publishTime":"2019-02-15","shareLink":"https://home.firefoxchina.cn/?from=extra_start","title":"\"发布话题\"","topicId":"0c3dc67caac74fe7ac93fbfc15d8401b"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550216392761.jpg","http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550216392988.jpg","http://39.107.254.232/firstga/images/topic/2019-02-15/049de01db14a4c8184faa0aca7facf8a_1550216393195.jpg"],"likes":0,"pageviews":7,"publishTime":"2019-02-15","shareLink":"http://www.baidu.com","title":"紧急集合哈哈哈","topicId":"82696bd2efac41b2902ade075ac3f42b"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":2,"publishTime":"2019-02-15","shareLink":"https://home.firefoxchina.cn/?from=extra_start","title":"\"发布话题\"","topicId":"bb8b27dd75604bfd9e96b591f1acb6e9"}]
     */

    private String cursor;
    private List<TopicListBean> topicList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<TopicListBean> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<TopicListBean> topicList) {
        this.topicList = topicList;
    }

    public static class TopicListBean {
        /**
         * comments : 0
         * imageListThumb : null
         * likes : 1
         * pageviews : 8
         * publishTime : 2019-02-15
         * shareLink : https://www.baidu.com/
         * title : 哈哈
         * topicId : 315e6533933840f49cfc721d0e9efdfa
         */

        private int comments;
        private List<String> imageListThumb;
        private int likes;
        private int pageviews;
        private String publishTime;
        private String shareLink;
        private String title;
        private String topicId;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
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

        public String getShareLink() {
            return shareLink;
        }

        public void setShareLink(String shareLink) {
            this.shareLink = shareLink;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }
    }
}
