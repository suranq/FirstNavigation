package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/6.
 */

public class ListComment {

    /**
     * commentList : [{"commentTime":"2019-02-03 15:54:49","content":"啦啦啦啦啦啦啦","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-06/c383f4c9026d471da0184ad5b24c0365_1549425908181.png","nickname":"user24588100","userId":"c383f4c9026d471da0184ad5b24c0365"},{"commentTime":"2019-02-03 15:54:18","content":"啦啦啦啦啦","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-06/c383f4c9026d471da0184ad5b24c0365_1549425908181.png","nickname":"user24588100","userId":"c383f4c9026d471da0184ad5b24c0365"},{"commentTime":"2019-02-03 15:53:41","content":"基里连科","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-06/c383f4c9026d471da0184ad5b24c0365_1549425908181.png","nickname":"user24588100","userId":"c383f4c9026d471da0184ad5b24c0365"},{"commentTime":"2019-02-03 15:52:51","content":"吼吼吼吼","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-06/c383f4c9026d471da0184ad5b24c0365_1549425908181.png","nickname":"user24588100","userId":"c383f4c9026d471da0184ad5b24c0365"},{"commentTime":"2019-01-30 23:34:19","content":"124","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-06/c383f4c9026d471da0184ad5b24c0365_1549425908181.png","nickname":"user24588100","userId":"c383f4c9026d471da0184ad5b24c0365"},{"commentTime":"2019-01-30 22:02:29","content":"国库","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-03/e7d9914be4214263ad8e2a3e88e72263_1549180717956.jpg","nickname":"九亿少女的梦","userId":"e7d9914be4214263ad8e2a3e88e72263"},{"commentTime":"2019-01-18 14:52:53","content":"的","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-04/049de01db14a4c8184faa0aca7facf8a_1549285993745.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2019-01-18 14:49:24","content":"阿瑟东","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-04/049de01db14a4c8184faa0aca7facf8a_1549285993745.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2019-01-12 09:36:14","content":"111","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-04/049de01db14a4c8184faa0aca7facf8a_1549285993745.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2019-01-09 11:12:57","content":"微软为二五","headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-04/049de01db14a4c8184faa0aca7facf8a_1549285993745.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"}]
     * cursor : 2
     */

    private String cursor;
    private List<CommentListBean> commentList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        this.commentList = commentList;
    }

    public static class CommentListBean {
        /**
         * commentTime : 2019-02-03 15:54:49
         * content : 啦啦啦啦啦啦啦
         * headImagePath : http://39.107.254.232/firstga/images/head/2019-02-06/c383f4c9026d471da0184ad5b24c0365_1549425908181.png
         * nickname : user24588100
         * userId : c383f4c9026d471da0184ad5b24c0365
         */

        private String commentTime;
        private String content;
        private String headImagePath;
        private String nickname;
        private String userId;

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
