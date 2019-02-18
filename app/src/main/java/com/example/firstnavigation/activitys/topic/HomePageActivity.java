package com.example.firstnavigation.activitys.topic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.topic.MyHomeListAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.HomeList;
import com.example.firstnavigation.beans.HomePage;
import com.example.firstnavigation.contact.HomePageCon;
import com.example.firstnavigation.json.JsonFollow;
import com.example.firstnavigation.json.JsonHomeList;
import com.example.firstnavigation.presenter.HomeListPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomePageActivity extends BaseActivity<HomePageCon.HomePageV, HomeListPresenter<HomePageCon.HomePageV>> implements HomePageCon.HomePageV {

    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_user_head)
    ImageView mIvUserHead;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_topicshu)
    TextView mTvTopicshu;
    @BindView(R.id.topic)
    LinearLayout mTopic;
    @BindView(R.id.tv_attention)
    TextView mTvAttention;
    @BindView(R.id.attention)
    LinearLayout mAttention;
    @BindView(R.id.tv_quanzi)
    TextView mTvQuanzi;
    @BindView(R.id.quanzi)
    LinearLayout mQuanzi;
    @BindView(R.id.bt_attention)
    Button mBtAttention;
    @BindView(R.id.tv_jianjie)
    TextView mTvJianjie;
    @BindView(R.id.tv_zhankai)
    TextView mTvZhankai;
    @BindView(R.id.rlv_topic)
    RecyclerView mRlvTopic;
    @BindView(R.id.linear)
    LinearLayout mLinear;

    List<HomeList.TopicListBean> mData = new ArrayList<>();
    private MyHomeListAdapter mMyHomeListAdapter;
    private String mLookUserId;
    private JsonFollow mJsonFollow;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mLookUserId = intent.getStringExtra("lookUserId");
        mPresenter.getHomePage("efe7538b97f14d11952f5a13e1c7f7cd", mLookUserId);
        mJsonFollow = new JsonFollow();
        JsonHomeList jsonHomeList = new JsonHomeList();
        jsonHomeList.setCursor("0");
        jsonHomeList.setLookUserId(mLookUserId);
        jsonHomeList.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mPresenter.getHomeList(new Gson().toJson(jsonHomeList));

        mRlvTopic.setLayoutManager(new LinearLayoutManager(HomePageActivity.this,LinearLayoutManager.VERTICAL,false));
        mRlvTopic.addItemDecoration(new DividerItemDecoration(HomePageActivity.this,DividerItemDecoration.VERTICAL));

        mMyHomeListAdapter = new MyHomeListAdapter(mData,HomePageActivity.this);
        mRlvTopic.setAdapter(mMyHomeListAdapter);

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected HomeListPresenter<HomePageCon.HomePageV> createPresenter() {
        return new HomeListPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showHomePage(HomePage homePage) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(HomePageActivity.this).load(homePage.getHeadImagePath()).apply(requestOptions).into(mIvUserHead);
        mTvTopicshu.setText(homePage.getTopics()+"");
        mTvAttention.setText(homePage.getFollowers()+"");
        if (homePage.getIsFollowed() == 0){
            mBtAttention.setText("关注");
        }else {
            mBtAttention.setText("已关注");
        }
        mTvJianjie.setText(homePage.getPersonalProfile());
    }

    @Override
    public void showHomeList(HomeList homeList) {
        mMyHomeListAdapter.setData(homeList.getTopicList());
    }

    @Override
    public void showFollow(Follow follow) {

    }

    @OnClick({R.id.iv_fan, R.id.tv_zhankai,R.id.bt_attention})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_fan:
                finish();
                break;
            case R.id.tv_zhankai:

                break;
            case R.id.bt_attention:
//                HomePageActivity
                if (mBtAttention.getText().toString().equals("关注")){
                    guanzhu();
                    mBtAttention.setText("已关注");
                }else {
                    quxiao();
                    mBtAttention.setText("关注");
                }
                break;
        }
    }

    private void quxiao() {
        mJsonFollow.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonFollow.setFollowUid(mLookUserId);
        mJsonFollow.setType("1");
        mPresenter.getFollow(new Gson().toJson(mJsonFollow));
    }

    private void guanzhu() {
        mJsonFollow.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonFollow.setFollowUid(mLookUserId);
        mJsonFollow.setType("0");
        mPresenter.getFollow(new Gson().toJson(mJsonFollow));
    }
}
