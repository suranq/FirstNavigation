package com.example.firstnavigation.adapters.user.inform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.firstnavigation.beans.ListNotify;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/13.
 */

public class MyInformAdapter extends RecyclerView.Adapter{
    private List<ListNotify.DataBean> mData;
    private final Context mContext;

    public MyInformAdapter(List<ListNotify.DataBean> data, Context context) {

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
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<ListNotify.DataBean> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
