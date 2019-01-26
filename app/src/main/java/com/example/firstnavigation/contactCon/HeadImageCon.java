package com.example.firstnavigation.contactCon;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.HeadImage;

import java.util.Map;

/**
 * Created by 马明祥 on 2019/1/20.
 */

public interface HeadImageCon {

    interface ListNewsConV extends BaseView {
        void showListNews(HeadImage headImage);
    }

    interface ListNewsConP{
        void getHeadImage(Map<String,Object> map);
    }

    interface ListNewsConM extends BaseModuleHttpFinish {
        void setShowListNews(HeadImage headImage);
    }

}
