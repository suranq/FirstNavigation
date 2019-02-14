package com.example.firstnavigation.activitys.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.MyUserNewsAdapter;
import com.example.firstnavigation.adapters.user.MyUserTopicAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.UserNews;
import com.example.firstnavigation.beans.UserTopic;
import com.example.firstnavigation.contact.CollectCon;
import com.example.firstnavigation.presenter.CollectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CollectActivity extends BaseActivity<CollectCon.CollectV, CollectPresenter<CollectCon.CollectV>> implements CollectCon.CollectV {

    @BindView(R.id.iv_huan)
    ImageView mIvHuan;
    @BindView(R.id.tv_bianji)
    TextView mTvBianji;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rlv_wen)
    RecyclerView mRlvWen;
    @BindView(R.id.tv_figure)
    TextView mTvFigure;
    @BindView(R.id.shanchu)
    LinearLayout mShanchu;
    @BindView(R.id.wenzhang)
    LinearLayout mWenzhang;
    @BindView(R.id.rlv_hua)
    RecyclerView mRlvHua;
    @BindView(R.id.huati)
    LinearLayout mHuati;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    private List<UserNews.FavouritNewsListBean> mData = new ArrayList<>();
    private MyUserNewsAdapter mMyUserNewsAdapter;
    private boolean isShow;
    private List<UserTopic.FavouritTopicListBean> mData1 = new ArrayList<>();
    private MyUserTopicAdapter mMyUserTopicAdapter;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mPresenter.getUserNews("efe7538b97f14d11952f5a13e1c7f7cd", "0");

        mRlvWen.setLayoutManager(new LinearLayoutManager(CollectActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyUserNewsAdapter = new MyUserNewsAdapter(mData, CollectActivity.this);
        mRlvWen.setAdapter(mMyUserNewsAdapter);

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_collect;
    }

    @Override
    protected CollectPresenter<CollectCon.CollectV> createPresenter() {
        return new CollectPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showUserNews(UserNews userNews) {
        mMyUserNewsAdapter.setData(userNews.getFavouritNewsList());
        mMyUserNewsAdapter.setShow(isShow);
    }

    @Override
    public void showUserTopic(UserTopic userTopic) {
        Log.e("hhhhhhhhh", userTopic.getFavouritTopicList().get(0).getNickname());
        mRlvHua.setLayoutManager(new LinearLayoutManager(CollectActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyUserTopicAdapter = new MyUserTopicAdapter(userTopic.getFavouritTopicList(), CollectActivity.this);
        mRlvHua.setAdapter(mMyUserTopicAdapter);
    }

    @OnClick({R.id.iv_huan, R.id.tv_bianji, R.id.shanchu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_huan:
                if (mIvHuan.isSelected()) {
                    mIvHuan.setSelected(false);
                    mWenzhang.setVisibility(View.VISIBLE);
                    mHuati.setVisibility(View.GONE);
                } else {
                    mIvHuan.setSelected(true);
                    mWenzhang.setVisibility(View.GONE);
                    mHuati.setVisibility(View.VISIBLE);
                    mPresenter.getUserTopic("efe7538b97f14d11952f5a13e1c7f7cd", "0");
                }
                break;
            case R.id.tv_bianji:
                String string = mTvBianji.getText().toString();
                if (string.equals("编辑")) {
                    mTvBianji.setText("取消");
                    mMyUserNewsAdapter.setShow(true);
                    mMyUserNewsAdapter.notifyDataSetChanged();
                } else {
                    mTvBianji.setText("编辑");
                    mMyUserNewsAdapter.setShow(false);
                    mMyUserNewsAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.shanchu:
                break;
        }
    }

    @OnClick(R.id.iv_fan)
    public void onViewClicked() {
        finish();
    }
}
