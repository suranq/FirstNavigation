package com.example.firstnavigation.base.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.base.BaseView;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends SimpleFragment implements BaseView {

    public P mPresenter;
    private PopupWindow mWindow;

    @Override
    public void viewCreate(View view) {
        super.viewCreate(view);
        if (mPresenter == null) {
            mPresenter = createPresenter();
            if (mPresenter != null) {
                mPresenter.attachView((V) this);
            }
        }
        showWindow();
    }

    protected abstract P createPresenter();

    private void showWindow() {
        //三要素 布局,宽 ,高
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.loading, null, false);
        mWindow = new PopupWindow(inflate);
        mWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("lllljjj",isVisibleToUser+"");
        if (isVisibleToUser) {
            if (mPresenter != null) {
                load();
            }
        }
    }

    public void load() {

    }

    @Override
    public void showProgressbar() {
        getActivityID().setBackgroundColor(0xC4BDB6B6);
        getActivityID().post(new Runnable() {
            @Override
            public void run() {
                mWindow.showAtLocation(getActivityID(), Gravity.CENTER,0,0);
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
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null){
            mPresenter.destorView();
            mPresenter = null;
        }
    }
}
