package com.example.firstnavigation.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyPagerAdapter;
import com.example.firstnavigation.adapters.MyTagsHotAdapter;
import com.example.firstnavigation.adapters.user.MyMoreAttAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.contact.MoreFollowCon;
import com.example.firstnavigation.fragments.user.MoreFollowFragment;
import com.example.firstnavigation.json.JsonTags;
import com.example.firstnavigation.presenter.MoreFollowPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class MoreActivity extends BaseActivity<MoreFollowCon.MoreFollowV, MoreFollowPresenter<MoreFollowCon.MoreFollowV>> implements MoreFollowCon.MoreFollowV {

    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    @BindView(R.id.search_edit)
    EditText mSearchEdit;
    @BindView(R.id.search_text_quxiao)
    TextView mSearchTextQuxiao;
    @BindView(R.id.search_qingkong)
    TextView mSearchQingkong;
    @BindView(R.id.search_toolbar)
    Toolbar mSearchToolbar;
    @BindView(R.id.tab)
    VerticalTabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.rlv_shousuo)
    RecyclerView mRlvShousuo;
    @BindView(R.id.linearmore)
    LinearLayout mLinearmore;
    @BindView(R.id.linear_more)
    LinearLayout mLinearMore;
    private MyPagerAdapter mMyPagerAdapter;
    private String mString;
    private List<TagsSearch.TagListBean> mData = new ArrayList<>();
    private MyMoreAttAdapter mMyMoreAttAdapter;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mSearchToolbar.setTitle("");
        setSupportActionBar(mSearchToolbar);

        mPresenter.getTagsHot("");

        mSearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mString = mSearchEdit.getText().toString();
                if (mString != null && mString.length() > 0) {
                    JsonTags jsonTags = new JsonTags();
                    jsonTags.setKeyword(mString);
                    jsonTags.setCursor("0");
                    mPresenter.getTagsSearch(new Gson().toJson(jsonTags));
                } else {
                    mPresenter.getTagsHot("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                getbian();
            }
        });


        mRlvShousuo.setLayoutManager(new LinearLayoutManager(MoreActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyMoreAttAdapter = new MyMoreAttAdapter(mData,MoreActivity.this,mString);
        mRlvShousuo.setAdapter(mMyMoreAttAdapter);

        mMyMoreAttAdapter.setOnItemListener(new MyMoreAttAdapter.OnItemListener() {
            @Override
            public void OnItemListener(TagsSearch.TagListBean tag, int position) {
                Intent intent = new Intent(MoreActivity.this, MoreAttenActivity.class);
                intent.putExtra("id",tag.getId());
                intent.putExtra("tag",tag.getTag());
                startActivity(intent);
            }
        });
    }

    private void getbian() {
        if (mSearchEdit.getText().length() > 0) {
            mSearchTextQuxiao.setText("搜索");
            mRlvShousuo.setVisibility(View.VISIBLE);
            mLinearMore.setVisibility(View.GONE);
        } else {
            mSearchTextQuxiao.setText("取消");
            mRlvShousuo.setVisibility(View.GONE);
            mLinearMore.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_more;
    }

    @Override
    protected MoreFollowPresenter<MoreFollowCon.MoreFollowV> createPresenter() {
        return new MoreFollowPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinearmore;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showTagsHot(TagsHot tagsHot) {
        List<TagsHot.DataBean> data = tagsHot.getData();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            fragments.add(new MoreFollowFragment(data.get(i).getId()));
        }
        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), data, fragments);
        mVp.setAdapter(mMyPagerAdapter);
        mTab.setupWithViewPager(mVp);
    }

    @Override
    public void showMoreFollow(MoreFollow moreFollow) {

    }

    @Override
    public void showTagsSearch(TagsSearch tagsSearch) {
        mMyMoreAttAdapter.setData(tagsSearch.getTagList());
        mMyMoreAttAdapter.setString(mString);
        mMyMoreAttAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.iv_fan, R.id.search_text_quxiao, R.id.search_qingkong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_fan:
                finish();
                break;
            case R.id.search_text_quxiao:
                break;
            case R.id.search_qingkong:
                break;
        }
    }
}
