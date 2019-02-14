package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.topic.MyTopicAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.Topic;
import com.example.firstnavigation.contact.TopicCon;
import com.example.firstnavigation.json.JsonTopic;
import com.example.firstnavigation.presenter.TopicPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchTopicActivity extends BaseActivity<TopicCon.TopicV, TopicPresenter<TopicCon.TopicV>> implements TopicCon.TopicV {

    @BindView(R.id.ivfan)
    ImageView mIvfan;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.xrlv_sou)
    XRecyclerView mXrlvSou;
    @BindView(R.id.linear)
    LinearLayout mLinear;

    private List<Topic.TopicListBean> mData = new ArrayList<>();
    private MyTopicAdapter mMyTopicAdapter;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mTvTitle.setText(tag);

        JsonTopic jsonTopic = new JsonTopic();
        jsonTopic.setKeyword(tag);
        jsonTopic.setCursor("0");
        mPresenter.getShowTopic(new Gson().toJson(jsonTopic));

        mXrlvSou.setLayoutManager(new LinearLayoutManager(SearchTopicActivity.this,LinearLayoutManager.VERTICAL,false));
        mMyTopicAdapter = new MyTopicAdapter(mData, SearchTopicActivity.this);
        mXrlvSou.setAdapter(mMyTopicAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_search_topic;
    }

    @Override
    protected TopicPresenter<TopicCon.TopicV> createPresenter() {
        return new TopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showTopic(Topic topic) {
        Log.e("tttttt",topic.getTopicList().get(0).getTitle());
        mMyTopicAdapter.setData(topic.getTopicList());
    }

    @OnClick(R.id.ivfan)
    public void onViewClicked() {
        finish();
    }
}
