package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.UpDataInfo;
import com.example.firstnavigation.beans.UserInfo;
import com.example.firstnavigation.contact.UserInfoCon;
import com.example.firstnavigation.presenter.UserInfoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GeRenActivity extends BaseActivity<UserInfoCon.UserInfoV, UserInfoPresenter<UserInfoCon.UserInfoV>> implements UserInfoCon.UserInfoV {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_user_head)
    ImageView mIvUserHead;
    @BindView(R.id.touxiang)
    LinearLayout mTouxiang;
    @BindView(R.id.tv_userName)
    TextView mTvUserName;
    @BindView(R.id.nicheng)
    LinearLayout mNicheng;
    @BindView(R.id.tv_xingbie)
    TextView mTvXingbie;
    @BindView(R.id.xingbie)
    LinearLayout mXingbie;
    @BindView(R.id.tv_shengri)
    TextView mTvShengri;
    @BindView(R.id.shengri)
    LinearLayout mShengri;
    @BindView(R.id.tv_zhiye)
    TextView mTvZhiye;
    @BindView(R.id.zhiye)
    LinearLayout mZhiye;
    @BindView(R.id.tv_jianjie)
    TextView mTvJianjie;
    @BindView(R.id.jianjie)
    LinearLayout mJianjie;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.bt_que)
    Button mBtQue;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        mPresenter.getUserInfo("efe7538b97f14d11952f5a13e1c7f7cd");

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

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
    protected int createLayoutId() {
        return R.layout.activity_ge_ren;
    }

    @Override
    protected UserInfoPresenter<UserInfoCon.UserInfoV> createPresenter() {
        return new UserInfoPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(GeRenActivity.this).load(userInfo.getHeadImagePath()).apply(requestOptions).into(mIvUserHead);
        mTvUserName.setText(userInfo.getNickname());
        mTvXingbie.setText(userInfo.getSex());
        mTvShengri.setText(userInfo.getBirthday());
        if (userInfo.getPersonalProfile() != null) {
            mTvJianjie.setText(userInfo.getPersonalProfile());
        }
        if (userInfo.getProfessionName() != null) {
            mTvZhiye.setText(userInfo.getProfessionName());
        }
    }

    @Override
    public void showUpDataInfo(UpDataInfo upDataInfo) {

    }

    @OnClick({R.id.touxiang, R.id.nicheng, R.id.xingbie, R.id.shengri, R.id.zhiye, R.id.jianjie,R.id.bt_que})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.touxiang:
                break;
            case R.id.nicheng:
                nicheng();
                break;
            case R.id.xingbie:
                break;
            case R.id.shengri:
                break;
            case R.id.zhiye:
                startActivity(new Intent(GeRenActivity.this, ProfessionActivity.class));
                break;
            case R.id.jianjie:
                break;
            case R.id.bt_que:
                break;
        }
    }

    private void nicheng() {
        View inflate = LayoutInflater.from(GeRenActivity.this).inflate(R.layout.pop_nicheng, null,false);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.showAtLocation(mNicheng, Gravity.CENTER,0,0);
    }
}
