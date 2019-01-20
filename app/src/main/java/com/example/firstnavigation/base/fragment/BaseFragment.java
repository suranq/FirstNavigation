package com.example.firstnavigation.base.fragment;

import android.view.View;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.BasePresenter;
import com.example.firstnavigation.base.BaseView;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends SimpleFragment implements BaseView {

    public P mPresenter;

    @Override
    public void viewCreate(View view) {
        super.viewCreate(view);
        if (mPresenter == null) {
            mPresenter = createPresenter();
            if (mPresenter != null) {
                mPresenter.attachView((V) this);
            }
        }
    }

    protected abstract P createPresenter();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            if (mPresenter != null) {
                load();
            }
        }
    }

    private void load() {
        if (mPresenter != null){
            mPresenter = createPresenter();
        }
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

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
