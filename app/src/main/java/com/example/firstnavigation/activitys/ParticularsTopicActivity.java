package com.example.firstnavigation.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.contact.InfoTopicCon;
import com.example.firstnavigation.presenter.InfoTopicPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParticularsTopicActivity extends BaseActivity<InfoTopicCon.InfoTopicV, InfoTopicPresenter<InfoTopicCon.InfoTopicV>> implements InfoTopicCon.InfoTopicV {

    @BindView(R.id.linear)
    LinearLayout mLinear;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_particulars_topic;
    }

    @Override
    protected void initEvenAndData() {
        Intent intent = getIntent();
        String topicId = intent.getStringExtra("topicId");
        mPresenter.getInfoTopic(topicId, "efe7538b97f14d11952f5a13e1c7f7cd");
    }

    @Override
    protected InfoTopicPresenter<InfoTopicCon.InfoTopicV> createPresenter() {
        return new InfoTopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showInfoTopic(InfoTopic infoTopic) {
        Log.e("44444444", infoTopic.getTitle());
    }
}
