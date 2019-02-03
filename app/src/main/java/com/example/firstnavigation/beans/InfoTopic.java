package com.example.firstnavigation.beans;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/29.
 */

public class InfoTopic {


    /**
     * comments : 21
     * headImagePath : http://39.107.254.232/firstga/images/head/2018-05-21/cb2fa1f12fe644f88a6aff44fc0243c3_1526894227477.jpg
     * imageListThumb : ["http://39.107.254.232/firstga/images/topic/2018-05-29/cb2fa1f12fe644f88a6aff44fc0243c3_1527578823779.jpg","http://39.107.254.232/firstga/images/topic/2018-05-29/cb2fa1f12fe644f88a6aff44fc0243c3_1527578824212.jpg"]
     * isFavoured : 0
     * isFollowed : 0
     * isLiked : 0
     * likes : 8
     * nickname : 虎皮猫大人
     * publishTime : 2018-05-29
     * shareLink :
     * title : 【第八届中国（北京）国际机场技术设备服务展预登记已正式启动】迈布克斯（上海）会议展览有限公司主办的inter airport China 第八届中国（北京）国际机场技术、设备、设计和服务展览会即将于2018年9月5至7日在北京中国国际展览中心举办。本届展会将汇聚超过200家参展企业和品牌，通过室内和室外展馆，为来自机场、航空公司、民航所属的企事业单位、科研院所和高等院校的专业观众，展示机场特种车辆、跑道维护、助航灯光等空港设备；行李处理、值机柜台、机场座椅等航站楼设施；数据处理和机场设计四个方面的专业技术、设备和服务。
     可通过以下多种方式进行报名：
     1、在线报名
     登陆 www.interairportchina.com 进行预登记报名
     2、微信报名
     关注微信公众号interairport回复“我要参观”或扫描二维码进入微信报名通道
     3、电话报名
     拨打电话021-52049711进行报名
     4、团体报名
     如有10人或以上人数来参观，可致电021-52049711办理团体预登记
     * topicId : 9d444b8100f048faaa83a4f8dfab454b
     * userId : cb2fa1f12fe644f88a6aff44fc0243c3
     */

    private int comments;
    private String headImagePath;
    private int isFavoured;
    private int isFollowed;
    private int isLiked;
    private int likes;
    private String nickname;
    private String publishTime;
    private String shareLink;
    private String title;
    private String topicId;
    private String userId;
    private List<String> imageListThumb;

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public int getIsFavoured() {
        return isFavoured;
    }

    public void setIsFavoured(int isFavoured) {
        this.isFavoured = isFavoured;
    }

    public int getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getImageListThumb() {
        return imageListThumb;
    }

    public void setImageListThumb(List<String> imageListThumb) {
        this.imageListThumb = imageListThumb;
    }
}
