package com.example.firstnavigation.adapters;

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
import com.example.firstnavigation.activitys.user.AttentionActivity;
import com.example.firstnavigation.beans.ListFollow;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class MyListFollowAdapter extends RecyclerView.Adapter{
    private List<ListFollow.FollowListBean> mData;
    private final AttentionActivity mAttentionActivity;

    public MyListFollowAdapter(List<ListFollow.FollowListBean> data, AttentionActivity attentionActivity) {

        mData = data;
        mAttentionActivity = attentionActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mAttentionActivity).inflate(R.layout.item_listfollow, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(mAttentionActivity).load(mData.get(position).getHeadImagePath()).apply(requestOptions).into(holder1.mIvUserHead);
        holder1.mTvUserName.setText(mData.get(position).getNickname());
        holder1.mTvTitle.setText(mData.get(position).getPersonalProfile());
        holder1.mTvTime.setText(mData.get(position).getFollowTime());
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<ListFollow.FollowListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvTitle;
        private final TextView mTvTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvTime = itemView.findViewById(R.id.tv_time);
        }
    }
}
