package com.example.firstnavigation.fragments.topic;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.topic.ParticularsTopicActivity;
import com.example.firstnavigation.activitys.topic.PublishActivity;
import com.example.firstnavigation.adapters.topic.MyLoadTopicAdapter;
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
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicxiaoFragment extends BaseFragment<LoadTopicCon.LoadTopicV, LoadTopicPresenter<LoadTopicCon.LoadTopicV>> implements LoadTopicCon.LoadTopicV, XRecyclerView.LoadingListener, PublishActivity.OnItemListener {


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
    protected void initData() {

        mJsonLoadTopic = new JsonLoadTopic();
        mJsonLoadTopic.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLoadTopic.setType("0");
        mJsonLoadTopic.setCursor("0");
        mJsonLoadTopic.setTagId("0");
        mPresenter.getLoadTopic(new Gson().toJson(mJsonLoadTopic));

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

        PublishActivity.setOnItemListener(this);

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
        Intent intent = new Intent(getContext(), PublishActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        mJsonLoadTopic.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLoadTopic.setType("0");
        mJsonLoadTopic.setCursor(mCursor);
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

    @Override
    public void OnItemListener() {
        mJsonLoadTopic.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLoadTopic.setType("0");
        mJsonLoadTopic.setCursor(mCursor);
        mJsonLoadTopic.setTagId("0");
        mPresenter.getLoadTopic(new Gson().toJson(mJsonLoadTopic));
        mXrlvTopic.setAdapter(mMyLoadTopicAdapter);
    }
}
