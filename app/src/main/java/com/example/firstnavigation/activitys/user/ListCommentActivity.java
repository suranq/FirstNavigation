package com.example.firstnavigation.activitys.user;

import android.content.Intent;
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
import com.example.firstnavigation.beans.UserListComment;
import com.example.firstnavigation.contact.UserListCommentCon;
import com.example.firstnavigation.fragments.user.HuaFragment;
import com.example.firstnavigation.fragments.user.ZixunFragment;
import com.example.firstnavigation.presenter.UserListCommentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ListCommentActivity extends BaseActivity<UserListCommentCon.UserListCommentV, UserListCommentPresenter<UserListCommentCon.UserListCommentV>> implements UserListCommentCon.UserListCommentV {

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
    private List<UserListComment.UserCommentListBean> mZixun = new ArrayList<>();
    private List<UserListComment.UserCommentListBean> mHuati = new ArrayList<>();
    private ZixunFragment mZixunFragment;
    private HuaFragment mHuaFragment;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String headImagePath = intent.getStringExtra("HeadImagePath");
        String nickname = intent.getStringExtra("nickname");

        mPresenter.getUserListComment("efe7538b97f14d11952f5a13e1c7f7cd");
        mTab.addTab(mTab.newTab().setText("资讯"));
        mTab.addTab(mTab.newTab().setText("话题"));
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
        mZixunFragment = new ZixunFragment(headImagePath,nickname);
        mHuaFragment = new HuaFragment(headImagePath,nickname);
        fragments.add(mZixunFragment);
        fragments.add(mHuaFragment);
        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_list_comment;
    }

    @Override
    protected UserListCommentPresenter<UserListCommentCon.UserListCommentV> createPresenter() {
        return new UserListCommentPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showUserListComment(UserListComment userListComment) {
        Log.e("ppppppp",userListComment.getUserCommentList().get(0).getTitle());
        List<UserListComment.UserCommentListBean> userCommentList = userListComment.getUserCommentList();
        for (int i = 0; i < userCommentList.size(); i++) {
            if (userCommentList!= null&&userCommentList.get(i).getObjectType().equals("0")){
                mZixun.add(userCommentList.get(i));
            }else {
                mHuati.add(userCommentList.get(i));
            }
        }
        mZixunFragment.setData(mZixun);
        mHuaFragment.setData(mHuati);
    }

    @OnClick(R.id.iv_fan)
    public void onViewClicked() {
        finish();
    }
}
