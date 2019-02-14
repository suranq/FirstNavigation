package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/22.
 */

public class RelevantNews {

    /**
     * code : 0
     * data : [{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201803/01/154400hirrbftxl51brj7m.jpg.thumb.jpg"],"layoutType":"2","newsId":"f7989933552d44bb8e39ab10c1d739e9","origin":"","pageviews":0,"publishTime":"2018-03-01","title":"冯正霖：通用航空发展的体制机制性障碍得到破除"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201711/30/143932psjss6tk9jru2ue9.jpg.thumb.jpg"],"layoutType":"2","newsId":"6f96f084cc0b4c02b5bccd45b6a9d870","origin":"","pageviews":1,"publishTime":"2017-11-22","title":"中国AOPA举行首次例行新闻发布会 回应社会关切行业问题"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201711/29/105926b8laz3l88aagrwf3.jpg.thumb.jpg"],"layoutType":"2","newsId":"354afcc4150e46d4b7ca04b47b8b5cd7","origin":"","pageviews":2,"publishTime":"2017-11-29","title":"民航招飞报考条件有哪些？"}]
     * message : 成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * imageListThumb : ["http://www.lyunx.com/data/attachment/portal/201803/01/154400hirrbftxl51brj7m.jpg.thumb.jpg"]
         * layoutType : 2
         * newsId : f7989933552d44bb8e39ab10c1d739e9
         * origin :
         * pageviews : 0
         * publishTime : 2018-03-01
         * title : 冯正霖：通用航空发展的体制机制性障碍得到破除
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
}
