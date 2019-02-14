package com.example.firstnavigation.base.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.base.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends SimpleActivity implements BaseView{

    public P mPresenter;
    private Unbinder mUnbinder;
    private PopupWindow mWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) LayoutInflater.from(this).inflate(createLayoutId(), null);
        setContentView(view);
        mUnbinder = ButterKnife.bind(this, view);

        mPresenter = createPresenter();
        if (mPresenter != null){
            mPresenter.attachView((V) this);
        }
        showWindow();

        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();


    private void showWindow() {
        //三要素 布局,宽 ,高
        View inflate = LayoutInflater.from(this).inflate(R.layout.loading, null, false);
        mWindow = new PopupWindow(inflate);
        mWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void showProgressbar() {
        getActivityID().setBackgroundColor(0xC4BDB6B6);
        getActivityID().post(new Runnable() {
            @Override
            public void run() {
                mWindow.showAtLocation(getActivityID(),Gravity.CENTER,0,0);
            }
        });
    }

    protected abstract View getActivityID();

    @Override
    public void hideProgressbar() {
        getActivityID().setBackgroundColor(0xFFFFFFFF);
        mWindow.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.destorView();
            mPresenter = null;
        }
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
