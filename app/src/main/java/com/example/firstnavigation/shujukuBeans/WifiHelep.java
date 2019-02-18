package com.example.firstnavigation.shujukuBeans;

import com.example.firstnavigation.dao.DaoMaster;
import com.example.firstnavigation.dao.DaoSession;
import com.example.firstnavigation.dao.WifiDao;
import com.example.firstnavigation.global.App;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/16.
 */

public class WifiHelep {

    private static WifiHelep sWifiHelep;
    private WifiDao mWifiDao;

    public WifiHelep() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.getApp(), "xcvbz.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mWifiDao = daoSession.getWifiDao();
    }

    public static WifiHelep getInsh() {
        if (sWifiHelep == null) {
            synchronized (WifiHelep.class) {
                if (sWifiHelep == null) {
                    sWifiHelep = new WifiHelep();
                }
            }
        }
        return sWifiHelep;
    }

    public void insert(Wifi wifi) {
        mWifiDao.insert(wifi);
    }

    public void delect(Wifi wifi) {
        mWifiDao.delete(wifi);
    }

    public void updata(Wifi wifi) {
        mWifiDao.update(wifi);
    }

    public List<Wifi> selectAll() {
        return mWifiDao.queryBuilder().list();
    }

    public List<Wifi> selectPage(int page, int count) {
        return mWifiDao.queryBuilder().offset(page * count).limit(count).list();
    }

    public List<Wifi> selectS(String s) {
        return mWifiDao.queryBuilder().where(WifiDao.Properties.IsWifi.eq(s)).list();
    }

}
