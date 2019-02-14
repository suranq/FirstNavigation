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
import com.example.firstnavigation.activitys.topic.ParticularsTopicActivity;
import com.example.firstnavigation.beans.ListComment;
import com.example.firstnavigation.utils.TimeUtils;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/6.
 */

public class MyDiscussAdapter extends RecyclerView.Adapter{
    private List<ListComment.CommentListBean> mCommentList;
    private final ParticularsTopicActivity mParticularsTopicActivity;

    public MyDiscussAdapter(List<ListComment.CommentListBean> commentList, ParticularsTopicActivity particularsTopicActivity) {

        mCommentList = commentList;
        mParticularsTopicActivity = particularsTopicActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mParticularsTopicActivity).inflate(R.layout.item_discuss, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(mParticularsTopicActivity).load(mCommentList.get(position).getHeadImagePath()).apply(requestOptions).into(holder1.mIvUserHead);
        holder1.mTvUserName.setText(mCommentList.get(position).getNickname());
        holder1.mTvTime.setText(TimeUtils.getDifference(mCommentList.get(position).getCommentTime()));
        holder1.mTvTitle.setText(mCommentList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        if (mCommentList == null) {
            return 0;
        }
        return mCommentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvTime;
        private final TextView mTvLike;
        private final TextView mTvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvTime = itemView.findViewById(R.id.tv_time);
            mTvLike = itemView.findViewById(R.id.tv_like);
            mTvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
