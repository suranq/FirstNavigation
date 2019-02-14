package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.contact.TagsHotCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/8.
 */

public class TagsHotModlue {

    public void getTagsHot(String json, final TagsHotCon.TagsHotM tagsHotM){
        tagsHotM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getTagsHot("tags/hot",HttpUtils.getBody(json)).compose(RxUtils.<TagsHot>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<TagsHot>(tagsHotM) {
                    @Override
                    public void onNext(TagsHot tagsHot) {
                        tagsHotM.setShowTagsHot(tagsHot);
                    }
                });
    }

    public void getTagsSearch(String json, final TagsHotCon.TagsHotM tagsHotM){
        tagsHotM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getTagsSearch("tags/search",HttpUtils.getBody(json)).compose(RxUtils.<BaseData<TagsSearch>>rxObserableSchedulerHelper())
                .compose(RxUtils.<TagsSearch>handleResule())
                .subscribe(new BaseObserver<TagsSearch>(tagsHotM) {
                    @Override
                    public void onNext(TagsSearch tagsSearch) {
                        tagsHotM.setShowTagsSearch(tagsSearch);
                    }
                });
    }

}
