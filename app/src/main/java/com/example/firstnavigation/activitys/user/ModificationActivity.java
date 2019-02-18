package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.SimpleActivity;
import com.example.firstnavigation.shujukuBeans.Wifi;
import com.example.firstnavigation.shujukuBeans.WifiHelep;
import com.example.firstnavigation.typeface.SetSizeActivity;
import com.example.firstnavigation.utils.DataCleanManager;

import java.util.List;

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
    @BindView(R.id.wifi)
    LinearLayout mWifi;
    @BindView(R.id.guanyu)
    LinearLayout mGuanyu;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.bt_quit)
    Button mBtQuit;
    @BindView(R.id.sc_Wifi)
    SwitchCompat mScWifi;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.tv_huancun)
    TextView mTvHuancun;
    private WifiHelep mInsh;
    private List<Wifi> mWifis;
    private Wifi mWifi1;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {

        mInsh = WifiHelep.getInsh();

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        mWifis = mInsh.selectAll();
        for (int i = 0; i < mWifis.size(); i++) {
            mWifi1 = mWifis.get(i);
        }
        mScWifi.setChecked(mWifi1.getIsOpen());

        try {
            mTvHuancun.setText(DataCleanManager.getTotalCacheSize(getApplicationContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @OnClick({R.id.shezhia, R.id.huacun, R.id.ziti, R.id.sc_Wifi, R.id.wifi, R.id.guanyu, R.id.linear, R.id.bt_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shezhia:
                startActivity(new Intent(ModificationActivity.this, GeRenActivity.class));
                break;
            case R.id.huacun:
                DataCleanManager.clearAllCache(getApplicationContext());
                try {
                    mTvHuancun.setText(DataCleanManager.getTotalCacheSize(getApplicationContext()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ziti:
                startActivity(new Intent(ModificationActivity.this, SetSizeActivity.class));
                break;
            case R.id.sc_Wifi:
                if (mScWifi.isChecked()) {
                    mWifi1.setIsOpen(true);
                    mInsh.updata(mWifi1);
                } else {
                    mWifi1.setIsOpen(false);
                    mInsh.updata(mWifi1);
                }
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
