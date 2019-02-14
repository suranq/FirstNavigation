package com.example.firstnavigation.activitys.topic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.topic.MyTopicImageAdapter;
import com.example.firstnavigation.adapters.user.MyDiscussAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.Favourite;
import com.example.firstnavigation.beans.Follow;
import com.example.firstnavigation.beans.InfoTopic;
import com.example.firstnavigation.beans.Like;
import com.example.firstnavigation.beans.ListComment;
import com.example.firstnavigation.beans.TopicComment;
import com.example.firstnavigation.contact.InfoTopicCon;
import com.example.firstnavigation.json.JsonFavourite;
import com.example.firstnavigation.json.JsonFollow;
import com.example.firstnavigation.json.JsonLike;
import com.example.firstnavigation.json.JsonListComment;
import com.example.firstnavigation.json.JsonTopicComment;
import com.example.firstnavigation.presenter.InfoTopicPresenter;
import com.example.firstnavigation.utils.TimeUtils;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ParticularsTopicActivity extends BaseActivity<InfoTopicCon.InfoTopicV, InfoTopicPresenter<InfoTopicCon.InfoTopicV>> implements InfoTopicCon.InfoTopicV {

    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.iv_menu)
    ImageView mIvMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_user_head)
    ImageView mIvUserHead;
    @BindView(R.id.tv_userName)
    TextView mTvUserName;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rlv_iamge)
    RecyclerView mRlvIamge;
    @BindView(R.id.tv_like)
    TextView mTvLike;
    @BindView(R.id.iv_like)
    ImageView mIvLike;
    @BindView(R.id.tv_strip)
    TextView mTvStrip;
    @BindView(R.id.rlv_discuss)
    RecyclerView mRlvDiscuss;
    @BindView(R.id.fenxiang)
    LinearLayout mFenxiang;
    @BindView(R.id.pinglun)
    LinearLayout mPinglun;
    @BindView(R.id.shoucang)
    LinearLayout mShoucang;
    @BindView(R.id.ivShoucang)
    ImageView mIvShoucang;
    @BindView(R.id.bt_guanzhu)
    Button mBtGuanzhu;

    private InfoTopic mInfoTopic;
    private MyTopicImageAdapter mMyTopicImageAdapter;
    private List<String> mImageListThumb;
    private MyDiscussAdapter mMyDiscussAdapter;
    private String mTopicId;
    private String mTopicId1;
    private JsonListComment mJsonListComment;
    private JsonFavourite mJsonFavourite;
    private String mUserId;
    private JsonFollow mJsonFollow;
    private JsonLike mJsonLike;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mTopicId1 = intent.getStringExtra("topicId");

        getinfo();
        mJsonFollow = new JsonFollow();
        mJsonLike = new JsonLike();
        mJsonListComment = new JsonListComment();
        getComment();

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        mJsonFavourite = new JsonFavourite();
    }

    private void getComment() {
        mJsonListComment.setCursor(0);
        mJsonListComment.setObjectId(mTopicId1);
        mJsonListComment.setObjectType("1");
        mPresenter.getListComment(new Gson().toJson(mJsonListComment));
    }

    private void getinfo() {
        mPresenter.getInfoTopic(mTopicId1, "efe7538b97f14d11952f5a13e1c7f7cd");
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_particulars_topic;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected InfoTopicPresenter<InfoTopicCon.InfoTopicV> createPresenter() {
        return new InfoTopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showInfoTopic(InfoTopic infoTopic) {
        mInfoTopic = infoTopic;
        mImageListThumb = infoTopic.getImageListThumb();

        mTopicId = infoTopic.getTopicId();
        mUserId = infoTopic.getUserId();

        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(ParticularsTopicActivity.this).load(mInfoTopic.getHeadImagePath()).apply(requestOptions).into(mIvUserHead);
        mTvUserName.setText(mInfoTopic.getNickname());
        mTvTime.setText(TimeUtils.getDifference(mInfoTopic.getPublishTime()));
        mTvTitle.setText(mInfoTopic.getTitle());
        mTvStrip.setText("热门评论" + infoTopic.getComments() + "条");
        mTvLike.setText(infoTopic.getLikes()+"");
        Log.e("dianzanzan",infoTopic.getIsLiked()+"");

        if (infoTopic.getIsLiked() == 0) {
            mIvLike.setSelected(false);
        } else {
            mIvLike.setSelected(true);
        }
        if (infoTopic.getIsFavoured() == 0) {
            mIvShoucang.setSelected(false);
        } else {
            mIvShoucang.setSelected(true);
        }

        if (infoTopic.getIsFollowed() == 0) {
            mBtGuanzhu.setText("关注");
        } else {
            mBtGuanzhu.setText("已关注");
        }

        mRlvIamge.setLayoutManager(new GridLayoutManager(ParticularsTopicActivity.this, 3));
        mMyTopicImageAdapter = new MyTopicImageAdapter(mImageListThumb, ParticularsTopicActivity.this);
        mRlvIamge.setAdapter(mMyTopicImageAdapter);
    }

    @Override
    public void showListComment(ListComment listComment) {
        mRlvDiscuss.setLayoutManager(new LinearLayoutManager(ParticularsTopicActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyDiscussAdapter = new MyDiscussAdapter(listComment.getCommentList(), ParticularsTopicActivity.this);
        mRlvDiscuss.setAdapter(mMyDiscussAdapter);
    }

    @Override
    public void showTopicComment(TopicComment topicComment) {

    }

    @Override
    public void showFavourite(Favourite favourite) {

    }

    @Override
    public void showFollow(Follow follow) {

    }

    @Override
    public void showLike(Like like) {
        Log.e("dddddd",like.getMessage());
    }

    @OnClick({R.id.iv_menu, R.id.tv_like, R.id.iv_like, R.id.fenxiang, R.id.pinglun, R.id.ivShoucang, R.id.bt_guanzhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_menu:
                break;
            case R.id.tv_like:
                break;
            case R.id.iv_like:
                if (mIvLike.isSelected()){
                    mIvLike.setSelected(false);
                    quxiaozan();
                }else {
                    mIvLike.setSelected(true);
                    dianzan();
                }
                break;
            case R.id.fenxiang:
                break;
            case R.id.pinglun:
                showPinglun();
                break;
            case R.id.ivShoucang:
                if (mIvShoucang.isSelected()) {
                    mIvShoucang.setSelected(false);
                    quxiaoshoucang();
                } else {
                    mIvShoucang.setSelected(true);
                    shoucang();
                }
                break;
            case R.id.bt_guanzhu:
                String string = mBtGuanzhu.getText().toString();
                if (string.equals("关注")) {
                    mBtGuanzhu.setText("已关注");
                    guanzhu();
                } else {
                    mBtGuanzhu.setText("关注");
                    quxiao();
                }
                break;
        }
    }

    private void quxiaozan() {
        mJsonLike.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLike.setObjectId(mTopicId);
        mJsonLike.setObjectType("1");
        mJsonLike.setType("1");
        mPresenter.getLike(new Gson().toJson(mJsonLike));
        getinfo();
        mMyTopicImageAdapter.notifyDataSetChanged();
    }

    private void dianzan() {
        mJsonLike.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonLike.setObjectId(mTopicId);
        mJsonLike.setObjectType("1");
        mJsonLike.setType("0");
        mPresenter.getLike(new Gson().toJson(mJsonLike));
        getinfo();
        mMyTopicImageAdapter.notifyDataSetChanged();
    }

    private void quxiao() {
        mJsonFollow.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonFollow.setFollowUid(mUserId);
        mJsonFollow.setType("1");
        mPresenter.getFollow(new Gson().toJson(mJsonFollow));
    }

    private void guanzhu() {
        mJsonFollow.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonFollow.setFollowUid(mUserId);
        mJsonFollow.setType("0");
        mPresenter.getFollow(new Gson().toJson(mJsonFollow));
    }

    private void quxiaoshoucang() {
        mJsonFavourite.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonFavourite.setObjectId(mTopicId);
        mJsonFavourite.setObjectType("1");
        mJsonFavourite.setType("1");
        mPresenter.getFavourite(new Gson().toJson(mJsonFavourite));
    }

    private void shoucang() {
        mJsonFavourite.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
        mJsonFavourite.setObjectId(mTopicId);
        mJsonFavourite.setObjectType("1");
        mJsonFavourite.setType("0");
        mPresenter.getFavourite(new Gson().toJson(mJsonFavourite));
    }

    private void showPinglun() {
        View inflate = LayoutInflater.from(ParticularsTopicActivity.this).inflate(R.layout.pop_comment, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        mLinear.setBackgroundColor(0xC4BDB6B6);
        popupWindow.showAtLocation(mPinglun, Gravity.BOTTOM, 0, 0);

        final EditText edComment = inflate.findViewById(R.id.ed_comment);
        TextView tvfabu = inflate.findViewById(R.id.tv_fabu);
        TextView tvquxiao = inflate.findViewById(R.id.tv_quxiao);

        tvfabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edComment.getText().toString();
                JsonTopicComment jsonTopicComment = new JsonTopicComment();
                jsonTopicComment.setUserId("efe7538b97f14d11952f5a13e1c7f7cd");
                jsonTopicComment.setContent(string);
                jsonTopicComment.setObjectId(mTopicId);
                jsonTopicComment.setObjectType("1");
                mPresenter.getTopicComment(new Gson().toJson(jsonTopicComment));
                getComment();
                mMyDiscussAdapter.notifyDataSetChanged();
                mLinear.setBackgroundColor(0xFFFFFFFF);
                popupWindow.dismiss();

            }
        });

        tvquxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinear.setBackgroundColor(0xFFFFFFFF);
                popupWindow.dismiss();
            }
        });
    }
}
