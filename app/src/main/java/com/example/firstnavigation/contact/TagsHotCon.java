package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;

/**
 * Created by 马明祥 on 2019/2/8.
 */

public interface TagsHotCon {

    interface TagsHotV extends BaseView{
        void showTagsHot(TagsHot tagsHot);
        void showTagsSearch(TagsSearch tagsSearch);
    }

    interface TagsHotP{
        void getTagsHot(String json);
        void getTagsSearch(String json);
    }

    interface TagsHotM extends BaseModuleHttpFinish{
        void setShowTagsHot(TagsHot tagsHot);
        void setShowTagsSearch(TagsSearch tagsSearch);
    }

}
