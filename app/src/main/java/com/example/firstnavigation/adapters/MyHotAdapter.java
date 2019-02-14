package com.example.firstnavigation.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.information.SearchActivity;
import com.example.firstnavigation.beans.Hot;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class MyHotAdapter extends RecyclerView.Adapter {
    private List<Hot.SearchListBean> mData;
    private final SearchActivity mSearchActivity;
    private OnItemListener mListener;

    public MyHotAdapter(List<Hot.SearchListBean> data, SearchActivity searchActivity) {

        mData = data;
        mSearchActivity = searchActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(mSearchActivity).inflate(R.layout.item_hot, null, false);
            return new MyViewHolder(inflate);
        }else if (viewType == 2){
            View inflate = LayoutInflater.from(mSearchActivity).inflate(R.layout.item_hot2, null, false);
            return new MyViewHolder(inflate);
        }else if (viewType == 3){
            View inflate = LayoutInflater.from(mSearchActivity).inflate(R.layout.item_hot3, null, false);
            return new MyViewHolder(inflate);
        }else if (viewType == 4){
            View inflate = LayoutInflater.from(mSearchActivity).inflate(R.layout.item_hot4, null, false);
            return new MyViewHolder(inflate);
        }else {
            View inflate = LayoutInflater.from(mSearchActivity).inflate(R.layout.item_hot4, null, false);
            return new MyViewHolder(inflate);
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1){
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.mTvFigure.setText("1.");
            holder1.mTvHot.setText(mData.get(position).getContent());
            getOnItemList(holder1,position);
        }else if (itemViewType == 2){
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.mTvFigure.setText("2.");
            holder1.mTvHot.setText(mData.get(position).getContent());
            getOnItemList(holder1,position);
        }else if (itemViewType == 3){
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.mTvFigure.setText("3.");
            holder1.mTvHot.setText(mData.get(position).getContent());
            getOnItemList(holder1,position);
        }else if (itemViewType == 4){
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.mTvFigure.setText("4.");
            holder1.mTvHot.setText(mData.get(position).getContent());
            getOnItemList(holder1,position);
        }else{
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.mTvFigure.setText("5.");
            holder1.mTvHot.setText(mData.get(position).getContent());
            getOnItemList(holder1,position);
        }
    }

    private void getOnItemList(MyViewHolder holder1, final int position) {
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.OnItemListener(mData.get(position));
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

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvFigure;
        private final TextView mTvHot;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvFigure = itemView.findViewById(R.id.tv_figure);
            mTvHot = itemView.findViewById(R.id.tv_hot);
        }
    }

    public void setData(List<Hot.SearchListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else if (position == 2) {
            return 3;
        } else if (position == 3){
            return 4;
        }else {
            return 5;
        }
    }

    public interface OnItemListener{
        void OnItemListener(Hot.SearchListBean searchListBean);
    }

    public void setOnItemListener(OnItemListener listener){
        mListener = listener;
    }
}
