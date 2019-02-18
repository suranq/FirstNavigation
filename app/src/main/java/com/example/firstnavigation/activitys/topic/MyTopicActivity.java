package com.example.firstnavigation.activitys.topic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.topic.MyListTopicAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.ListTopic;
import com.example.firstnavigation.contact.ListTopicCon;
import com.example.firstnavigation.presenter.ListTopicPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTopicActivity extends BaseActivity<ListTopicCon.ListTopicV, ListTopicPresenter<ListTopicCon.ListTopicV>> implements ListTopicCon.ListTopicV {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_fabiao)
    ImageView mIvFabiao;
    @BindView(R.id.xrlv_mytopic)
    XRecyclerView mXrlvMytopic;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.iv_fan)
    ImageView mIvFan;

    private List<ListTopic.FavouritTopicListBean> mData = new ArrayList<>();
    private MyListTopicAdapter mMyListTopicAdapter;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mPresenter.get("efe7538b97f14d11952f5a13e1c7f7cd", "0");

        mXrlvMytopic.setLayoutManager(new LinearLayoutManager(MyTopicActivity.this, LinearLayoutManager.VERTICAL, false));
        mXrlvMytopic.addItemDecoration(new DividerItemDecoration(MyTopicActivity.this, DividerItemDecoration.VERTICAL));

        mMyListTopicAdapter = new MyListTopicAdapter(mData, MyTopicActivity.this, mLinear, mXrlvMytopic);
        mXrlvMytopic.setAdapter(mMyListTopicAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_my_topic;
    }

    @Override
    protected ListTopicPresenter<ListTopicCon.ListTopicV> createPresenter() {
        return new ListTopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showListTopic(ListTopic listTopic) {
        mMyListTopicAdapter.setData(listTopic.getFavouritTopicList());
    }

    @OnClick({R.id.iv_fan, R.id.iv_fabiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_fan:
                finish();
                break;
            case R.id.iv_fabiao:
                startActivity(new Intent(MyTopicActivity.this,PublishActivity.class));
                break;
        }
    }
}
