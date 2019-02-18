package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.firstnavigation.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WentiActivity extends AppCompatActivity {

    @BindView(R.id.bt)
    Button mBt;
    @BindView(R.id.tv_daan)
    WebView mTvDaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wenti);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String answer = intent.getStringExtra("answer");

        WebSettings settings = mTvDaan.getSettings();
        settings.setJavaScriptEnabled(true);
        mTvDaan.loadData(Html.fromHtml(answer).toString(), "text/html", "UTF-8");
    }

    @OnClick(R.id.bt)
    public void onViewClicked() {
        finish();
    }
}
