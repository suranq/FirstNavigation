package com.example.firstnavigation.shujukuBeans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 马明祥 on 2019/1/24.
 */
@Entity
public class Search {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    @Generated(hash = 851395109)
    public Search(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @Generated(hash = 1644193961)
    public Search() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
}
