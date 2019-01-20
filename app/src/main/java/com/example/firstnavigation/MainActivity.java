package com.example.firstnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstnavigation.activitys.MessageActivity;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.contact.ListNewsCon;
import com.example.firstnavigation.presenter.ListNewsPresenter;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<ListNewsCon.ListNewsConV, ListNewsPresenter<ListNewsCon.ListNewsConV>> implements ListNewsCon.ListNewsConV {

    @BindView(R.id.image_cross)
    ImageView mImageCross;
    @BindView(R.id.et_Phone)
    EditText mEtPhone;
    @BindView(R.id.et_Verification)
    EditText mEtVerification;
    @BindView(R.id.tv_Verification)
    TextView mTvVerification;
    @BindView(R.id.bt_login)
    ImageView mBtLogin;
    @BindView(R.id.cb_consent)
    CheckBox mCbConsent;
    @BindView(R.id.tv_agreement)
    TextView mTvAgreement;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.wechat)
    ImageView mWechat;
    @BindView(R.id.qq)
    ImageView mQq;
    @BindView(R.id.Sina)
    ImageView mSina;


    @Override
    protected void initEvenAndData() {
        mPresenter.getListNews("");
        mBtLogin.setClickable(false);
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gaibian();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEtVerification.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gaibian();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//        CrashReport.testJavaCrash();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected ListNewsPresenter<ListNewsCon.ListNewsConV> createPresenter() {
        return new ListNewsPresenter<>();
    }


    @Override
    protected View getActivityID() {
        return mLinear;
    }


    @Override
    public void showError(String error) {

    }

    @Override
    public void showListNews(ListNews listNews) {
        Log.e("11111111", listNews.toString());
    }

    @Override
    protected void initData() {

    }

    private void gaibian() {
        String phone = mEtPhone.getText().toString();
        String string = mEtVerification.getText().toString();
        if (phone != null && string != null && mCbConsent.isChecked() && phone.length() > 0 && string.length() > 0) {
            mBtLogin.setImageResource(R.drawable.login1);
            mBtLogin.setClickable(true);
        } else {
            mBtLogin.setImageResource(R.drawable.login2);
            mBtLogin.setClickable(false);
        }

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.image_cross, R.id.tv_Verification, R.id.cb_consent, R.id.tv_agreement, R.id.wechat, R.id.qq, R.id.Sina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_cross:
                break;
            case R.id.tv_Verification:
                suijishu();
                break;
            case R.id.cb_consent:
                gaibian();
                break;
            case R.id.tv_agreement:

                break;
            case R.id.wechat:
                break;
            case R.id.qq:
                QQdneglu();
                break;
            case R.id.Sina:
                break;
        }
    }

    private void QQdneglu() {
        UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                for (String key : map.keySet()) {
                    Log.e("sunxu--11", "key=" + key + "value=" + map.get(key));

                }

            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                Log.e("sunxu--22", throwable.getMessage());

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }

    private void suijishu() {
        StringBuffer buffer1 = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int randomnum = (int) (Math.random() * 9);
            buffer1.append(randomnum);
        }
        mEtVerification.setText(buffer1.toString());
    }

    @OnClick(R.id.bt_login)
    public void onViewClicked() {
        String phone = mEtPhone.getText().toString();
        String string = mEtVerification.getText().toString();
        if (phone.matches("[0-9]{11}") && string.matches("[0-9]{6}") && mCbConsent.isChecked()) {
            startActivity(new Intent(MainActivity.this, MessageActivity.class));
        } else {
            Toast.makeText(this, "手机号或验证码错误", Toast.LENGTH_LONG).show();
        }
    }
}
