package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class Hot {

    private List<SearchListBean> searchList;

    public List<SearchListBean> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<SearchListBean> searchList) {
        this.searchList = searchList;
    }

    public static class SearchListBean {
        /**
         * content : 无人机
         * searchId : 69c463f7e6904da389fb8adc13916b71
         */

        private String content;
        private String searchId;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSearchId() {
            return searchId;
        }

        public void setSearchId(String searchId) {
            this.searchId = searchId;
        }
    }
}
