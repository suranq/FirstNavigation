package com.example.firstnavigation.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.ParticularsTopicActivity;
import com.example.firstnavigation.adapters.MyLoadTopicAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.LoadTopic;
import com.example.firstnavigation.contact.LoadTopicCon;
import com.example.firstnavigation.json.JsonLoadTopic;
import com.example.firstnavigation.presenter.LoadTopicPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicxiaoFragment extends BaseFragment<LoadTopicCon.LoadTopicV, LoadTopicPresenter<LoadTopicCon.LoadTopicV>> implements LoadTopicCon.LoadTopicV, XRecyclerView.LoadingListener {


    @BindView(R.id.iv_publish)
    ImageView mIvPublish;
    @BindView(R.id.xrlv_topic)
    XRecyclerView mXrlvTopic;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    Unbinder unbinder;
    private MyLoadTopicAdapter mMyLoadTopicAdapter;
    private List<LoadTopic.TopicListBean> mData = new ArrayList<>();
    private JsonLoadTopic mJsonLoadTopic;
    private String mCursor;

    public TopicxiaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void load() {
        mJsonLoadTopic = new JsonLoadTopic();
        mJsonLoadTopic.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLoadTopic.setType("0");
        mJsonLoadTopic.setCursor("0");
        mJsonLoadTopic.setTagId("0");
        mPresenter.getLoadTopic(new Gson().toJson(mJsonLoadTopic));

    }

    @Override
    protected void initData() {

        mXrlvTopic.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mMyLoadTopicAdapter = new MyLoadTopicAdapter(mData,getContext());
        mXrlvTopic.setAdapter(mMyLoadTopicAdapter);

        mXrlvTopic.setLoadingListener(this);

        mMyLoadTopicAdapter.setOnItemListener(new MyLoadTopicAdapter.OnItemListener() {
            @Override
            public void OnItemListener(LoadTopic.TopicListBean topicListBean) {
                Intent intent = new Intent(getContext(), ParticularsTopicActivity.class);
                intent.putExtra("topicId",topicListBean.getTopicId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_topicxiao;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoadTTopic(LoadTopic loadTopic) {
        mCursor = loadTopic.getCursor();
        mMyLoadTopicAdapter.setData(loadTopic.getTopicList());
    }

    @Override
    protected LoadTopicPresenter<LoadTopicCon.LoadTopicV> createPresenter() {
        return new LoadTopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @OnClick(R.id.iv_publish)
    public void onViewClicked() {

    }

    @Override
    public void onRefresh() {
        mJsonLoadTopic.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLoadTopic.setType("0");
        mJsonLoadTopic.setCursor("0");
        mJsonLoadTopic.setTagId("0");
        mPresenter.getLoadTopic(new Gson().toJson(mJsonLoadTopic));
        mXrlvTopic.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        mJsonLoadTopic.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLoadTopic.setType("0");
        mJsonLoadTopic.setCursor(mCursor);
        mJsonLoadTopic.setTagId("0");
        mPresenter.getLoadTopic(new Gson().toJson(mJsonLoadTopic));
        mXrlvTopic.loadMoreComplete();
    }
}
