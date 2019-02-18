package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class Question {

    /**
     * code : 0
     * data : [{"answer":"<p>用户可以针对任意一条新闻调整自己喜好的字体大小<\/p>\r\n<p>打开任意一条新闻，点击右上角\u2026 图标，在弹出框体中点选\u201c字体\u201d，然后按照自己喜好调整字体显示大小<\/p>","id":"49ecde9e8ff3462d84831e7025ea2661","question":"如何调整文章正文字体大小？"},{"answer":"<p>广告合作请发邮件至：firstga@firstga.cn <\/p>\r\n<p>商业合作请发邮件至：xingly@firstga.cn <\/p>\r\n<p>产品体验相关问题及建议请直接在「我的」-「用户反馈」处描述您遇到的问题即可<\/p>\r\n<p>工作人员会尽快与您沟通<\/p>","id":"4a109bd526a04e509a6973046ef4edff","question":"如何联系你们？"},{"answer":"<p>所有浏览过的记录都会存储在\u201c我的\u201d\u2014\u201c历史\u201d中<\/p>\r\n<p>方便用户随时点击回看<\/p>","id":"5e6bc8cb14da40598ea4fb0f0a8b0285","question":"如何翻找之前看过的文章？"},{"answer":"<p>打开任意一条新闻，可以看到在新闻上部\u201c收藏\u201d按钮，与下部\u201c星号图标\u201d按钮，两处都可以点击收藏。<\/p>\r\n<p>收藏成功后，可以通过\u201c我的\u201d\u2014\u201c收藏\u201d，在其中找到所有收藏内容<\/p>","id":"74e773c3043d4b19bd7bfd1d32b855fc","question":"如何收藏文章？"},{"answer":"<p>请将文章界面显示截屏一下，并配以具体状况描述（例如\u201c文章被抄袭\u201d、\u201c引用内容涉及侵权\u201d、\u201c内容涉及未被核实信息\u201d等）<\/p>\r\n<p>发到「我的」-「用户反馈」一栏，工作人员会尽快与您联系<\/p>","id":"9cdb6d9e6dfc4453a7d9fd19181d9136","question":"我的文章被抄袭了怎么办？"},{"answer":"<p>你好，请确认账号处于安全状态、账号内无任何资产和虚拟权益、无任何未处理完毕的纠纷等情况<\/p>\r\n<p>如确认以上情况后，仍需退出帐号，请在「我的」-「设置」点击页面底部栏「退出登录」按钮即可<\/p>","id":"a2bab606432a4428b7fab2b6ffb409b6","question":"我想退出登录帐号怎么办？"},{"answer":"<p>请先确认您所用设备的网络连接是否正常，如网络正常请在设置处清理缓存，然后关机重启试试<\/p>\r\n<p>如仍有问题，请将界面显示截屏一下，并配以具体状况描述（例如无法加载、加载失败、有声音没画面等），发到「我的」-「用户反馈」一栏，工作人员会尽快与您联系<\/p>","id":"a4ea387d0be94f30beeadee9baacee26","question":"图片、视频无法加载怎么办？"},{"answer":"<p>请您点击文章列表页中该文右下角的小叉号，并选择细分理由，系统会默认减少该类内容的推荐<\/p>\r\n<p>您可以在搜索栏搜索您感兴趣的话题或关键词，系统会默认记住您的阅读兴趣，给您推荐更多相关内容<\/p>","id":"be5f7f648fcf41b5adcd25fc877e5821","question":"如何屏蔽掉不感兴趣或者质量差的文章？"},{"answer":"<p>打开任意一条新闻，点击右上角\u2026 图标，在弹出框体中点选\u201c举报\u201d<\/p>\r\n<p>并在举报页面选择您的举报理由<\/p>\r\n<p>我们诚挚接受您的举报反馈<\/p>","id":"bf8ab96764274ef78e79a405a3ebc389","question":"对于个别文章中出现的错别字、不正当观点如何投诉举报？"}]
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
         * answer : <p>用户可以针对任意一条新闻调整自己喜好的字体大小</p>
         <p>打开任意一条新闻，点击右上角… 图标，在弹出框体中点选“字体”，然后按照自己喜好调整字体显示大小</p>
         * id : 49ecde9e8ff3462d84831e7025ea2661
         * question : 如何调整文章正文字体大小？
         */

        private String answer;
        private String id;
        private String question;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }
    }
}
