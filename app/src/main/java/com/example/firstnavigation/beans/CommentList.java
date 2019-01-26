package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/23.
 */

public class CommentList {


    /**
     * commentList : [{"commentTime":"2019-01-18 19:09:30","content":"测试","headImagePath":"http://39.107.254.232/firstga/imagesnull","nickname":null,"userId":"d56ea66e7ee741f498ca51242c8c6394"},{"commentTime":"2019-01-16 19:13:46","content":"123135","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/efe7538b97f14d11952f5a13e1c7f7cd_1548233212923.jpg","nickname":"user104592973","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"commentTime":"2019-01-16 19:13:45","content":"123135","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/efe7538b97f14d11952f5a13e1c7f7cd_1548233212923.jpg","nickname":"user104592973","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"commentTime":"2019-01-16 19:13:42","content":"123135","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/efe7538b97f14d11952f5a13e1c7f7cd_1548233212923.jpg","nickname":"user104592973","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"commentTime":"2019-01-15 11:01:52","content":"123135","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/efe7538b97f14d11952f5a13e1c7f7cd_1548233212923.jpg","nickname":"user104592973","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"commentTime":"2019-01-15 10:48:58","content":"123135","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/efe7538b97f14d11952f5a13e1c7f7cd_1548233212923.jpg","nickname":"user104592973","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"commentTime":"2019-01-15 10:48:33","content":"123135","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/efe7538b97f14d11952f5a13e1c7f7cd_1548233212923.jpg","nickname":"user104592973","userId":"efe7538b97f14d11952f5a13e1c7f7cd"},{"commentTime":"2019-01-14 23:05:58","content":"测试","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/049de01db14a4c8184faa0aca7facf8a_1548228508511.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2019-01-14 23:05:43","content":"测试","headImagePath":"http://39.107.254.232/firstga/imagesnull","nickname":null,"userId":"d56ea66e7ee741f498ca51242c8c6394"},{"commentTime":"2019-01-14 16:37:25","content":"123135","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-23/efe7538b97f14d11952f5a13e1c7f7cd_1548233212923.jpg","nickname":"user104592973","userId":"efe7538b97f14d11952f5a13e1c7f7cd"}]
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
         * commentTime : 2019-01-18 19:09:30
         * content : 测试
         * headImagePath : http://39.107.254.232/firstga/imagesnull
         * nickname : null
         * userId : d56ea66e7ee741f498ca51242c8c6394
         */

        private String commentTime;
        private String content;
        private String headImagePath;
        private Object nickname;
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

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
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
