package com.example.firstnavigation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.utils.FindUtil;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class MyTagsHotAdapter extends RecyclerView.Adapter {
    private String mString;
    private List<String> mData;
    private final Context mContext;
    private OnItemListener mListener;

    public MyTagsHotAdapter(List<String> data, Context context, String string) {

        mData = data;
        mContext = context;
        mString = string;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_tagshot, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        if (mString != null) {
            holder1.mTvBiao.setText(FindUtil.findSearch(Color.RED, mData.get(position), mString));
        } else {
            holder1.mTvBiao.setText(mData.get(position));
        }

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.OnItemListener(mData.get(position), position);
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

    public void setString(String string) {
        mString = string;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvBiao;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvBiao = itemView.findViewById(R.id.tv_biao);
        }
    }

    public interface OnItemListener {
        void OnItemListener(String tag, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mListener = listener;
    }
}
