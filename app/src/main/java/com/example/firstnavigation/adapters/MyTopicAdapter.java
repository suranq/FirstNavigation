package com.example.firstnavigation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.firstnavigation.beans.Topic;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/25.
 */

public class MyTopicAdapter extends XRecyclerView.Adapter{
    private List<Topic.TopicListBean> mData;
    private final Context mContext;

    public MyTopicAdapter(List<Topic.TopicListBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(List<Topic.TopicListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
