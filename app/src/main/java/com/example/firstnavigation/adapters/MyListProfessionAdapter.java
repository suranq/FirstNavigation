package com.example.firstnavigation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.ProfessionActivity;
import com.example.firstnavigation.beans.ListProfession;

import java.util.List;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class MyListProfessionAdapter extends RecyclerView.Adapter{
    private List<ListProfession.ProfessionListBean> mData;
    private final ProfessionActivity mProfessionActivity;

    public MyListProfessionAdapter(List<ListProfession.ProfessionListBean> data, ProfessionActivity professionActivity) {

        mData = data;
        mProfessionActivity = professionActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mProfessionActivity).inflate(R.layout.item_profession, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.mTvZhiye.setText(mData.get(position).getProfessionName());
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvZhiye;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvZhiye = itemView.findViewById(R.id.tv_zhiye);
        }
    }

    public void setData(List<ListProfession.ProfessionListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }
}
