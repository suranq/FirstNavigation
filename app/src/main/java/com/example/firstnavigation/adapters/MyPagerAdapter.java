package com.example.firstnavigation.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.firstnavigation.beans.TagsHot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MyPagerAdapter extends FragmentPagerAdapter{
    private List<TagsHot.DataBean> mData;
    private final ArrayList<Fragment> mFragments;

    public MyPagerAdapter(FragmentManager fm, List<TagsHot.DataBean> data, ArrayList<Fragment> fragments) {
        super(fm);
        mData = data;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position).getTag();
    }
}
