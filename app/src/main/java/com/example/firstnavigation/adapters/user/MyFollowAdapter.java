package com.example.firstnavigation.adapters.user;

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
import com.example.firstnavigation.activitys.information.ParticularsActivity;
import com.example.firstnavigation.beans.CommentList;
import com.example.firstnavigation.utils.TimeUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class MyFollowAdapter extends XRecyclerView.Adapter {
    private List<CommentList.CommentListBean> mData;
    private final ParticularsActivity mParticularsActivity;

    public MyFollowAdapter(List<CommentList.CommentListBean> data, ParticularsActivity particularsActivity) {

        mData = data;
        mParticularsActivity = particularsActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mParticularsActivity).inflate(R.layout.item_discuss, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(mParticularsActivity).load(mData.get(position).getHeadImagePath()).apply(requestOptions).into(holder1.mIvUserHead);
        holder1.mTvUserName.setText(mData.get(position).getNickname()+"");
        holder1.mTvTime.setText(TimeUtils.getDifference(mData.get(position).getCommentTime()));
        holder1.mTvTitle.setText(mData.get(position).getContent());
        holder1.mTvLike.setText("5");
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<CommentList.CommentListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_user_head)
        ImageView mIvUserHead;
        @BindView(R.id.tv_userName)
        TextView mTvUserName;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_like)
        TextView mTvLike;
        @BindView(R.id.tv_title)
        TextView mTvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
