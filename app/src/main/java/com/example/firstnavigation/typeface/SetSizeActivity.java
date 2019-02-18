package com.example.firstnavigation.typeface;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.firstnavigation.MainActivity;
import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.information.InformationActivity;
import com.example.firstnavigation.base.activity.SimpleActivity;
import com.example.firstnavigation.global.App;

/**
 * Created by asd on 2019/2/13.
 */

public class SetSizeActivity extends SimpleActivity implements View.OnClickListener {
    private ImageView mIvBack;
    /**
     * 字体大小
     */
    private TextView mHeadtoptext;
    private TextView mHeadtoptext2;
    private RelativeLayout mMainTop;
    /**
     * 预览字体大小
     */
    private TextView mTvChatcontent;
    private ImageView mIvUserhead;
    private ImageView mIvUserhead1;
    /**
     * 滑动下面的滑块调整字体大小
     */
    private TextView mTvChatcontent1;
    private RelativeLayout mContentMsgView;
    private ImageView mIvUserhead3;
    /**
     * 设置后，会改变所有模块中的字体大小。如果在使用过程中存在问题或意见，可反馈给xxx。
     */
    private TextView mTvChatcontent3;
    private FontSliderBar mFontSliderBar;
    private float textsize1, textsize2, textsize3;
    private float textSizef;//缩放比例
    private int currentIndex;
    private boolean isClickable = true;
    private Toolbar mTbl;

    @Override
    protected int getActivityColor() {
        return R.color.colorPuhlish;
    }

    @Override
    protected void initData() {
        initView();
        currentIndex = App.getApp().getPreferencesHelper().getValueInt("currentIndex", 1);
        textSizef = 1 + currentIndex * 0.1f;
        textsize1 = mTvChatcontent.getTextSize() / textSizef;
        textsize2 = mTvChatcontent1.getTextSize() / textSizef;
        textsize3 = mTvChatcontent3.getTextSize() / textSizef;
        mFontSliderBar.setTickCount(6).setTickHeight(DisplayUtils.convertDip2Px(SetSizeActivity.this, 15)).setBarColor(Color.GRAY)
                .setTextColor(Color.BLACK).setTextPadding(DisplayUtils.convertDip2Px(SetSizeActivity.this, 10)).setTextSize(DisplayUtils.convertDip2Px(SetSizeActivity.this, 14))
                .setThumbRadius(DisplayUtils.convertDip2Px(SetSizeActivity.this, 10)).setThumbColorNormal(Color.GRAY).setThumbColorPressed(Color.GRAY)
                .setOnSliderBarChangeListener(new FontSliderBar.OnSliderBarChangeListener() {
                    @Override
                    public void onIndexChanged(FontSliderBar rangeBar, int index) {
                        if(index>5){
                            return;
                        }
                        index = index - 1;
                        float textSizef = 1 + index * 0.1f;
                        setTextSize(textSizef);
                    }
                }).setThumbIndex(currentIndex).withAnimation(false).applay();
    /*    mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    private void setTextSize(float textSize) {
        //改变当前页面的字体大小
        mTvChatcontent.setTextSize(DisplayUtils.px2sp(SetSizeActivity.this, textsize1 * textSize));
        mTvChatcontent1 .setTextSize(DisplayUtils.px2sp(SetSizeActivity.this, textsize2 * textSize));
        mTvChatcontent3.setTextSize(DisplayUtils.px2sp(SetSizeActivity.this, textsize3 * textSize));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (currentIndex != mFontSliderBar.getCurrentIndex()) {
                if (isClickable) {
                    isClickable = false;
                    refresh();
                }
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void refresh() {
        //存储标尺的下标
       App.getApp().getPreferencesHelper().setValue("currentIndex", mFontSliderBar.getCurrentIndex());
        //通知主页面重启
        RxBus.getInstance().post(MainActivity.class.getSimpleName(), new MessageSocket(99, null, null, null));
        //重启mainActivity
        RxBus.getInstance().post(InformationActivity.class.getSimpleName(), new MessageSocket(99, null, null, null));
//        showMyDialog();
        //2s后关闭  延迟执行任务 重启完主页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                hideMyDialog();
                finish();
            }
        }, 2000);
    }
    @Override
    protected int createLayoutId() {
        return R.layout.setsize;
    }

    public void initView() {

        mTbl = findViewById(R.id.tbl);
        mHeadtoptext = (TextView) findViewById(R.id.headtoptext);
      /*  mHeadtoptext2 = (TextView) findViewById(R.id.headtoptext2);
        mMainTop = (RelativeLayout) findViewById(R.id.main_top);*/
        mTvChatcontent = (TextView) findViewById(R.id.tv_chatcontent);
        mIvUserhead = (ImageView) findViewById(R.id.iv_userhead);
        mIvUserhead1 = (ImageView) findViewById(R.id.iv_userhead1);
        mTvChatcontent1 = (TextView) findViewById(R.id.tv_chatcontent1);
        mTvChatcontent1.setOnClickListener(this);
        mContentMsgView = (RelativeLayout) findViewById(R.id.content_msg_view);
        mIvUserhead3 = (ImageView) findViewById(R.id.iv_userhead3);
        mTvChatcontent3 = (TextView) findViewById(R.id.tv_chatcontent3);
        mTvChatcontent3.setOnClickListener(this);
        mFontSliderBar = (FontSliderBar) findViewById(R.id.fontSliderBar);
        mTbl.setTitle("");
        setSupportActionBar(mTbl);
        mTbl.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFontSliderBar.getCurrentIndex() != currentIndex) {
                    if (isClickable) {
                        Log.i("yui", "onClick: sdfsssssssssssss");
                        isClickable = false;
                        refresh();
                    }
                } else {
                    Log.i("yui", "onClick: sdfssfffffffffffffffffffffsssssssssss");
                    finish();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_chatcontent1:
                break;
            case R.id.tv_chatcontent3:
                break;
        }
    }
}
