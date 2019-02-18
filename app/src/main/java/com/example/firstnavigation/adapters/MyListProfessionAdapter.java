package com.example.firstnavigation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.ProfessionActivity;
import com.example.firstnavigation.beans.ListProfession;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/11.
 */

public class MyListProfessionAdapter extends RecyclerView.Adapter {
    private final RecyclerView mRlvZhiye;
    private List<ListProfession.ProfessionListBean> mData;
    private final ProfessionActivity mProfessionActivity;
    private OnItemListener mListener;

    public MyListProfessionAdapter(List<ListProfession.ProfessionListBean> data, ProfessionActivity professionActivity, RecyclerView rlvZhiye) {

        mData = data;
        mProfessionActivity = professionActivity;
        mRlvZhiye = rlvZhiye;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mProfessionActivity).inflate(R.layout.item_profession, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.mTvZhiye.setText(mData.get(position).getProfessionName());

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


    public void setData(List<ListProfession.ProfessionListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_zhiye)
        TextView mTvZhiye;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemListener{
        void OnItemListener(ListProfession.ProfessionListBean listBean);
    }

    public void setOnItemListener(OnItemListener listener){
        mListener = listener;
    }
}
