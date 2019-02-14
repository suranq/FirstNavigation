package com.example.firstnavigation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.topic.LabelActivity;
import com.example.firstnavigation.shujukuBeans.Label;
import com.example.firstnavigation.shujukuBeans.LabelHelep;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/12.
 */

public class MyPitchAdapter extends RecyclerView.Adapter {
    private List<Label> mLabels;
    private final LabelActivity mLabelActivity;
    private List<Label> mData;
    private OnItemListener mListener;

    public MyPitchAdapter(List<Label> labels, LabelActivity labelActivity) {

        mLabels = labels;
        mLabelActivity = labelActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_label, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.mTvBiao.setText(mLabels.get(position).getTag());
        holder1.mIvShan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLabels.remove(mLabels.get(position));
                LabelHelep insh = LabelHelep.getInsh();
                Label label = mLabels.get(position);
                label.setIsPitch(false);
                insh.updata(label);
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        if (mLabels == null) {
            return 0;
        }
        return mLabels.size();
    }

    public void setData(List<Label> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_biao)
        TextView mTvBiao;
        @BindView(R.id.iv_shan)
        ImageView mIvShan;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemListener{
        void OnItemListener();
    }

    public void setOnItemListener(OnItemListener listener){
        mListener = listener;
    }
}
