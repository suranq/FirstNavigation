package com.example.firstnavigation.adapters.topic;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.topic.HomePageActivity;
import com.example.firstnavigation.adapters.MyImageAdapter;
import com.example.firstnavigation.beans.HomeList;
import com.example.firstnavigation.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class MyHomeListAdapter extends RecyclerView.Adapter {
    private List<HomeList.TopicListBean> mData;
    private final HomePageActivity mHomePageActivity;

    public MyHomeListAdapter(List<HomeList.TopicListBean> data, HomePageActivity homePageActivity) {

        mData = data;
        mHomePageActivity = homePageActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mHomePageActivity).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.mTvLike.setText(mData.get(position).getLikes() + "");
        holder1.mTvComment.setText(mData.get(position).getComments() + "");
        holder1.mTvRead.setText(mData.get(position).getPageviews() + "");
        holder1.mTvTime.setText(TimeUtils.gettime(mData.get(position).getPublishTime()));
        holder1.mTvTitle.setText(mData.get(position).getTitle());
        List<String> strings = new ArrayList<>();
        if (mData.get(position).getImageListThumb().size() > 0 && mData.get(position).getImageListThumb() != null) {
            for (int i = 0; i < mData.get(position).getImageListThumb().size(); i++) {
                strings.add(mData.get(position).getImageListThumb().get(i));
            }
            MyImageAdapter myImageAdapter = new MyImageAdapter(strings, mHomePageActivity);
            holder1.mRlvImage.setAdapter(myImageAdapter);
        }
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<HomeList.TopicListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.rlv_image)
        RecyclerView mRlvImage;
        @BindView(R.id.tv_read)
        TextView mTvRead;
        @BindView(R.id.tv_comment)
        TextView mTvComment;
        @BindView(R.id.tv_like)
        TextView mTvLike;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
