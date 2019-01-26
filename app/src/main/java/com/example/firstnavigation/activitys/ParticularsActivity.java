package com.example.firstnavigation.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.beans.Info;
import com.example.firstnavigation.beans.RelevantNews;
import com.example.firstnavigation.contactCon.InfoCon;
import com.example.firstnavigation.json.JsonCommentList;
import com.example.firstnavigation.presenter.InfoPresenter;
import com.google.gson.Gson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.OnClick;

public class ParticularsActivity extends BaseActivity<InfoCon.InfoConV, InfoPresenter<InfoCon.InfoConV>> implements InfoCon.InfoConV {

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
    public static LinearLayout mParticulars;
    public static String mNewsId;

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
        mParticulars = findViewById(R.id.particulars);
        Intent intent = getIntent();
        mNewsId = intent.getStringExtra("newsId");
        mPresenter.getInfo("efe7538b97f14d11952f5a13e1c7f7cd", mNewsId);
        Log.e("nnnnnnn",mNewsId);
        mPresenter.getRelevantNews(mNewsId);

        JsonCommentList commentList = new JsonCommentList();
        commentList.setCursor(0);
        commentList.setObjectId(mNewsId);
        commentList.setObjectType("0");
        mPresenter.getCommentList(new Gson().toJson(commentList));
        Log.e("jjjjjjsonjjjosn",new Gson().toJson(commentList));

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
        Log.e("ccccccccc",error);
    }

    @Override
    public void showInfo(Info info) {
        mInfo = info;
        mTvTitle.setText(mInfo.getTitle());
        mTvTime.setText(mInfo.getPublishTime());
        mTvSource.setText("阿鑫之家");
        String newsId = mInfo.getNewsId();

        WebSettings settings = mWv.getSettings();
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);//支持js
        mWv.setWebViewClient(new MyWebViewClient());
//        mWv.addJavascriptInterface(new JavaScriptInterface(this), "imagelistner");//这个是给图片设置点击监听的，如果你项目需要webview中图片，点击查看大图功能，可以这么添加

//        String newContent = getNewContent(mInfo.getContent());
        mWv.loadDataWithBaseURL(null,info.getContent(),"text/html", "utf-8",null);
        mWv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小
            // html加载完成之后，添加监听图片的点击js函数
            addImageClickListner();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    /**
     * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
     **/
    private void imgReset() {
        mWv.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");
    }

    private void addImageClickListner() {
        // 这段js函数的功能就是，遍历所有的img节点，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
        mWv.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName(\"img\"); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "    objs[i].onclick=function()  " +
                "    {  "
                + "        window.imagelistner.openImage(this.src);  " +
                "    }  " +
                "}" +
                "})()");
    }

    @Override
    public void showRelevantNews(RelevantNews relevantNews) {
        Log.e("xxxxxxxxx",relevantNews.getTitle());
    }

    @Override
    public void showCommentList(CommentList commentList) {
        Log.e("ppppppppppppppp",commentList.getCommentList().get(0).getNickname().toString());
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
                if (mIvNewsLike.isSelected()){
                    mIvNewsLike.setSelected(false);
                }else {
                    mIvNewsLike.setSelected(true);
                }
                break;
            case R.id.iv_share:
                break;
        }
    }

    @OnClick(R.id.iv_menu)
    public void onViewClicked() {
    }
}
