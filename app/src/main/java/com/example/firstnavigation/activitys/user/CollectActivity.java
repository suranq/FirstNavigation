package com.example.firstnavigation.activitys.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import butterknife.ButterKnife;
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
    @BindView(R.id.tv_one)
    TextView mTvOne;
    @BindView(R.id.tv_two)
    TextView mTvTwo;
    private List<UserNews.FavouritNewsListBean> mData = new ArrayList<>();
    private MyUserNewsAdapter mMyUserNewsAdapter;
    private boolean isShow;
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
        mPresenter.getUserTopic("efe7538b97f14d11952f5a13e1c7f7cd", "0");
        mRlvWen.setLayoutManager(new LinearLayoutManager(CollectActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyUserNewsAdapter = new MyUserNewsAdapter(mData, CollectActivity.this);
        mRlvWen.setAdapter(mMyUserNewsAdapter);

        mMyUserNewsAdapter.setOnItemListener(new MyUserNewsAdapter.OnItemListener() {
            @Override
            public void OnItemListener(int size) {
                mTvFigure.setText("(" + size + ")");
            }
        });

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
        mData = userNews.getFavouritNewsList();
        mMyUserNewsAdapter.setData(userNews.getFavouritNewsList());
        mMyUserNewsAdapter.setShow(isShow);
    }

    @Override
    public void showUserTopic(UserTopic userTopic) {
        mRlvHua.setLayoutManager(new LinearLayoutManager(CollectActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyUserTopicAdapter = new MyUserTopicAdapter(userTopic.getFavouritTopicList(), CollectActivity.this);
        mRlvHua.setAdapter(mMyUserTopicAdapter);
    }

    @OnClick({R.id.tv_bianji, R.id.shanchu, R.id.tv_one, R.id.tv_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                mIvHuan.setSelected(false);
                mWenzhang.setVisibility(View.VISIBLE);
                mHuati.setVisibility(View.GONE);
                break;
            case R.id.tv_two:
                mIvHuan.setSelected(true);
                mWenzhang.setVisibility(View.GONE);
                mHuati.setVisibility(View.VISIBLE);
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
                List<UserNews.FavouritNewsListBean> mSize = MyUserNewsAdapter.mSize;
                for (int i = 0; i < mSize.size(); i++) {
                    UserNews.FavouritNewsListBean favouritNewsListBean = mSize.get(i);
                    mData.remove(favouritNewsListBean);
                    mMyUserNewsAdapter.setData(mData);
                }
                mSize.clear();
                mTvFigure.setText("");
                mMyUserNewsAdapter.notifyDataSetChanged();
                break;
        }
    }

    @OnClick(R.id.iv_fan)
    public void onViewClicked() {
        finish();
    }
}
