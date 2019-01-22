package com.example.firstnavigation.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.contact.InfoCon;
import com.example.firstnavigation.presenter.InfoPresenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ParticularsActivity extends BaseActivity<InfoCon.InfoConV, InfoPresenter<InfoCon.InfoConV>> implements InfoCon.InfoConV {

    @BindView(R.id.particulars)
    ScrollView mParticulars;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_source)
    TextView mTvSource;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.iv_collect)
    ImageView mIvCollect;
    @BindView(R.id.wv)
    WebView mWv;
    @BindView(R.id.iv_major)
    ImageView mIvMajor;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.rlv_similarity)
    RecyclerView mRlvSimilarity;
    @BindView(R.id.rlv_follow)
    RecyclerView mRlvFollow;
    @BindView(R.id.iv_more)
    ImageView mIvMore;
    @BindView(R.id.iv_reply)
    ImageView mIvReply;
    @BindView(R.id.iv_huifu)
    ImageView mIvHuifu;
    @BindView(R.id.iv_newsLike)
    ImageView mIvNewsLike;
    @BindView(R.id.iv_share)
    ImageView mIvShare;
    @BindView(R.id.iv_menu)
    ImageView mIvMenu;
    private Info mInfo;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_particulars;
    }

    @Override
    protected void initEvenAndData() {
        Intent intent = getIntent();
        String newsId = intent.getStringExtra("newsId");
        mPresenter.getInfo("efe7538b97f14d11952f5a13e1c7f7cd", newsId);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        Glide.with(ParticularsActivity.this).load(R.drawable.meinv).into(mImage);


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
    protected InfoPresenter<InfoCon.InfoConV> createPresenter() {
        return new InfoPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mParticulars;
    }

    @Override
    public void showError(String error) {
        Log.e("cccccccc", error);
    }

    @Override
    public void showInfo(Info info) {
        mInfo = info;

        mTvTitle.setText(mInfo.getTitle());
        mTvTime.setText(mInfo.getPublishTime());
        mTvSource.setText("阿鑫之家");

        WebSettings settings = mWv.getSettings();
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLoadWithOverviewMode(true);
        String newContent = getNewContent(mInfo.getContent());
        mWv.loadDataWithBaseURL(null,newContent,"text/html", "utf-8",null);
        mWv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    public static String getNewContent(String htmltext){
        try {
            Document doc= Jsoup.parse(htmltext);
            Elements elements=doc.getElementsByTag("img");
            for (Element element : elements) {
                element.attr("width","100%").attr("height","auto");
            }
            return doc.toString();
        } catch (Exception e) {
            return htmltext;
        }
    }

    @OnClick({R.id.iv_collect, R.id.iv_major, R.id.iv_reply, R.id.iv_huifu, R.id.iv_newsLike, R.id.iv_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_collect:
                break;
            case R.id.iv_major:
                break;
            case R.id.iv_reply:
                break;
            case R.id.iv_huifu:
                break;
            case R.id.iv_newsLike:
                break;
            case R.id.iv_share:
                break;
        }
    }

    @OnClick(R.id.iv_menu)
    public void onViewClicked() {
    }
}
