package com.example.firstnavigation.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public abstract class SimpleFragment extends Fragment{

    public Context mContext;
    public Activity mActivity;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
        mContext = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        initData();
    }

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(createLayoutId(), null);
        viewCreate(inflate);
        return inflate;

    }

    public void viewCreate(View view) {

    }

    protected abstract int createLayoutId();

    @Override
    public void onDetach() {
        super.onDetach();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
