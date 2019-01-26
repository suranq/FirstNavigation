package com.example.firstnavigation.adapters;

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
import com.example.firstnavigation.beans.SearchBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class MyArticleAdapter extends XRecyclerView.Adapter{
    private List<SearchBean.NewListBean> mData;
    private final Context mContext;

    public MyArticleAdapter(List<SearchBean.NewListBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_article1, null, false);
            return new MyViewHolder(inflate);
        }else if (viewType == 1){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_article2, null, false);
            return new MyViewHolder(inflate);
        }else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_article3, null, false);
            return new MyViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0){
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.mTvArticle.setText(mData.get(position).getTitle());
        }else if (itemViewType == 1){
            MyViewHolder holder1 = (MyViewHolder) holder;
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder1.mImageArticle);
            holder1.mTvArticle.setText(mData.get(position).getTitle());
        }else {
            MyViewHolder holder1 = (MyViewHolder) holder;
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder1.mImageArticle);
            holder1.mTvArticle.setText(mData.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<SearchBean.NewListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    class MyViewHolder extends XRecyclerView.ViewHolder {

        private final TextView mTvArticle;
        private final ImageView mImageArticle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvArticle = itemView.findViewById(R.id.tv_article);
            mImageArticle = itemView.findViewById(R.id.image_article);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getLayoutType().equals("0")){
            return 0;
        }else if (mData.get(position).getLayoutType().equals("1")){
            return 1;
        }else {
            return 2;
        }

    }

}
