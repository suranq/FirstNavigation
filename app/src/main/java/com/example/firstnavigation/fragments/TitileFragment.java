package com.example.firstnavigation.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyInformationAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.contact.DownListCon;
import com.example.firstnavigation.json.JsonDwonList;
import com.example.firstnavigation.presenter.DownListPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitileFragment extends BaseFragment<DownListCon.DownListConV, DownListPresenter<DownListCon.DownListConV>> implements DownListCon.DownListConV, XRecyclerView.LoadingListener {


    @BindView(R.id.xrlv_title)
    XRecyclerView mXrlvTitle;
    @BindView(R.id.frame)
    FrameLayout mFrame;
    Unbinder unbinder;
    private String mChannelId;

    private List<DownList.NewListBean> mData = new ArrayList<>();
    private MyInformationAdapter mMyInformationAdapter;
    private DownList mDownList;
    private JsonDwonList mJsonDwonList;

    public TitileFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public TitileFragment(String channelId) {
        mChannelId = channelId;
    }


    @Override
    protected void initData() {
        mXrlvTitle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mXrlvTitle.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        mMyInformationAdapter = new MyInformationAdapter(mData,getContext());
        mXrlvTitle.setAdapter(mMyInformationAdapter);
        mXrlvTitle.setLoadingListener(this);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_titile;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void load() {
        mJsonDwonList = new JsonDwonList();
        mJsonDwonList.setChannelId(mChannelId);
        mJsonDwonList.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonDwonList.setCursor("0");
        String toJson = new Gson().toJson(mJsonDwonList);
        mPresenter.getDownList(toJson);
        super.load();
    }

    @Override
    public void showDownList(DownList downList) {
        Log.e("zzzzzzz", downList.getNewList().get(0).getTitle());
        mDownList = downList;
        mMyInformationAdapter.setData(downList.getNewList());
    }

    @Override
    protected DownListPresenter<DownListCon.DownListConV> createPresenter() {
        return new DownListPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mFrame;
    }

    @Override
    public void onRefresh() {
        mJsonDwonList.setChannelId(mChannelId);
        mJsonDwonList.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonDwonList.setCursor("0");
        String toJson = new Gson().toJson(mJsonDwonList);
        mPresenter.getDownList(toJson);
        mXrlvTitle.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        mJsonDwonList.setChannelId(mChannelId);
        mJsonDwonList.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonDwonList.setCursor(mDownList.getCursor());
        String toJson = new Gson().toJson(mJsonDwonList);
        mPresenter.getDownList(toJson);
        mXrlvTitle.loadMoreComplete();
    }
}
