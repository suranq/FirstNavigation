package com.example.firstnavigation.base;

import java.lang.ref.WeakReference;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class BasePresenter<V> {

    private WeakReference<V> mVWeakReference;

    public V mView;

    //绑定视图
    public void attachView(V v){
        mVWeakReference = new WeakReference<V>(v);
        if (mVWeakReference != null){
            mView = mVWeakReference.get();
        }
    }

    //解绑视图
    public void destorView(){
        if (mVWeakReference != null){
            mVWeakReference.clear();
            mVWeakReference = null;
        }
    }
}
