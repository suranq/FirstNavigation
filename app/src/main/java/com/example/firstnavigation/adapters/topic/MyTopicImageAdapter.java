package com.example.firstnavigation.adapters.topic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.topic.ParticularsTopicActivity;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/6.
 */

public class MyTopicImageAdapter extends RecyclerView.Adapter{
    private List<String> mImageListThumb;
    private final ParticularsTopicActivity mParticularsTopicActivity;

    public MyTopicImageAdapter(List<String> imageListThumb, ParticularsTopicActivity particularsTopicActivity) {

        mImageListThumb = imageListThumb;
        mParticularsTopicActivity = particularsTopicActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mParticularsTopicActivity).inflate(R.layout.item_image, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Glide.with(mParticularsTopicActivity).load(mImageListThumb.get(position)).into(holder1.mIv);
    }

    @Override
    public int getItemCount() {
        if (mImageListThumb == null) {
            return 0;
        }
        return mImageListThumb.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv);
        }
    }
}
