package com.example.firstnavigation.shujukuBeans;

import com.example.firstnavigation.dao.DaoMaster;
import com.example.firstnavigation.dao.DaoSession;
import com.example.firstnavigation.dao.LabelDao;
import com.example.firstnavigation.global.App;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class LabelHelep {
    private static LabelHelep sLabelHelep;
    private LabelDao mLabelDao;

    public LabelHelep() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.getApp(), "dfgh.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mLabelDao = daoSession.getLabelDao();
    }

    public static LabelHelep getInsh() {
        if (sLabelHelep == null) {
            synchronized (LabelHelep.class) {
                if (sLabelHelep == null) {
                    sLabelHelep = new LabelHelep();
                }
            }
        }
        return sLabelHelep;
    }

    public void insert(Label label) {
        mLabelDao.insert(label);
    }

    public void delect(Label label) {
        mLabelDao.delete(label);
    }

    public void updata(Label label) {
        mLabelDao.update(label);
    }

    public List<Label> selectAll() {
        return mLabelDao.queryBuilder().list();
    }

    public List<Label> selectPage(int page, int count) {
        return mLabelDao.queryBuilder().offset(page * count).limit(count).list();
    }

    public List<Label> selectS(String s) {
        return mLabelDao.queryBuilder().where(LabelDao.Properties.Tag.eq(s)).list();
    }
}
