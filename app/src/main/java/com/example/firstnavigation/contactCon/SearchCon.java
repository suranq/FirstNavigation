package com.example.firstnavigation.contactCon;

import com.example.firstnavigation.base.BaseModuleHttpFinish;
import com.example.firstnavigation.base.BaseView;
import com.example.firstnavigation.beans.SearchBean;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public interface SearchCon {

    interface SearchConV extends BaseView{
        void showSearch(SearchBean searchBean);
    }

    interface SearchConP{
        void getSearch(String json);
    }

    interface SearchConM extends BaseModuleHttpFinish{
        void setShowSearch(SearchBean searchBean);
    }

}
