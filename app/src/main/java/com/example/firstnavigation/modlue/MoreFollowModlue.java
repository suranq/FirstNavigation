package com.example.firstnavigation.modlue;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.base.BaseObserver;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.contact.MoreFollowCon;
import com.example.firstnavigation.contact.TagsHotCon;
import com.example.firstnavigation.https.HttpManager;
import com.example.firstnavigation.utils.HttpUtils;
import com.example.firstnavigation.utils.RxUtils;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MoreFollowModlue {

    public void getTagsHot(String json, final MoreFollowCon.MoreFollowM moreFollowM) {
        moreFollowM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getTagsHot("tags/hot", HttpUtils.getBody(json)).compose(RxUtils.<TagsHot>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<TagsHot>(moreFollowM) {
                    @Override
                    public void onNext(TagsHot tagsHot) {
                        moreFollowM.setShowTagsHot(tagsHot);
                    }
                });
    }

    public void getMoreFollow(String json, final MoreFollowCon.MoreFollowM moreFollowM) {
        moreFollowM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getMoreFollow("users/moreFollow", HttpUtils.getBody(json)).compose(RxUtils.<BaseData<MoreFollow>>rxObserableSchedulerHelper())
                .compose(RxUtils.<MoreFollow>handleResule())
                .subscribe(new BaseObserver<MoreFollow>(moreFollowM) {
                    @Override
                    public void onNext(MoreFollow moreFollow) {
                        moreFollowM.setShowMoreFollow(moreFollow);
                    }
                });
    }

    public void getTagsSearch(String json, final MoreFollowCon.MoreFollowM moreFollowM){
        moreFollowM.setShowProgressbar();
        HttpManager.getHttpManager().getServer().getTagsSearch("tags/search",HttpUtils.getBody(json)).compose(RxUtils.<BaseData<TagsSearch>>rxObserableSchedulerHelper())
                .compose(RxUtils.<TagsSearch>handleResule())
                .subscribe(new BaseObserver<TagsSearch>(moreFollowM) {
                    @Override
                    public void onNext(TagsSearch tagsSearch) {
                        moreFollowM.setShowTagsSearch(tagsSearch);
                    }
                });
    }

}
