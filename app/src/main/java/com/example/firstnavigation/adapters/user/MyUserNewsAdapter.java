package com.example.firstnavigation.adapters.user;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.CollectActivity;
import com.example.firstnavigation.beans.UserNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class MyUserNewsAdapter extends RecyclerView.Adapter {
    private List<UserNews.FavouritNewsListBean> mData;
    private final CollectActivity mCollectActivity;
    private boolean mShow;
    public static List<UserNews.FavouritNewsListBean> mSize = new ArrayList<>();
    private OnItemListener mListener;

    public MyUserNewsAdapter(List<UserNews.FavouritNewsListBean> data, CollectActivity collectActivity) {

        mData = data;
        mCollectActivity = collectActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mCollectActivity).inflate(R.layout.user_news, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder holder1 = (MyViewHolder) holder;
        if (mShow) {
            holder1.mIvXuan.setVisibility(View.VISIBLE);
        } else {
            holder1.mIvXuan.setVisibility(View.GONE);
        }

        holder1.mTvTitle.setText(mData.get(position).getTitle());
        holder1.mIvXuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder1.mIvXuan.isSelected()) {
                    holder1.mIvXuan.setSelected(false);
                    if (mListener != null) {
                        mSize.remove(mData.get(position));
                        mListener.OnItemListener(mSize.size());
                    }
                } else {
                    holder1.mIvXuan.setSelected(true);
                    if (mListener != null) {
                        mSize.add(mData.get(position));
                        mListener.OnItemListener(mSize.size());
                    }
                }
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

    public void setShow(boolean show) {
        mShow = show;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvXuan;
        private final TextView mTvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIvXuan = itemView.findViewById(R.id.iv_xuan);
            mTvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public void setData(List<UserNews.FavouritNewsListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public interface OnItemListener {
        void OnItemListener(int size);
    }

    public void setOnItemListener(OnItemListener listener) {
        mListener = listener;
    }
}
