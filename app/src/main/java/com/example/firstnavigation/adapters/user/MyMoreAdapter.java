package com.example.firstnavigation.adapters.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.MoreAttenActivity;
import com.example.firstnavigation.beans.MoreFollow;
import com.example.firstnavigation.utils.XCRoundRectImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MyMoreAdapter extends RecyclerView.Adapter {
    private List<MoreFollow.MoreFollowListBean> mData;
    private final Context mContext;

    public MyMoreAdapter(List<MoreFollow.MoreFollowListBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_more, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(mContext).load(mData.get(position).getHeadImagePath()).into(holder1.mIvUserHead);
        holder1.mTvUserName.setText(mData.get(position).getNickname());
        holder1.mTvAttention.setText(mData.get(position).getFollowers() + "关注");

        holder1.mIvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<MoreFollow.MoreFollowListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_user_head)
        XCRoundRectImageView mIvUserHead;
        @BindView(R.id.tv_userName)
        TextView mTvUserName;
        @BindView(R.id.tv_attention)
        TextView mTvAttention;
        @BindView(R.id.iv_add)
        ImageView mIvAdd;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
