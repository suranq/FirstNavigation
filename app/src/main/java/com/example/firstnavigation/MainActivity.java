package com.example.firstnavigation;

import android.content.Intent;
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

import com.example.firstnavigation.activitys.information.InformationActivity;
import com.example.firstnavigation.activitys.MessageActivity;
import com.example.firstnavigation.activitys.SanfangActivity;
import com.example.firstnavigation.base.activity.SimpleActivity;
import com.example.firstnavigation.dao.WifiDao;
import com.example.firstnavigation.shujukuBeans.DataBaseHelep;
import com.example.firstnavigation.shujukuBeans.Studnet;
import com.example.firstnavigation.shujukuBeans.Wifi;
import com.example.firstnavigation.shujukuBeans.WifiHelep;
import com.example.firstnavigation.utils.SystemUtil;
import com.example.firstnavigation.utils.TimeUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends SimpleActivity {

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
    private DataBaseHelep mInsh;
    private Intent mIntent;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        List<Wifi> wifis = WifiHelep.getInsh().selectAll();
        if (wifis != null && wifis.size() > 0) {

        } else {
            WifiHelep.getInsh().insert(new Wifi(null, true, SystemUtil.isWifiConnected()));
        }

        mInsh = DataBaseHelep.getInsh();
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
                startActivity(new Intent(MainActivity.this, SanfangActivity.class));
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
                Intent intent = new Intent(MainActivity.this, SanfangActivity.class);
                for (String key : map.keySet()) {
                    Log.e("sunxu--11", "key=" + key + "value=" + map.get(key));
                    intent.putExtra("iiiii", map.get("iconurl"));
                }
                startActivity(intent);
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

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
        String phone = mEtPhone.getText().toString();
        if (phone.matches("[1][3,4,5,7,8][0-9]{9}")) {
            mEtVerification.setText(buffer1.toString());
        } else {
            Toast.makeText(MainActivity.this, "请输入正确的手机号", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.bt_login)
    public void onViewClicked() {
        String phone = mEtPhone.getText().toString();
        String string = mEtVerification.getText().toString();
        if (phone.matches("[1][3,4,5,7,8][0-9]{9}") && string.matches("[0-9]{6}") && mCbConsent.isChecked()) {
            List<Studnet> studnets = mInsh.selectS(phone);
            mIntent = new Intent(MainActivity.this, MessageActivity.class);
            if (studnets != null && studnets.size() > 0) {
                if (studnets.get(0).getIsStorage()) {
                    startActivity(new Intent(MainActivity.this, InformationActivity.class));
                } else {
                    startActivity(mIntent);
                }
            } else {
                mIntent.putExtra("phone", phone);
                startActivity(mIntent);
            }
        } else {
            Toast.makeText(this, "手机号或验证码错误", Toast.LENGTH_LONG).show();
        }
    }
}
