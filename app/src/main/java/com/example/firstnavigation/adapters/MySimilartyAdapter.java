package com.example.firstnavigation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.information.ParticularsActivity;
import com.example.firstnavigation.beans.RelevantNews;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class MySimilartyAdapter extends RecyclerView.Adapter {
    private List<RelevantNews.DataBean> mData1;
    private final ParticularsActivity mParticularsActivity;

    public MySimilartyAdapter(List<RelevantNews.DataBean> data1, ParticularsActivity particularsActivity) {

        mData1 = data1;
        mParticularsActivity = particularsActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mParticularsActivity).inflate(R.layout.item_similarty, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(mParticularsActivity).load(mData1.get(position).getImageListThumb().get(0)).into(holder1.mIv);
        holder1.mTvTitle.setText(mData1.get(position).getTitle());
        holder1.mTvFrom.setText("阿鑫之家");
        holder1.mTvTime.setText(mData1.get(position).getPublishTime());
    }

    @Override
    public int getItemCount() {
        if (mData1 == null) {
            return 0;
        }
        return mData1.size();
    }

    public void setData(List<RelevantNews.DataBean> data) {
        mData1 = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_from)
        TextView mTvFrom;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.iv)
        ImageView mIv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
