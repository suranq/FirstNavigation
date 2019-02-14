package com.example.firstnavigation.adapters.user;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.CollectActivity;
import com.example.firstnavigation.adapters.MyImageAdapter;
import com.example.firstnavigation.beans.UserTopic;
import com.example.firstnavigation.utils.TimeUtils;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class MyUserTopicAdapter extends RecyclerView.Adapter {
    private List<UserTopic.FavouritTopicListBean> mData1;
    private final CollectActivity mCollectActivity;

    public MyUserTopicAdapter(List<UserTopic.FavouritTopicListBean> data1, CollectActivity collectActivity) {

        mData1 = data1;
        mCollectActivity = collectActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            View inflate = LayoutInflater.from(mCollectActivity).inflate(R.layout.user_topic1, parent, false);
            return new MyViewHolder1(inflate);
        }else {
            View inflate = LayoutInflater.from(mCollectActivity).inflate(R.layout.user_topic2, parent, false);
            return new MyViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0){
            MyViewHolder1 holder1 = (MyViewHolder1) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(mCollectActivity).load(mData1.get(position).getHeadImagePath()).apply(requestOptions).into(holder1.mIvUserHead);
            holder1.mTvUserName.setText(mData1.get(position).getNickname());
            holder1.mTvTime.setText(TimeUtils.getDifference(mData1.get(position).getPublishTime()));
            holder1.mTvTitle.setText(mData1.get(position).getTitle());
            holder1.mTvHui.setText("A:"+mData1.get(position).getComment());
            holder1.mRlvImage.setLayoutManager(new GridLayoutManager(mCollectActivity,3));
            MyImageAdapter myImageAdapter = new MyImageAdapter(mData1.get(position).getImageListThumb(),mCollectActivity);
            holder1.mRlvImage.setAdapter(myImageAdapter);
        }else {
            MyViewHolder2 holder2 = (MyViewHolder2) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(mCollectActivity).load(mData1.get(position).getHeadImagePath()).apply(requestOptions).into(holder2.mIvUserHead);
            holder2.mTvUserName.setText(mData1.get(position).getNickname());
            holder2.mTvTime.setText(TimeUtils.getDifference(mData1.get(position).getPublishTime()));
            holder2.mTvTitle.setText(mData1.get(position).getTitle());
            holder2.mTvHui.setText("A:"+mData1.get(position).getComment());
            holder2.mTvFenXiang.setText(mData1.get(position).getShareLink());
        }
    }

    @Override
    public int getItemCount() {
        if (mData1 == null) {
            return 0;
        }
        return mData1.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvTime;
        private final TextView mTvTitle;
        private final TextView mTvHui;
        private final RecyclerView mRlvImage;

        public MyViewHolder1(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvTime = itemView.findViewById(R.id.tv_time);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvHui = itemView.findViewById(R.id.tv_hui);
            mRlvImage = itemView.findViewById(R.id.rlv_image);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvTime;
        private final TextView mTvTitle;
        private final TextView mTvHui;
        private final TextView mTvFenXiang;

        public MyViewHolder2(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvTime = itemView.findViewById(R.id.tv_time);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvHui = itemView.findViewById(R.id.tv_hui);
            mTvFenXiang = itemView.findViewById(R.id.tv_fenxiang);
        }
    }

    @Override
    public int getItemViewType(int position) {
        List<String> imageListThumb = mData1.get(position).getImageListThumb();
        if (imageListThumb!= null && imageListThumb.size() > 0) {
            return 0;
        }else {
            return 1;
        }

    }
}
