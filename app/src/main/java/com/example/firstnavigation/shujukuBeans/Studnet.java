package com.example.firstnavigation.shujukuBeans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 马明祥 on 2019/1/20.
 */
@Entity
public class Studnet {
    @Id(autoincrement = true)
    private Long id;
    private String Phone;
    private String username;
    private String headimage;
    private boolean isStorage;
    @Generated(hash = 1490438126)
    public Studnet(Long id, String Phone, String username, String headimage,
            boolean isStorage) {
        this.id = id;
        this.Phone = Phone;
        this.username = username;
        this.headimage = headimage;
        this.isStorage = isStorage;
    }
    @Generated(hash = 1550203838)
    public Studnet() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPhone() {
        return this.Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getHeadimage() {
        return this.headimage;
    }
    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }
    public boolean getIsStorage() {
        return this.isStorage;
    }
    public void setIsStorage(boolean isStorage) {
        this.isStorage = isStorage;
    }

}
