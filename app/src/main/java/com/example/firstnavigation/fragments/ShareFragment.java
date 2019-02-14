package com.example.firstnavigation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.fragment.SimpleFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends SimpleFragment {


    @BindView(R.id.iv_add_image)
    ImageView mIvAddImage;
    @BindView(R.id.linear_add)
    LinearLayout mLinearAdd;
    @BindView(R.id.rlv_image)
    RecyclerView mRlvImage;
    @BindView(R.id.linear_image)
    LinearLayout mLinearImage;
    @BindView(R.id.relative)
    RelativeLayout mRelative;
    Unbinder unbinder;

    public ShareFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_share;
    }

    @OnClick(R.id.iv_add_image)
    public void onViewClicked() {

    }
}
