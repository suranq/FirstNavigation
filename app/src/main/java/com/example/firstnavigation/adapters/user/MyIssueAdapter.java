package com.example.firstnavigation.adapters.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.beans.Question;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/15.
 */

public class MyIssueAdapter extends RecyclerView.Adapter {
    private List<Question.DataBean> mData;
    private final Context mContext;
    private OnItemListener mListener;

    public MyIssueAdapter(List<Question.DataBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_issue, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.mTvIssue.setText(mData.get(position).getQuestion());

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

    public void setData(List<Question.DataBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_issue)
        TextView mTvIssue;
        @BindView(R.id.xiaoxi)
        LinearLayout mXiaoxi;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemListener{
        void OnItemListener(Question.DataBean dataBean);
    }

    public void setOnItemListener(OnItemListener listener){
        mListener = listener;
    }
}
