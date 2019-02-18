package com.example.firstnavigation.fragments.user;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.topic.MyTopicActivity;
import com.example.firstnavigation.activitys.user.AttentionActivity;
import com.example.firstnavigation.activitys.user.CollectActivity;
import com.example.firstnavigation.activitys.user.FeedbackActivity;
import com.example.firstnavigation.activitys.user.InformActivity;
import com.example.firstnavigation.activitys.user.ListCommentActivity;
import com.example.firstnavigation.activitys.user.ModificationActivity;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.Center;
import com.example.firstnavigation.contact.CenterCon;
import com.example.firstnavigation.presenter.CenterPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment<CenterCon.CenterConV, CenterPresenter<CenterCon.CenterConV>> implements CenterCon.CenterConV {


    @BindView(R.id.iv_user_head)
    ImageView mIvUserHead;
    @BindView(R.id.tv_userName)
    TextView mTvUserName;
    @BindView(R.id.tv_xinxi)
    TextView mTvXinxi;
    @BindView(R.id.tv_shou)
    TextView mTvShou;
    @BindView(R.id.tv_lishi)
    TextView mTvLishi;
    @BindView(R.id.tv_guanzhu)
    TextView mTvGuanzhu;
    @BindView(R.id.tv_gentie)
    TextView mTvGentie;
    @BindView(R.id.xiaoxi)
    LinearLayout mXiaoxi;
    @BindView(R.id.fabiao)
    LinearLayout mFabiao;
    @BindView(R.id.fankui)
    LinearLayout mFankui;
    @BindView(R.id.shezhi)
    LinearLayout mShezhi;
    Unbinder unbinder;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    Unbinder unbinder1;
    @BindView(R.id.xinxi)
    LinearLayout mXinxi;
    Unbinder unbinder2;
    private String mHeadImagePath;
    private String mNickname;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initData() {
        mPresenter.getCenterCon("efe7538b97f14d11952f5a13e1c7f7cd");

    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showCenterCon(Center center) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(getContext()).load(center.getHeadImagePath()).apply(requestOptions).into(mIvUserHead);
        mTvUserName.setText(center.getNickname());

        if (mTvUserName.getText() != null) {
            mTvXinxi.setText(R.string.xinxi);
        } else {
            mTvXinxi.setText(R.string.denglu);
        }

        mTvShou.setText(center.getFavorites() + "");
        mTvLishi.setText(center.getHistoryReads() + "");
        mTvGuanzhu.setText(center.getFollowing() + "");
        mTvGentie.setText(center.getComments() + "");

        mHeadImagePath = center.getHeadImagePath();
        mNickname = center.getNickname();

    }

    @Override
    protected CenterPresenter<CenterCon.CenterConV> createPresenter() {
        return new CenterPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @OnClick({R.id.tv_shou, R.id.tv_lishi, R.id.tv_guanzhu, R.id.tv_gentie, R.id.xiaoxi, R.id.fabiao, R.id.fankui, R.id.shezhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_shou:
                startActivity(new Intent(getContext(), CollectActivity.class));
                break;
            case R.id.tv_lishi:
                break;
            case R.id.tv_guanzhu:
                startActivity(new Intent(getContext(), AttentionActivity.class));
                break;
            case R.id.tv_gentie:
                Intent intent = new Intent(getContext(), ListCommentActivity.class);
                intent.putExtra("HeadImagePath",mHeadImagePath);
                intent.putExtra("nickname",mNickname);
                startActivity(intent);
                break;
            case R.id.xiaoxi:
                startActivity(new Intent(getContext(), InformActivity.class));
                break;
            case R.id.fabiao:
                startActivity(new Intent(getContext(), MyTopicActivity.class));
                break;
            case R.id.fankui:
                startActivity(new Intent(getContext(), FeedbackActivity.class));
                break;
            case R.id.shezhi:
                startActivity(new Intent(getContext(), ModificationActivity.class));
                break;
        }
    }

    @OnClick(R.id.xinxi)
    public void onViewClicked() {
    }
}
