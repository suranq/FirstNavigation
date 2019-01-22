package com.example.firstnavigation.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.SimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SanfangActivity extends SimpleActivity {

    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_portrait)
    ImageView mIvPortrait;
    @BindView(R.id.bt_denglu)
    Button mBtDenglu;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        Intent intent = getIntent();
        String headimage = intent.getStringExtra("iiiii");
        Glide.with(mContext).load(headimage).into(mIvPortrait);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_sanfang;
    }

    @OnClick({R.id.tv_cancel, R.id.bt_denglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.bt_denglu:
                startActivity(new Intent(SanfangActivity.this,InformationActivity.class));
                break;
        }
    }
}
