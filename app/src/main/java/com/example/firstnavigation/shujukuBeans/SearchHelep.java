package com.example.firstnavigation.shujukuBeans;

import com.example.firstnavigation.dao.DaoMaster;
import com.example.firstnavigation.dao.DaoSession;
import com.example.firstnavigation.dao.SearchDao;
import com.example.firstnavigation.global.App;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class SearchHelep {
    private static SearchHelep sSearchHelep;
    private SearchDao mSearchDao;

    public SearchHelep() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.getApp(), "hjghjk.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mSearchDao = daoSession.getSearchDao();
    }

    public static SearchHelep getSearchHelep() {
        if (sSearchHelep == null) {
            synchronized (SearchHelep.class) {
                if (sSearchHelep == null) {
                    sSearchHelep = new SearchHelep();
                }
            }
        }
        return sSearchHelep;
    }

    public void insert(Search search) {
        mSearchDao.insert(search);
    }

    public void delect(List<Search> search) {
        mSearchDao.deleteInTx(search);
    }

    public void updata(Search search) {
        mSearchDao.update(search);
    }

    public List<Search> selectAll() {
        return mSearchDao.queryBuilder().list();
    }

    public void delectAll(){
        mSearchDao.deleteAll();
    }

    public List<Search> selectPage(int page, int count) {
        return mSearchDao.queryBuilder().offset(page * count).limit(count).list();
    }

    public List<Search> selectS(String s) {
        return mSearchDao.queryBuilder().where(SearchDao.Properties.Title.eq(s)).list();
    }
}
