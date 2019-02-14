package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.MyMoreAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.contact.MoreCon;
import com.example.firstnavigation.json.JsonMore;
import com.example.firstnavigation.presenter.MorePresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreAttenActivity extends BaseActivity<MoreCon.MoreFollowV, MorePresenter<MoreCon.MoreFollowV>> implements MoreCon.MoreFollowV {

    @BindView(R.id.rlv_attention)
    RecyclerView mRlvAttention;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private MyMoreAdapter mMyMoreAdapter;
    private List<MoreFollow.MoreFollowListBean> mData = new ArrayList<>();

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String tag = intent.getStringExtra("tag");

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mTvTitle.setText(tag);

        JsonMore jsonMore = new JsonMore();
        jsonMore.setCursor("0");
        jsonMore.setTagId(id);
        jsonMore.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mPresenter.getMoreFollow(new Gson().toJson(jsonMore));

        mRlvAttention.setLayoutManager(new LinearLayoutManager(MoreAttenActivity.this, LinearLayoutManager.VERTICAL, false));
        mRlvAttention.addItemDecoration(new DividerItemDecoration(MoreAttenActivity.this, DividerItemDecoration.VERTICAL));

        mMyMoreAdapter = new MyMoreAdapter(mData, MoreAttenActivity.this);
        mRlvAttention.setAdapter(mMyMoreAdapter);

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_more_atten;
    }

    @Override
    protected MorePresenter<MoreCon.MoreFollowV> createPresenter() {
        return new MorePresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showMoreFollow(MoreFollow moreFollow) {
        mMyMoreAdapter.setData(moreFollow.getMoreFollowList());
    }

    @OnClick(R.id.iv_fan)
    public void onViewClicked() {
        finish();
    }
}
