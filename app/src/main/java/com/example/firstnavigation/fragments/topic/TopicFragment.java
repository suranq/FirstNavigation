package com.example.firstnavigation.fragments.topic;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyFragmentAdapter;
import com.example.firstnavigation.base.fragment.SimpleFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends SimpleFragment {


    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    Unbinder unbinder;

    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {
        mTab.addTab(mTab.newTab().setText("话题"));
        mTab.addTab(mTab.newTab().setText("精选"));
        mTab.addTab(mTab.newTab().setText("分类"));
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
        fragments.add(new TopicxiaoFragment());
        fragments.add(new ChoicenessFragment());
        fragments.add(new ClassifyFragment());
        mVp.setAdapter(new MyFragmentAdapter(getChildFragmentManager(),fragments));
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_topic;
    }
}
