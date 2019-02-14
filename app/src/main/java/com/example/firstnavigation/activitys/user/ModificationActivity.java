package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.SimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModificationActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.shezhia)
    LinearLayout mShezhia;
    @BindView(R.id.huacun)
    LinearLayout mHuacun;
    @BindView(R.id.ziti)
    LinearLayout mZiti;
    @BindView(R.id.sc)
    SwitchCompat mSc;
    @BindView(R.id.wifi)
    LinearLayout mWifi;
    @BindView(R.id.guanyu)
    LinearLayout mGuanyu;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.bt_quit)
    Button mBtQuit;

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
        return R.layout.activity_modification;
    }

    @OnClick({R.id.shezhia, R.id.huacun, R.id.ziti, R.id.sc, R.id.wifi, R.id.guanyu, R.id.linear,R.id.bt_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shezhia:
                startActivity(new Intent(ModificationActivity.this, GeRenActivity.class));
                break;
            case R.id.huacun:
                break;
            case R.id.ziti:
                break;
            case R.id.sc:
                break;
            case R.id.wifi:
                break;
            case R.id.guanyu:
                break;
            case R.id.linear:
                break;
            case R.id.bt_quit:
                break;
        }
    }
}
