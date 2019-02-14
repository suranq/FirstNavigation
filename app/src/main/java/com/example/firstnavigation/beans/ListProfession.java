package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class ListProfession {

    private List<ProfessionListBean> professionList;

    public List<ProfessionListBean> getProfessionList() {
        return professionList;
    }

    public void setProfessionList(List<ProfessionListBean> professionList) {
        this.professionList = professionList;
    }

    public static class ProfessionListBean {
        /**
         * professionId : 219323963b0411e8b64c00163e30445d
         * professionName : 人力资源
         */

        private String professionId;
        private String professionName;

        public String getProfessionId() {
            return professionId;
        }

        public void setProfessionId(String professionId) {
            this.professionId = professionId;
        }

        public String getProfessionName() {
            return professionName;
        }

        public void setProfessionName(String professionName) {
            this.professionName = professionName;
        }
    }
}
