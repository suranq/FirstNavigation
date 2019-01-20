package com.example.firstnavigation.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder mUnbinder;
    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(createLayoutId(), null);
        setContentView(viewGroup);
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        onViewCreated(viewGroup);
        initData();
    }

    public void onViewCreated(View view) {

    }

    //逻辑代码
    protected abstract void initData();

    //加载布局
    protected abstract int createLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
