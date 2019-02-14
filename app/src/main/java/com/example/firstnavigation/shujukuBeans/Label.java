package com.example.firstnavigation.shujukuBeans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 马明祥 on 2019/2/12.
 */
@Entity
public class Label {
    @Id(autoincrement = true)
    private Long id;
    private String tag;
    private boolean isPitch;
    @Generated(hash = 1638899905)
    public Label(Long id, String tag, boolean isPitch) {
        this.id = id;
        this.tag = tag;
        this.isPitch = isPitch;
    }
    @Generated(hash = 2137109701)
    public Label() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTag() {
        return this.tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public boolean getIsPitch() {
        return this.isPitch;
    }
    public void setIsPitch(boolean isPitch) {
        this.isPitch = isPitch;
    }
    
}
