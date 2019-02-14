package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class TagsSearch {

    /**
     * tagList : [{"id":"e49222bf3b0611e8b64c00163e30445d","tag":"通航展论"}]
     * cursor : 3
     */

    private String cursor;
    private List<TagListBean> tagList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<TagListBean> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagListBean> tagList) {
        this.tagList = tagList;
    }

    public static class TagListBean {
        /**
         * id : e49222bf3b0611e8b64c00163e30445d
         * tag : 通航展论
         */

        private String id;
        private String tag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
