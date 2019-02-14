package com.example.firstnavigation.activitys.information;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.adapters.MyHotAdapter;
import com.example.firstnavigation.adapters.MySearchAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.Hot;
import com.example.firstnavigation.contact.HotCon;
import com.example.firstnavigation.fragments.ArticleFragment;
import com.example.firstnavigation.fragments.topic.HuatiFragment;
import com.example.firstnavigation.presenter.HotPresenter;
import com.example.firstnavigation.shujukuBeans.Search;
import com.example.firstnavigation.shujukuBeans.SearchHelep;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<HotCon.HotConV, HotPresenter<HotCon.HotConV>> implements HotCon.HotConV {

    @BindView(R.id.search_edit)
    EditText mSearchEdit;
    @BindView(R.id.search_text_quxiao)
    TextView mSearchTextQuxiao;
    @BindView(R.id.search_qingkong)
    TextView mSearchQingkong;
    @BindView(R.id.search_toolbar)
    Toolbar mSearchToolbar;
    @BindView(R.id.tv_eliminate)
    TextView mTvEliminate;
    @BindView(R.id.rlv_history)
    RecyclerView mRlvHistory;
    @BindView(R.id.rlv_hot)
    RecyclerView mRlvHot;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.lin_article)
    LinearLayout mLinArticle;
    @BindView(R.id.id_wenzhang)
    LinearLayout mIdWenzhang;

    private List<Hot.SearchListBean> mData = new ArrayList<>();
    private MyHotAdapter mMyHotAdapter;
    private MySearchAdapter mMySearchAdapter;
    private ArticleFragment mArticleFragment;
    private HuatiFragment mHuatiFragment;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }

    @Override
    protected void initData() {
        mPresenter.getHeadImage("");

        mRlvHot.setLayoutManager(new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false));
        mRlvHot.addItemDecoration(new DividerItemDecoration(SearchActivity.this, DividerItemDecoration.VERTICAL));

        mMyHotAdapter = new MyHotAdapter(mData, SearchActivity.this);
        mRlvHot.setAdapter(mMyHotAdapter);

        mMyHotAdapter.setOnItemListener(new MyHotAdapter.OnItemListener() {
            @Override
            public void OnItemListener(Hot.SearchListBean searchListBean) {
                mSearchEdit.setText(searchListBean.getContent());
            }
        });

        mSearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getSearch();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRlvHistory.setLayoutManager(new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false));
        mRlvHistory.addItemDecoration(new DividerItemDecoration(SearchActivity.this, DividerItemDecoration.VERTICAL));

        List<Search> searches = SearchHelep.getSearchHelep().selectAll();
        if (searches.size() > 0 && searches != null) {
            mMySearchAdapter = new MySearchAdapter(searches, SearchActivity.this);
            mRlvHistory.setAdapter(mMySearchAdapter);
        }

        mTab.addTab(mTab.newTab().setText("文章"));
        mTab.addTab(mTab.newTab().setText("话题"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        ArrayList<Fragment> fragments = new ArrayList<>();
        mArticleFragment = new ArticleFragment();
        mHuatiFragment = new HuatiFragment();
        fragments.add(mArticleFragment);
        fragments.add(mHuatiFragment);
        mVp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected HotPresenter<HotCon.HotConV> createPresenter() {
        return new HotPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @OnClick({R.id.search_text_quxiao, R.id.search_qingkong, R.id.tv_eliminate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_text_quxiao:
                String string = mSearchEdit.getText().toString();
                if (string.length() > 0 && string != null) {
                    SearchHelep.getSearchHelep().insert(new Search(null, string));
                    mLinArticle.setVisibility(View.VISIBLE);
                    mIdWenzhang.setVisibility(View.GONE);
                    mArticleFragment.setData(string);
                    mHuatiFragment.setKeyword(string);
                }else {
                    mLinArticle.setVisibility(View.GONE);
                    mIdWenzhang.setVisibility(View.VISIBLE);
                }
                if (string.equals("取消")){
                    mLinArticle.setVisibility(View.GONE);
                    mIdWenzhang.setVisibility(View.VISIBLE);
                    mMySearchAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.search_qingkong:
                mSearchEdit.setText("");
                break;
            case R.id.tv_eliminate:
                List<Search> searches = SearchHelep.getSearchHelep().selectAll();
                if (searches != null && searches.size() > 0) {
                    SearchHelep.getSearchHelep().delectAll();
                    List<Search> searches1 = SearchHelep.getSearchHelep().selectAll();
                    mMySearchAdapter = new MySearchAdapter(searches1, SearchActivity.this);
                    mRlvHistory.setAdapter(mMySearchAdapter);
                }
                break;
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showListNews(Hot hot) {
        mMyHotAdapter.setData(hot.getSearchList());

    }

    public void getSearch() {
        if (mSearchEdit.getText() != null && mSearchEdit.getText().length() > 0) {
            mSearchQingkong.setVisibility(View.VISIBLE);
            mSearchTextQuxiao.setText("搜索");
        } else {
            mSearchQingkong.setVisibility(View.GONE);
            mSearchTextQuxiao.setText("取消");
        }
    }
}
