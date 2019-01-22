package com.example.firstnavigation.shujukuBeans;

import com.example.firstnavigation.dao.DaoMaster;
import com.example.firstnavigation.dao.DaoSession;
import com.example.firstnavigation.dao.StudnetDao;
import com.example.firstnavigation.global.App;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/20.
 */

public class DataBaseHelep {
    private static DataBaseHelep mDataBeasHelep;
        private StudnetDao mStudentDao;

        public DataBaseHelep() {
            DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.getApp(), "xcvfr.db");
            DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
            DaoSession daoSession = daoMaster.newSession();
            mStudentDao = daoSession.getStudnetDao();
        }

        public static DataBaseHelep getInsh() {
            if (mDataBeasHelep == null) {
                synchronized (DataBaseHelep.class) {
                    if (mDataBeasHelep == null) {
                        mDataBeasHelep = new DataBaseHelep();
                    }
                }
            }
            return mDataBeasHelep;
        }

        public void insert(Studnet student){
            mStudentDao.insert(student);
        }

        public void delect(Studnet student){
            mStudentDao.delete(student);
        }

        public void updata(Studnet student){
            mStudentDao.update(student);
        }

        public List<Studnet> selectAll(){
            return mStudentDao.queryBuilder().list();
        }

        public List<Studnet>selectPage(int page,int count){
            return mStudentDao.queryBuilder().offset(page * count).limit(count).list();
        }

        public List<Studnet>selectS(String s){
            return mStudentDao.queryBuilder().where(StudnetDao.Properties.Phone.eq(s)).list();
        }
}
