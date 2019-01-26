package com.example.firstnavigation.shujukuBeans;

import com.example.firstnavigation.dao.DaoMaster;
import com.example.firstnavigation.dao.DaoSession;
import com.example.firstnavigation.dao.InformationDao;
import com.example.firstnavigation.global.App;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/23.
 */

public class InformationHelep {
    private static InformationHelep sInformationHelep;
    private InformationDao mInformationDao;

    public InformationHelep() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.getApp(), "dfg.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mInformationDao = daoSession.getInformationDao();
    }

    public static InformationHelep getInsh() {
        if (sInformationHelep == null) {
            synchronized (InformationHelep.class) {
                if (sInformationHelep == null) {
                    sInformationHelep = new InformationHelep();
                }
            }
        }
        return sInformationHelep;
    }

    public void insert(List<Information> information) {
        mInformationDao.insertInTx(information);
    }

    public void delect(Information information) {
        mInformationDao.delete(information);
    }

    public void updata(Information information) {
        mInformationDao.update(information);
    }

    public List<Information> selectAll() {
        return mInformationDao.queryBuilder().list();
    }

    public List<Information> selectPage(int page, int count) {
        return mInformationDao.queryBuilder().offset(page * count).limit(count).list();
    }

    public List<Information> selectS(String s) {
        return mInformationDao.queryBuilder().where(InformationDao.Properties.Title.eq(s)).list();
    }
}
