package com.example.firstnavigation.fragments.information;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.information.TitleActivity;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.ListNews;
import com.example.firstnavigation.contact.ListNewsCon;
import com.example.firstnavigation.presenter.ListNewsPresenter;
import com.example.firstnavigation.shujukuBeans.Information;
import com.example.firstnavigation.shujukuBeans.InformationHelep;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends BaseFragment<ListNewsCon.ListNewsConV, ListNewsPresenter<ListNewsCon.ListNewsConV>> implements ListNewsCon.ListNewsConV, TitleActivity.OnItemListener {

    Unbinder unbinder;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.fubuju)
    LinearLayout mFubuju;
    Unbinder unbinder1;
    @BindView(R.id.iv_add)
    ImageView mIvAdd;
    Unbinder unbinder2;
    private String mChannelId;
    private InformationHelep mInsh;
    private ArrayList<Fragment> mFragments;

    private List<Information> mInformations = new ArrayList<>();

    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initData() {
        mInsh = InformationHelep.getInsh();
        mFragments = new ArrayList<>();
        SharedPreferences informarion = getActivity().getSharedPreferences("informarion", 0);
        boolean isShow = informarion.getBoolean("isShow", false);
        if (isShow) {
            List<Information> information = mInsh.selectAll();
            for (int i = 0; i < information.size(); i++) {
                if (information.get(i).getIsShow()) {
                    mTab.addTab(mTab.newTab().setText(information.get(i).getTitle()));
                    mFragments.add(new TitileFragment(information.get(i).getChannelId()));
                }
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
            mVp.setAdapter(new MyFragmentAdapter(getChildFragmentManager(), mFragments));
        } else {
            mPresenter.getListNews("");
        }
        TitleActivity.setOnItemListener(this);
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
        List<ListNews.NewsChannelListBean> newsChannelList = listNews.getNewsChannelList();
        mTab.removeAllTabs();
        for (int i = 0; i < newsChannelList.size(); i++) {
            if (i < 12) {
                mInformations.add(new Information(null, newsChannelList.get(i).getChannelName(), newsChannelList.get(i).getChannelId(), true));
            } else {
                mInformations.add(new Information(null, newsChannelList.get(i).getChannelName(), newsChannelList.get(i).getChannelId(), false));
            }
        }
        mInsh.insert(mInformations);
        SharedPreferences informarion = getActivity().getSharedPreferences("informarion", 0);
        SharedPreferences.Editor edit = informarion.edit();
        edit.putBoolean("isShow", true);
        edit.commit();

        List<Information> information = mInsh.selectAll();
        for (Information item : information) {
            mTab.addTab(mTab.newTab().setText(item.getTitle()));
            mFragments.add(new TitileFragment(item.getChannelId()));
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
        mVp.setAdapter(new MyFragmentAdapter(getChildFragmentManager(), mFragments));
    }

    @OnClick(R.id.iv_add)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), TitleActivity.class));
    }

    @Override
    public void OnItemListnenr() {
        List<Information> information = mInsh.selectAll();
        mFragments.clear();
        mTab.removeAllTabs();
        for (int i = 0; i < information.size(); i++) {
            if (information.get(i).getIsShow()) {
                mTab.addTab(mTab.newTab().setText(information.get(i).getTitle()));
                mFragments.add(new TitileFragment(information.get(i).getChannelId()));
            }
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
        mVp.setAdapter(new MyFragmentAdapter(getChildFragmentManager(), mFragments));
    }
}
