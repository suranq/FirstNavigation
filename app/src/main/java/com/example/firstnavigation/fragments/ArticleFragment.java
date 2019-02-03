package com.example.firstnavigation.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyArticleAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.SearchBean;
import com.example.firstnavigation.contact.SearchCon;
import com.example.firstnavigation.json.JsonSearch;
import com.example.firstnavigation.presenter.SearchPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends BaseFragment<SearchCon.SearchConV, SearchPresenter<SearchCon.SearchConV>> implements SearchCon.SearchConV, XRecyclerView.LoadingListener {


    @BindView(R.id.xrlv_article)
    XRecyclerView mXrlvArticle;
    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    Unbinder unbinder;
    private String mKeyword;
    private MyArticleAdapter mMyArticleAdapter;
    private List<SearchBean.NewListBean> mData = new ArrayList<>();
    private JsonSearch mJsonSearch;
    private String mCursor;

    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public void load() {


    }

    @Override
    protected void initData() {
        mJsonSearch = new JsonSearch();
        mJsonSearch.setCursor("0");
        mJsonSearch.setKeyword(mKeyword);
        mPresenter.getSearch(new Gson().toJson(mJsonSearch));

        mXrlvArticle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mXrlvArticle.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        mMyArticleAdapter = new MyArticleAdapter(mData,getContext());
        mXrlvArticle.setAdapter(mMyArticleAdapter);

        mXrlvArticle.setLoadingListener(this);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_article;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showSearch(SearchBean searchBean) {
        mMyArticleAdapter.setData(searchBean.getNewList());
        mCursor = searchBean.getCursor();
    }

    @Override
    protected SearchPresenter<SearchCon.SearchConV> createPresenter() {
        return new SearchPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mFrameLayout;
    }

    public void setData(String data) {
        mKeyword = data;
    }

    @Override
    public void onRefresh() {
        mJsonSearch.setCursor("0");
        mJsonSearch.setKeyword(mKeyword);
        mPresenter.getSearch(new Gson().toJson(mJsonSearch));
        mXrlvArticle.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        mJsonSearch.setCursor(mCursor);
        mJsonSearch.setKeyword(mKeyword);
        mPresenter.getSearch(new Gson().toJson(mJsonSearch));
        mXrlvArticle.loadMoreComplete();
    }
}
