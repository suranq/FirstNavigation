package com.example.firstnavigation.fragments.information;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.information.ParticularsActivity;
import com.example.firstnavigation.adapters.information.MyInformationAdapter;
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

        mMyInformationAdapter.setOnItemListener(new MyInformationAdapter.OnItemListener() {
            @Override
            public void OnItemListener(DownList.NewListBean newListBean) {
                Intent intent = new Intent(getContext(), ParticularsActivity.class);
                intent.putExtra("newsId",newListBean.getNewsId());
                startActivity(intent);
            }
        });
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
    }

    @Override
    public void showDownList(DownList downList) {
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
