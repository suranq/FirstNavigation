package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/10.
 */

public class UserNews {

    /**
     * cursor : 1548768465
     * favouritNewsList : [{"favouritId":"474011eb0dbb4b8c94699f7ff8dd0dd1","newsId":"0a2d491e53ad420887a814896ab0ffca","title":"甘肃省公航旅与龙浩集团洽谈通用航空合作事宜"},{"favouritId":"eb2c8e2b87544f21a63e893a778eb8d0","newsId":"513746c77fa041e9b09d2e9642fe920f","title":"东阳横店通用机场通航首飞"},{"favouritId":"66fb2b17185e4f26872ea304c6bf8e8e","newsId":"d993ee3ac1e145069890bdd9d5886e8d","title":"无人机市场稳步上升，或将得到资本认可"},{"favouritId":"7e37fd2ea7dd42869b520d8e03e2ad56","newsId":"3acb400326754d27925903f71b0d0360","title":"富蕴机场\u201c富蕴-喀纳斯\u201d航线首航成功"},{"favouritId":"5328959f70f44378a269b9dede000079","newsId":"4593d24bdf2b4a799ad133a3744699a3","title":"观点｜中国通用航空产业政策质量绩效分析研究"},{"favouritId":"977f1488acc4487bacc336b5f9ca3b19","newsId":"0547641ccf2749259d2723ca3505926b","title":"2020年我国通用机场将超500个 部分地区将县县通机场"},{"favouritId":"9a01d20d8c73406ca98e7c1c1861412e","newsId":"03ca4730d3f349d1bee3a3b409f03bc8","title":"航空器国籍和适航证件系统5月7日起正式启用"},{"favouritId":"d4f828fe6d4a46d78dec23a68a455f47","newsId":"80edd8bb70d94133ac8cab321c1c7a35","title":"关于航空工业对外开放有关政策解读"},{"favouritId":"13dedc07775d4e7eb489129d8fc6779d","newsId":"dab954190091493e8efa00fe99972454","title":"歼-20总师：歼-20将系列化发展 实现弯道超车"},{"favouritId":"c3d1b9afbd5046ec92611e23390ab13c","newsId":"7f15941879184c648008493e84d68587","title":"《中国航空飞行发展高端论坛》 通航专家们邀你解析未来通航发展"}]
     */

    private String cursor;
    private List<FavouritNewsListBean> favouritNewsList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<FavouritNewsListBean> getFavouritNewsList() {
        return favouritNewsList;
    }

    public void setFavouritNewsList(List<FavouritNewsListBean> favouritNewsList) {
        this.favouritNewsList = favouritNewsList;
    }

    public static class FavouritNewsListBean {
        /**
         * favouritId : 474011eb0dbb4b8c94699f7ff8dd0dd1
         * newsId : 0a2d491e53ad420887a814896ab0ffca
         * title : 甘肃省公航旅与龙浩集团洽谈通用航空合作事宜
         */

        private String favouritId;
        private String newsId;
        private String title;

        public String getFavouritId() {
            return favouritId;
        }

        public void setFavouritId(String favouritId) {
            this.favouritId = favouritId;
        }

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
