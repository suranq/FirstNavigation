package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/17.
 */

public class ListTopic {

    /**
     * cursor : 1550065478270c3a88f9fb045483f82b65beb1ad8b56b
     * favouritTopicList : [{"comments":1,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-17/efe7538b97f14d11952f5a13e1c7f7cd_1550406942592.jpg","http://39.107.254.232/firstga/images/topic/2019-02-17/efe7538b97f14d11952f5a13e1c7f7cd_1550406943456.jpg"],"likes":0,"pageviews":4,"publishTime":"2019-02-17","shareLink":null,"title":"我不知道该怎么说，真他妈饿！","topicId":"b4a2d97dfaa342cfbade0f164b3f0980"},{"comments":1,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-16/efe7538b97f14d11952f5a13e1c7f7cd_1550303668760.jpg","http://39.107.254.232/firstga/images/topic/2019-02-16/efe7538b97f14d11952f5a13e1c7f7cd_1550303669051.jpg","http://39.107.254.232/firstga/images/topic/2019-02-16/efe7538b97f14d11952f5a13e1c7f7cd_1550303669543.jpg"],"likes":1,"pageviews":8,"publishTime":"2019-02-16","shareLink":null,"title":"福利","topicId":"8df39c70f45948b28f331a1163075de7"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-16/efe7538b97f14d11952f5a13e1c7f7cd_1550302080457.png"],"likes":0,"pageviews":7,"publishTime":"2019-02-16","shareLink":null,"title":"1","topicId":"2107b88326b94b2cbfec28dc08e21c26"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-15/efe7538b97f14d11952f5a13e1c7f7cd_1550228349458.jpeg"],"likes":0,"pageviews":16,"publishTime":"2019-02-15","shareLink":null,"title":"1","topicId":"3bcbd0e93c5e4621823bad10f0098d26"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-15/efe7538b97f14d11952f5a13e1c7f7cd_1550226973519.jpeg","http://39.107.254.232/firstga/images/topic/2019-02-15/efe7538b97f14d11952f5a13e1c7f7cd_1550226973746.jpg","http://39.107.254.232/firstga/images/topic/2019-02-15/efe7538b97f14d11952f5a13e1c7f7cd_1550226974042.jpg"],"likes":1,"pageviews":8,"publishTime":"2019-02-15","shareLink":null,"title":"Cccc住","topicId":"8b7f0ca1f7b24cf0b310cdbd41a2f634"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":2,"publishTime":"2019-02-15","shareLink":"https://www.baidu.com/","title":"测试","topicId":"7f612eec305544ac80956efadab9448a"},{"comments":2,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-15/efe7538b97f14d11952f5a13e1c7f7cd_1550163960821.jpeg","http://39.107.254.232/firstga/images/topic/2019-02-15/efe7538b97f14d11952f5a13e1c7f7cd_1550163961127.jpg","http://39.107.254.232/firstga/images/topic/2019-02-15/efe7538b97f14d11952f5a13e1c7f7cd_1550163961538.png"],"likes":2,"pageviews":34,"publishTime":"2019-02-15","shareLink":null,"title":"花生","topicId":"40034f0a18cf4c768282cb319d688da0"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-14/efe7538b97f14d11952f5a13e1c7f7cd_1550127792860.jpg","http://39.107.254.232/firstga/images/topic/2019-02-14/efe7538b97f14d11952f5a13e1c7f7cd_1550127793055.jpg"],"likes":1,"pageviews":4,"publishTime":"2019-02-14","shareLink":null,"title":"花生","topicId":"e4ece7b4a7454173923fd3c73d670ee8"},{"comments":1,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-14/efe7538b97f14d11952f5a13e1c7f7cd_1550107825127.png","http://39.107.254.232/firstga/images/topic/2019-02-14/efe7538b97f14d11952f5a13e1c7f7cd_1550107827396.png","http://39.107.254.232/firstga/images/topic/2019-02-14/efe7538b97f14d11952f5a13e1c7f7cd_1550107829327.png"],"likes":0,"pageviews":24,"publishTime":"2019-02-14","shareLink":null,"title":"测试","topicId":"ad7d1a3b50a243ea8d85d6799e2b0ad1"},{"comments":0,"imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-02-13/efe7538b97f14d11952f5a13e1c7f7cd_1550065478138.jpg"],"likes":0,"pageviews":8,"publishTime":"2019-02-13","shareLink":null,"title":"我不配做你男朋友","topicId":"c3a88f9fb045483f82b65beb1ad8b56b"}]
     */

    private String cursor;
    private List<FavouritTopicListBean> favouritTopicList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<FavouritTopicListBean> getFavouritTopicList() {
        return favouritTopicList;
    }

    public void setFavouritTopicList(List<FavouritTopicListBean> favouritTopicList) {
        this.favouritTopicList = favouritTopicList;
    }

    public static class FavouritTopicListBean {
        /**
         * comments : 1
         * imageListThumb : ["http://39.107.254.232/firstga/images/topic/2019-02-17/efe7538b97f14d11952f5a13e1c7f7cd_1550406942592.jpg","http://39.107.254.232/firstga/images/topic/2019-02-17/efe7538b97f14d11952f5a13e1c7f7cd_1550406943456.jpg"]
         * likes : 0
         * pageviews : 4
         * publishTime : 2019-02-17
         * shareLink : null
         * title : 我不知道该怎么说，真他妈饿！
         * topicId : b4a2d97dfaa342cfbade0f164b3f0980
         */

        private int comments;
        private int likes;
        private int pageviews;
        private String publishTime;
        private Object shareLink;
        private String title;
        private String topicId;
        private List<String> imageListThumb;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
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

        public Object getShareLink() {
            return shareLink;
        }

        public void setShareLink(Object shareLink) {
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

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }
    }
}
