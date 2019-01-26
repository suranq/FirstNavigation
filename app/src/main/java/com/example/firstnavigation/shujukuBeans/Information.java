package com.example.firstnavigation.shujukuBeans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 马明祥 on 2019/1/23.
 */
@Entity
public class Information {
    @Id(autoincrement = true)
    private Long id;
    private String Title;
    private String ChannelId;
    private boolean isShow;
    @Generated(hash = 2044099124)
    public Information(Long id, String Title, String ChannelId, boolean isShow) {
        this.id = id;
        this.Title = Title;
        this.ChannelId = ChannelId;
        this.isShow = isShow;
    }
    @Generated(hash = 1933283371)
    public Information() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public String getChannelId() {
        return this.ChannelId;
    }
    public void setChannelId(String ChannelId) {
        this.ChannelId = ChannelId;
    }
    public boolean getIsShow() {
        return this.isShow;
    }
    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }

}
