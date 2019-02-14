package com.example.firstnavigation.activitys.information;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.base.activity.SimpleActivity;
import com.example.firstnavigation.fragments.CircleFragment;
import com.example.firstnavigation.fragments.information.InformationFragment;
import com.example.firstnavigation.fragments.user.MyFragment;
import com.example.firstnavigation.fragments.topic.TopicFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class InformationActivity extends SimpleActivity {

    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    Unbinder unbinder;
    @BindView(R.id.iv_Search)
    ImageView mIvSearch;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mTab.addTab(mTab.newTab().setText("资讯").setIcon(R.drawable.information));
        mTab.addTab(mTab.newTab().setText("话题").setIcon(R.drawable.topic));
        mTab.addTab(mTab.newTab().setText("圈子").setIcon(R.drawable.circle));
        mTab.addTab(mTab.newTab().setText("我的").setIcon(R.drawable.my));

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
                if (tab.getPosition() ==0){
                    mToolbar.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        View decorView = getWindow().getDecorView();
                        //设置修改状态栏
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        //设置系统状态栏的颜色
                        window.setStatusBarColor(getResources().getColor(R.color.colorRed));
                    }
                }else {
                    mToolbar.setVisibility(View.GONE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        View decorView = getWindow().getDecorView();
                        //设置修改状态栏
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        //设置系统状态栏的颜色
                        window.setStatusBarColor(getResources().getColor(R.color.colorWhite));
                    }
                }
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
        fragments.add(new InformationFragment());
        fragments.add(new TopicFragment());
        fragments.add(new CircleFragment());
        fragments.add(new MyFragment());

        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_information;
    }

    @OnClick(R.id.iv_Search)
    public void onViewClicked() {
        startActivity(new Intent(InformationActivity.this,SearchActivity.class));
    }
}
