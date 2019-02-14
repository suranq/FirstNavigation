package com.example.firstnavigation.fragments.topic;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.topic.MyTopicAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.Topic;
import com.example.firstnavigation.contact.TopicCon;
import com.example.firstnavigation.json.JsonSearch;
import com.example.firstnavigation.presenter.TopicPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HuatiFragment extends BaseFragment<TopicCon.TopicV, TopicPresenter<TopicCon.TopicV>> implements TopicCon.TopicV {


    @BindView(R.id.xrlv_huati)
    XRecyclerView mXrlvHuati;
    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    Unbinder unbinder;
    private String mKeyword;

    private List<Topic.TopicListBean> mData = new ArrayList<>();
    private MyTopicAdapter mMyTopicAdapter;

    public HuatiFragment() {
        // Required empty public constructor
    }

    @Override
    public void load() {

        JsonSearch jsonSearch = new JsonSearch();
        jsonSearch.setCursor("0");
        jsonSearch.setKeyword(mKeyword);
        mPresenter.getShowTopic(new Gson().toJson(jsonSearch));

    }

    @Override
    protected void initData() {

        mXrlvHuati.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mXrlvHuati.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        mMyTopicAdapter = new MyTopicAdapter(mData,getContext());

    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_huati;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showTopic(Topic topic) {

        mMyTopicAdapter.setData(topic.getTopicList());
    }

    @Override
    protected TopicPresenter<TopicCon.TopicV> createPresenter() {
        return new TopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mFrameLayout;
    }

    public void setKeyword(String keyword) {
        mKeyword = keyword;
    }
}
