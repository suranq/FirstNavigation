package com.example.firstnavigation.activitys.user;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.MainActivity;
import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.ListProfession;
import com.example.firstnavigation.beans.UpDataInfo;
import com.example.firstnavigation.beans.UserInfo;
import com.example.firstnavigation.contact.UserInfoCon;
import com.example.firstnavigation.json.JsonUpData;
import com.example.firstnavigation.presenter.UserInfoPresenter;
import com.google.gson.Gson;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.AlertDialog.THEME_HOLO_LIGHT;

public class GeRenActivity extends BaseActivity<UserInfoCon.UserInfoV, UserInfoPresenter<UserInfoCon.UserInfoV>> implements UserInfoCon.UserInfoV, SynopsisActivity.OnItemListener, ProfessionActivity.OnItemListener {

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
    private int yourChoice = 0;
    private UserInfo mUserInfo;

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

        SynopsisActivity.setOnItemListener(this);
        ProfessionActivity.setOnItemListener(this);
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
        mUserInfo = userInfo;
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

    @OnClick({R.id.touxiang, R.id.nicheng, R.id.xingbie, R.id.shengri, R.id.zhiye, R.id.jianjie, R.id.bt_que})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.touxiang:
                break;
            case R.id.nicheng:
                nicheng();
                break;
            case R.id.xingbie:
                xingbie();
                break;
            case R.id.shengri:
                showDatePickerDialog(GeRenActivity.this, mTvShengri);
                break;
            case R.id.zhiye:
                startActivity(new Intent(GeRenActivity.this, ProfessionActivity.class));
                break;
            case R.id.jianjie:
                Intent intent = new Intent(GeRenActivity.this, SynopsisActivity.class);
                intent.putExtra("jianjie",mTvJianjie.getText().toString());
                startActivity(intent);
                break;
            case R.id.bt_que:
                xiugai();
                break;
        }
    }

    private void xiugai() {
        JsonUpData jsonUpData = new JsonUpData();
        jsonUpData.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        jsonUpData.setBirthday(mTvShengri.getText().toString());
        jsonUpData.setNickname(mTvUserName.getText().toString());
        if (mTvXingbie.getText().toString().equals("男")) {
            jsonUpData.setSex("1");
        } else {
            jsonUpData.setSex("2");
        }
        jsonUpData.setPersonalProfile(mTvJianjie.getText().toString());
        if (mTvZhiye.getText().toString().equals(mUserInfo.getProfessionName())) {
            jsonUpData.setProfessionId(mUserInfo.getProfessionId());
        }
        mPresenter.getUpDataInfo(new Gson().toJson(jsonUpData));
    }

    public static void showDatePickerDialog(Activity activity, final TextView tv) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        Calendar instance = Calendar.getInstance();
        new DatePickerDialog(activity
                , TimePickerDialog.THEME_HOLO_LIGHT
                // 绑定监听器(How the parent is notified that the date is set.)
                , new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                if (monthOfYear < 10 && dayOfMonth < 10) {
                    tv.setText(year + "-" + "0" + monthOfYear
                            + "-" + "0" + dayOfMonth);
                } else if (monthOfYear < 10) {
                    tv.setText(year + "-" + "0" + monthOfYear
                            + "-" + dayOfMonth);
                } else if (dayOfMonth < 10) {
                    tv.setText(year + "-" + monthOfYear
                            + "-" + "0" + dayOfMonth);
                } else {
                    tv.setText(year + "-" + monthOfYear
                            + "-" + dayOfMonth);
                }
            }
        }
                // 设置初始日期
                , instance.get(Calendar.YEAR)
                , instance.get(Calendar.MONTH)
                , instance.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void xingbie() {
        final String[] items = {"男", "女"};
//        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(GeRenActivity.this);
        singleChoiceDialog.setTitle("请选择性别");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {
                            mTvXingbie.setText(items[yourChoice]);
                            yourChoice = 0;
                        }
                    }
                });

        singleChoiceDialog.show();
    }

    private void nicheng() {
        final EditText editText = new EditText(GeRenActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(GeRenActivity.this);
        editText.setHint(mTvUserName.getText());
        inputDialog.setTitle("请输入昵称").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTvUserName.setText(editText.getText().toString());
                    }
                }).show();
    }

    @Override
    public void OnItemListener(String zhiye) {
        mTvJianjie.setText(zhiye);
    }

    @Override
    public void OnItemListener(ListProfession.ProfessionListBean professionListBean) {
        mTvZhiye.setText(professionListBean.getProfessionName());
    }
}
