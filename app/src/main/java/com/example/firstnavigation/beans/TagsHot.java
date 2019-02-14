package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/8.
 */

public class TagsHot {

    /**
     * code : 0
     * data : [{"id":"74a1046a65cb42339e10a7a869c75c1f","tag":"1"},{"id":"7c8a64b28b9c42df881a48992652110f","tag":"2"},{"id":"48ee8a62c61949e7a77c76d351cd74bc","tag":"话题"},{"id":"e4ac82883b0611e8b64c00163e30445","tag":"无人机"},{"id":"42ba5d55ace44aa38c222c0a6f16d843","tag":"\"1\""},{"id":"25ef0a3fccd3442caca10737031f0f2e","tag":"创新"},{"id":"ca2ebcff5cce4535a58533d0ce618b61","tag":"\"2\""},{"id":"bdf8c5dfcac34703a55ebff72ed48506","tag":"会展"},{"id":"07c5679841084845b07d9a2f64b290d8","tag":"无人机，直升机"},{"id":"e4aead963b0611e8b64c00163e30445d","tag":"直升机"},{"id":"57ba3d8a6cb84654a7390c408169bbbc","tag":"制造"},{"id":"63a4a5753fcd4d7ea68d28e8a41a0908","tag":"科普"},{"id":"4d193019f3f04af49be3b66c571001dd","tag":"\u201c1\u201d"},{"id":"b8c8ba598cc04787805badfc8b961108","tag":"通航机场"},{"id":"e4932a873b0611e8b64c00163e30445d","tag":"救援"},{"id":"995fb2f572ae40718a9d819587144d0d","tag":"[无人机]"},{"id":"e490d2343b0611e8b64c00163e30445d","tag":"政策"},{"id":"e4953f6d3b0611e8b64c00163e30445d","tag":"飞行员"},{"id":"77b4b3eb591d491db33c7043364b9313","tag":"6"},{"id":"e4ad7c9d3b0611e8b64c00163e30445d","tag":"公务机"}]
     * message : 成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 74a1046a65cb42339e10a7a869c75c1f
         * tag : 1
         */

        private String id;
        private String tag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
