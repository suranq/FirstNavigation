package com.example.firstnavigation.activitys.user;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.ListNotify;
import com.example.firstnavigation.contact.ListNotifyCon;
import com.example.firstnavigation.fragments.user.inform.AttentionFragment;
import com.example.firstnavigation.fragments.user.inform.CommentFragment;
import com.example.firstnavigation.fragments.user.inform.InformFragment;
import com.example.firstnavigation.fragments.user.inform.LikeFragment;
import com.example.firstnavigation.presenter.ListNotifyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InformActivity extends BaseActivity<ListNotifyCon.ListNotifyV, ListNotifyPresenter<ListNotifyCon.ListNotifyV>> implements ListNotifyCon.ListNotifyV {
    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.linear)
    LinearLayout mLinear;

    private List<ListNotify.DataBean> mInformData = new ArrayList<>();
    private List<ListNotify.DataBean> mCommentData = new ArrayList<>();
    private List<ListNotify.DataBean> mAttentionData = new ArrayList<>();
    private List<ListNotify.DataBean> mLikeData = new ArrayList<>();
    private InformFragment mInformFragment;
    private CommentFragment mCommentFragment;
    private AttentionFragment mAttentionFragment;
    private LikeFragment mLikeFragment;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mPresenter.getListNotify("efe7538b97f14d11952f5a13e1c7f7cd");

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mTab.addTab(mTab.newTab().setText("通知"));
        mTab.addTab(mTab.newTab().setText("评论我"));
        mTab.addTab(mTab.newTab().setText("关注我"));
        mTab.addTab(mTab.newTab().setText("点赞我"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        ArrayList<Fragment> fragments = new ArrayList<>();
        mInformFragment = new InformFragment();
        mCommentFragment = new CommentFragment();
        mAttentionFragment = new AttentionFragment();
        mLikeFragment = new LikeFragment();
        fragments.add(mInformFragment);
        fragments.add(mCommentFragment);
        fragments.add(mAttentionFragment);
        fragments.add(mLikeFragment);
        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_inform;
    }

    @Override
    protected ListNotifyPresenter<ListNotifyCon.ListNotifyV> createPresenter() {
        return new ListNotifyPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showListNotify(ListNotify listNotify) {
        Log.e("lllll", listNotify.getData().get(0).getFromTitle());
        List<ListNotify.DataBean> data = listNotify.getData();
        mLikeData.clear();
        mInformData.clear();
        mAttentionData.clear();
        mCommentData.clear();
        for (int i = 0; i < data.size(); i++) {
            if (data != null && data.get(i).getNotifyType().equals("0")) {
                mInformData.add(data.get(i));
            } else if (data != null && data.get(i).getNotifyType().equals("1")) {
                mAttentionData.add(data.get(i));
            } else if (data != null && data.get(i).getNotifyType().equals("2")) {
                mCommentData.add(data.get(i));
            } else if (data != null && data.get(i).getNotifyType().equals("3")) {
                mLikeData.add(data.get(i));
            }
        }
        mInformFragment.setData(mInformData);
        mCommentFragment.setData(mCommentData);
        mAttentionFragment.setData(mAttentionData);
        mLikeFragment.setData(mLikeData);
    }

    @OnClick(R.id.iv_fan)
    public void onViewClicked() {
        finish();
    }
}
