package com.example.firstnavigation.contact;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public interface MoreFollowCon {
    interface MoreFollowV extends BaseView{
        void showTagsHot(TagsHot tagsHot);
        void showMoreFollow(MoreFollow moreFollow);
        void showTagsSearch(TagsSearch tagsSearch);
    }

    interface MoreFollowP{
        void getTagsHot(String json);
        void getMoreFollow(String json);
        void getTagsSearch(String json);
    }

    interface MoreFollowM extends BaseModuleHttpFinish{
        void setShowTagsHot(TagsHot tagsHot);
        void setShowMoreFollow(MoreFollow moreFollow);
        void setShowTagsSearch(TagsSearch tagsSearch);
    }
}
