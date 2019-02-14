package com.example.firstnavigation.activitys.topic;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.InsertTopic;
import com.example.firstnavigation.contact.InsertTopicCon;
import com.example.firstnavigation.fragments.PictureFragment;
import com.example.firstnavigation.fragments.ShareFragment;
import com.example.firstnavigation.fragments.topic.VideoFragment;
import com.example.firstnavigation.presenter.InsertTopicPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class PublishActivity extends BaseActivity<InsertTopicCon.InsertTopicV, InsertTopicPresenter<InsertTopicCon.InsertTopicV>> implements InsertTopicCon.InsertTopicV {

    @BindView(R.id.tv_publish)
    TextView mTvPublish;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_jump)
    ImageView mIvJump;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.linear)
    LinearLayout mLinear;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        mTab.addTab(mTab.newTab().setIcon(R.mipmap.picture));
        mTab.addTab(mTab.newTab().setIcon(R.mipmap.topic_vedio));
        mTab.addTab(mTab.newTab().setIcon(R.mipmap.topic_link));

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
        fragments.add(new ShareFragment());
        fragments.add(new VideoFragment());
        fragments.add(new PictureFragment());
        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));


    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_publish;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected InsertTopicPresenter<InsertTopicCon.InsertTopicV> createPresenter() {
        return new InsertTopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showInsertTopic(InsertTopic insertTopic) {

    }

    @OnClick({R.id.tv_publish, R.id.iv_jump})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_publish:
                break;
            case R.id.iv_jump:
                Intent intent = new Intent(PublishActivity.this,LabelActivity.class);
                startActivity(intent);
                break;
        }
    }
}
