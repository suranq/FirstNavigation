package com.example.firstnavigation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.TitleActivity;
import com.example.firstnavigation.shujukuBeans.Information;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/23.
 */

public class MyInformationAdaAdapter extends RecyclerView.Adapter{
    private List<Information> mData;
    private final TitleActivity mTitleActivity;
    private OnItemListener mListener;

    public MyInformationAdaAdapter(List<Information> data, TitleActivity titleActivity) {

        mData = data;
        mTitleActivity = titleActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mTitleActivity).inflate(R.layout.item_title, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.mTvTitle.setText("+ "+mData.get(position).getTitle());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.OnItemListener(mData.get(position),position);
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

    class MyViewHolder extends XRecyclerView.ViewHolder {

        private final TextView mTvTitle;
        private final ImageView mIvRemove;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mIvRemove = itemView.findViewById(R.id.iv_remove);
        }
    }

    public void setData(List<Information> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public interface OnItemListener{
        void OnItemListener(Information information,int position);
    }

    public void setOnItemListener(OnItemListener listener){
        mListener = listener;
    }
}
