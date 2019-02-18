package com.example.firstnavigation.adapters.topic;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.topic.MyTopicActivity;
import com.example.firstnavigation.adapters.MyImageAdapter;
import com.example.firstnavigation.beans.ListTopic;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 马明祥 on 2019/2/17.
 */

public class MyListTopicAdapter extends XRecyclerView.Adapter {
    private final LinearLayout mLinear;
    private final XRecyclerView mXrlvMytopic;
    private List<ListTopic.FavouritTopicListBean> mData;
    private final MyTopicActivity mMyTopicActivity;

    public MyListTopicAdapter(List<ListTopic.FavouritTopicListBean> data, MyTopicActivity myTopicActivity, LinearLayout linear, XRecyclerView xrlvMytopic) {
        mData = data;
        mMyTopicActivity = myTopicActivity;
        mLinear = linear;
        mXrlvMytopic = xrlvMytopic;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mMyTopicActivity).inflate(R.layout.item_listtopic, parent, false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder holder1 = (ViewHolder) holder;
        holder1.mMineTime.setText(mData.get(position).getPublishTime());
        holder1.mTvTitle.setText(mData.get(position).getTitle());
        holder1.mTextDianzan.setText(mData.get(position).getLikes()+"");
        holder1.mTextRead.setText(mData.get(position).getPageviews()+"");
        holder1.mTextPinglun.setText(mData.get(position).getComments()+"");
        MyImageAdapter myImageAdapter = new MyImageAdapter(mData.get(position).getImageListThumb(), mMyTopicActivity);
        holder1.mRlvImage.setAdapter(myImageAdapter);

        holder1.mEditer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(mMyTopicActivity).inflate(R.layout.pop_bianji, null, false);
                final PopupWindow popupWindow = new PopupWindow(inflate);
                popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                mLinear.setBackgroundColor(0xC4BDB6B6);
                popupWindow.showAtLocation(mXrlvMytopic, Gravity.BOTTOM,0,0);
                TextView tvShanCHu = inflate.findViewById(R.id.tv_shanchu);
                TextView tvQuXiao = inflate.findViewById(R.id.tv_quxiao);
                tvShanCHu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mData.remove(position);
                        notifyDataSetChanged();
                        mLinear.setBackgroundColor(0xFFFFFFFF);
                        popupWindow.dismiss();
                    }
                });
                tvQuXiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLinear.setBackgroundColor(0xFFFFFFFF);
                        popupWindow.dismiss();
                    }
                });
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

    public void setData(List<ListTopic.FavouritTopicListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mine_time)
        TextView mMineTime;
        @BindView(R.id.bianji)
        ImageView mBianji;
        @BindView(R.id.editer)
        TextView mEditer;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.rlv_image)
        RecyclerView mRlvImage;
        @BindView(R.id.text_read)
        TextView mTextRead;
        @BindView(R.id.text_pinglun)
        TextView mTextPinglun;
        @BindView(R.id.text_dianzan)
        TextView mTextDianzan;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
