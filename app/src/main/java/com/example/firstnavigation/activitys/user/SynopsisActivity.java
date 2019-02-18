package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.SimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SynopsisActivity extends SimpleActivity {

    private static OnItemListener mListener;
    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ed_synopsis)
    EditText mEdSynopsis;
    @BindView(R.id.tv_quantity)
    TextView mTvQuantity;
    @BindView(R.id.linear)
    LinearLayout mLinear;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        Intent intent = getIntent();
        String jianjie = intent.getStringExtra("jianjie");
        mEdSynopsis.setHint(jianjie);

        mEdSynopsis.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                quantity();
            }
        });
    }

    private void quantity() {
        int length = mEdSynopsis.getText().length();
        mTvQuantity.setText(length+"/30");
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_synopsis;
    }

    @OnClick({R.id.iv_fan, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_fan:
                finish();
                break;
            case R.id.tv_save:
                mListener.OnItemListener(mEdSynopsis.getText().toString());
                finish();
                break;
        }
    }

    public interface OnItemListener{
        void OnItemListener(String zhiye);
    }

    public static void setOnItemListener(OnItemListener listener){
        mListener = listener;
    }
}
