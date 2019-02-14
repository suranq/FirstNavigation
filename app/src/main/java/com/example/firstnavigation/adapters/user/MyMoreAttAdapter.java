package com.example.firstnavigation.adapters.user;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.MoreActivity;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.utils.FindUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/14.
 */

public class MyMoreAttAdapter extends RecyclerView.Adapter {
    private List<TagsSearch.TagListBean> mData;
    private final MoreActivity mMoreActivity;
    private String mString;
    private OnItemListener mListener;

    public MyMoreAttAdapter(List<TagsSearch.TagListBean> data, MoreActivity moreActivity, String string) {
        mData = data;
        mMoreActivity = moreActivity;
        mString = string;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mMoreActivity).inflate(R.layout.item_tagshot, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        if (mString != null) {
            holder1.mTvBiao.setText(FindUtil.findSearch(Color.RED, mData.get(position).getTag(), mString));
        } else {
            holder1.mTvBiao.setText(mData.get(position).getTag());
        }

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
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

    public void setData(List<TagsSearch.TagListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public void setString(String string) {
        mString = string;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_biao)
        TextView mTvBiao;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemListener {
        void OnItemListener(TagsSearch.TagListBean tag, int position);
    }

    public void setOnItemListener(OnItemListener listener) {
        mListener = listener;
    }
}
