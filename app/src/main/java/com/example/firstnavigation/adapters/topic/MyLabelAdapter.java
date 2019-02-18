package com.example.firstnavigation.adapters.topic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.topic.LabelActivity;
import com.example.firstnavigation.adapters.MyPitchAdapter;
import com.example.firstnavigation.shujukuBeans.Label;
import com.example.firstnavigation.shujukuBeans.LabelHelep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ;
 * Created by 马明祥 on 2019/2/12.
 */

public class MyLabelAdapter extends RecyclerView.Adapter {
    private List<Label> mData;
    private final LabelActivity mLabelActivity;
    private Map<Integer,Boolean> mShow = new HashMap<>();
    private OnItemListeners mListeners;
    public static List<Label> mLabel = new ArrayList<>();

    public MyLabelAdapter(List<Label> data, LabelActivity labelActivity) {

        mData = data;
        mLabelActivity = labelActivity;

    }

    private void intMap(){
        for (int i = 0; i < mData.size(); i++) {
            mShow.put(i,false);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mLabelActivity).inflate(R.layout.item_topic, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.setIsRecyclable(false);
        holder1.mTvBiao.setText(mData.get(position).getTag());
        holder1.mIvXuan.setSelected(mData.get(position).getIsPitch());
        holder1.mIvXuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder1.mIvXuan.isSelected()) {
                    mShow.put(position,false);
                    holder1.mIvXuan.setSelected(mShow.get(position));
                    mLabel.remove(mData.get(position));
                    if (mListeners != null) {
                        mListeners.OnItemListeners(mLabel);
                    }
                } else {
                    if (mLabel.size() < 2) {
                        mShow.put(position,true);
                        holder1.mIvXuan.setSelected(mShow.get(position));
                        mLabel.add(mData.get(position));
                    } else {
                        Toast.makeText(mLabelActivity, "最多可选两个标签", Toast.LENGTH_LONG).show();
                    }
                    if (mListeners != null) {
                        mListeners.OnItemListeners(mLabel);
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

    public void setData(List<Label> data) {
        mData = data;
        intMap();
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTvBiao;
        public final ImageView mIvXuan;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvBiao = itemView.findViewById(R.id.tv_biao);
            mIvXuan = itemView.findViewById(R.id.iv_xuan);
        }
    }

    public interface OnItemListeners {
        void OnItemListeners(List<Label> label);
    }

    public void setOnItemListeners(OnItemListeners listeners) {
        mListeners = listeners;
    }

}
