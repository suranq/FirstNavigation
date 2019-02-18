package com.example.firstnavigation.activitys.user;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.base.activity.SimpleActivity;
import com.example.firstnavigation.fragments.user.IssueFragment;
import com.example.firstnavigation.fragments.user.SubmitFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedbackActivity extends SimpleActivity {


    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.ed_feedback)
    ImageView mEdFeedback;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mTab.addTab(mTab.newTab().setText("提交问题"));
        mTab.addTab(mTab.newTab().setText("常见问题"));
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
        fragments.add(new SubmitFragment());
        fragments.add(new IssueFragment());
        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_feedback;
    }

    @OnClick(R.id.iv_fan)
    public void onViewClicked() {
        finish();
    }
}
