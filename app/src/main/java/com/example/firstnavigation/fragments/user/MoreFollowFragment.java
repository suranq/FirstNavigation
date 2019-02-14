package com.example.firstnavigation.fragments.user;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.MyMoreAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.contact.MoreCon;
import com.example.firstnavigation.json.JsonMore;
import com.example.firstnavigation.presenter.MorePresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFollowFragment extends BaseFragment<MoreCon.MoreFollowV, MorePresenter<MoreCon.MoreFollowV>> implements MoreCon.MoreFollowV {


    @BindView(R.id.rlv_attention)
    RecyclerView mRlvAttention;
    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    Unbinder unbinder;
    private String mId;
    private JsonMore mJsonMore;
    private MyMoreAdapter mMyMoreAdapter;
    private List<MoreFollow.MoreFollowListBean> mData = new ArrayList<>();

    public MoreFollowFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public MoreFollowFragment(String id) {
        mId = id;
    }

    @Override
    public void load() {
        mJsonMore = new JsonMore();
        mJsonMore.setCursor("0");
        mJsonMore.setTagId(mId);
        mJsonMore.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mPresenter.getMoreFollow(new Gson().toJson(mJsonMore));

    }

    @Override
    protected void initData() {

        mRlvAttention.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRlvAttention.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        mMyMoreAdapter = new MyMoreAdapter(mData,getContext());
        mRlvAttention.setAdapter(mMyMoreAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_more_follow;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showMoreFollow(MoreFollow moreFollow) {
        mMyMoreAdapter.setData(moreFollow.getMoreFollowList());
    }

    @Override
    protected MorePresenter<MoreCon.MoreFollowV> createPresenter() {
        return new MorePresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mFrameLayout;
    }

}
