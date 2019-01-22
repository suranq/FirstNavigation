package com.example.firstnavigation.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.contact.DownListCon;
import com.example.firstnavigation.contact.ListNewsCon;
import com.example.firstnavigation.json.JsonDwonList;
import com.example.firstnavigation.presenter.DownListPresenter;
import com.example.firstnavigation.presenter.ListNewsPresenter;
import com.google.gson.Gson;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends BaseFragment<ListNewsCon.ListNewsConV, ListNewsPresenter<ListNewsCon.ListNewsConV>> implements ListNewsCon.ListNewsConV {

    Unbinder unbinder;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.fubuju)
    LinearLayout mFubuju;
    Unbinder unbinder1;
    private String mChannelId;

    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initData() {
        mPresenter.getListNews("");
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_information;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected ListNewsPresenter<ListNewsCon.ListNewsConV> createPresenter() {
        return new ListNewsPresenter<>();
    }

    @Override
    public void load() {

    }

    @Override
    protected View getActivityID() {
        return mFubuju;
    }

    @Override
    public void showListNews(ListNews listNews) {
        Log.e("ffffff",listNews.getNewsChannelList().get(0).getChannelName());
        List<ListNews.NewsChannelListBean> newsChannelList = listNews.getNewsChannelList();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < newsChannelList.size(); i++) {
            mTab.addTab(mTab.newTab().setText(newsChannelList.get(i).getChannelName()));
            fragments.add(new TitileFragment(newsChannelList.get(i).getChannelId()));
        }
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
        mVp.setAdapter(new MyFragmentAdapter(getChildFragmentManager(),fragments));
    }
}
