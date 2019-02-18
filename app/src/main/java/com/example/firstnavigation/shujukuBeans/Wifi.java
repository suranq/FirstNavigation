package com.example.firstnavigation.shujukuBeans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 马明祥 on 2019/2/16.
 */
@Entity
public class Wifi {
    @Id(autoincrement = true)
    private Long id;
    private boolean isOpen;
    private boolean isWifi;
    @Generated(hash = 1567960335)
    public Wifi(Long id, boolean isOpen, boolean isWifi) {
        this.id = id;
        this.isOpen = isOpen;
        this.isWifi = isWifi;
    }
    @Generated(hash = 229508075)
    public Wifi() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getIsOpen() {
        return this.isOpen;
    }
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    public boolean getIsWifi() {
        return this.isWifi;
    }
    public void setIsWifi(boolean isWifi) {
        this.isWifi = isWifi;
    }
}
