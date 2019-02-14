package com.example.firstnavigation.adapters.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstnavigation.R;
import com.example.firstnavigation.beans.UserListComment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.mContext;

/**
 * Created by 马明祥 on 2019/2/13.
 */

public class MyZixunAdapter extends RecyclerView.Adapter {


    private List<UserListComment.UserCommentListBean> mData;
    private final Context mContext;
    private final String mHeadImagePath;
    private final String mNickname;

    public MyZixunAdapter(List<UserListComment.UserCommentListBean> data, Context context, String headImagePath, String nickname) {


        mData = data;
        mContext = context;
        mHeadImagePath = headImagePath;
        mNickname = nickname;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_zixun, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(mContext).load(mHeadImagePath).apply(requestOptions).into(holder1.mIvUserHead);
        holder1.mTvUserName.setText(mNickname);
        holder1.mTvContent.setText(mData.get(position).getContent());
        holder1.mTvTime.setText(mData.get(position).getCommentTime());
        holder1.mTvTitle.setText(mData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<UserListComment.UserCommentListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_user_head)
        ImageView mIvUserHead;
        @BindView(R.id.tv_userName)
        TextView mTvUserName;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_shan)
        TextView mTvShan;
        @BindView(R.id.tv_like)
        TextView mTvLike;
        @BindView(R.id.tv_content)
        TextView mTvContent;
        @BindView(R.id.tv_title)
        TextView mTvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
