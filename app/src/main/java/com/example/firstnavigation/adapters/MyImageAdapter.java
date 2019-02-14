package com.example.firstnavigation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.CollectActivity;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class MyImageAdapter extends RecyclerView.Adapter{
    private final List<String> mImageListThumb;
    private final CollectActivity mCollectActivity;

    public MyImageAdapter(List<String> imageListThumb, CollectActivity collectActivity) {

        mImageListThumb = imageListThumb;
        mCollectActivity = collectActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCollectActivity).inflate(R.layout.item_image, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Glide.with(mCollectActivity).load(mImageListThumb.get(position)).into(holder1.mIv);
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
