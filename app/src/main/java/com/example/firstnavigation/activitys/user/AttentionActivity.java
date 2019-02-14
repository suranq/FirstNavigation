package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyListFollowAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.ListFollow;
import com.example.firstnavigation.contact.ListFollowCon;
import com.example.firstnavigation.presenter.ListFollowPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AttentionActivity extends BaseActivity<ListFollowCon.ListFollowV, ListFollowPresenter<ListFollowCon.ListFollowV>> implements ListFollowCon.ListFollowV {

    @BindView(R.id.ivfan)
    ImageView mIvfan;
    @BindView(R.id.tv_bianji)
    TextView mTvBianji;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.gengduo)
    LinearLayout mGengduo;
    @BindView(R.id.rlv_attention)
    RecyclerView mRlvAttention;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    private MyListFollowAdapter mMyListFollowAdapter;
    private List<ListFollow.FollowListBean> mData = new ArrayList<>();

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mPresenter.getListFollow("efe7538b97f14d11952f5a13e1c7f7cd");
        mRlvAttention.setLayoutManager(new LinearLayoutManager(AttentionActivity.this,LinearLayoutManager.VERTICAL,false));
        mMyListFollowAdapter = new MyListFollowAdapter(mData,AttentionActivity.this);
        mRlvAttention.setAdapter(mMyListFollowAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_attention;
    }

    @Override
    protected ListFollowPresenter<ListFollowCon.ListFollowV> createPresenter() {
        return new ListFollowPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showListFollow(ListFollow listFollow) {
        mMyListFollowAdapter.setData(listFollow.getFollowList());
    }

    @OnClick({R.id.ivfan, R.id.gengduo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivfan:
                finish();
                break;
            case R.id.gengduo:
                startActivity(new Intent(AttentionActivity.this,MoreActivity.class));
                break;
        }
    }
}
