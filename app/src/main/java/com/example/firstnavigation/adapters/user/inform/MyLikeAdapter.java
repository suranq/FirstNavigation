package com.example.firstnavigation.adapters.user.inform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.R;
import com.example.firstnavigation.beans.ListNotify;
import com.example.firstnavigation.utils.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/13.
 */

public class MyLikeAdapter extends RecyclerView.Adapter {
    private List<ListNotify.DataBean> mData;
    private final Context mContext;

    public MyLikeAdapter(List<ListNotify.DataBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_like, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(mContext).load(mData.get(position).getHeadImagePath()).into(holder1.mIvUserHead);
        holder1.mTvUserName.setText(mData.get(position).getNickname());
        holder1.mTvTime.setText(TimeUtils.getDifference(mData.get(position).getNotifyTime()));
        holder1.mTvTitle.setText(mData.get(position).getFromTitle());
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

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.iv_user_head)
        ImageView mIvUserHead;
        @BindView(R.id.tv_userName)
        TextView mTvUserName;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_like)
        ImageView mTvLike;
        @BindView(R.id.tv_ping)
        TextView mTvPing;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
