package com.example.firstnavigation.adapters.topic;

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
import com.example.firstnavigation.beans.LoadTopic;
import com.example.firstnavigation.beans.Topic;
import com.example.firstnavigation.utils.SystemUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/25.
 */

public class MyTopicAdapter extends XRecyclerView.Adapter {
    private List<Topic.TopicListBean> mData;
    private final Context mContext;
    private OnItemListener mListener;

    public MyTopicAdapter(List<Topic.TopicListBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_loadtopic1, null, false);
            return new MyViewHolder1(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_loadtopic2, null, false);
            return new MyViewHolder2(inflate);
        } else if (viewType == 3) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_loadtopic3, null, false);
            return new MyViewHolder3(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_loadtopic4, null, false);
            return new MyViewHolder4(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            MyViewHolder1 holder1 = (MyViewHolder1) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(mContext).load(mData.get(position).getHeadImagePath()).apply(requestOptions).into(holder1.mIvUserHead);
            holder1.mTvtitle.setText(mData.get(position).getTitle());
            holder1.mTvUserName.setText(mData.get(position).getNickname());
            holder1.mTvtime.setText(mData.get(position).getPublishTime());
            holder1.mTvLike.setText(mData.get(position).getLikes() + "");
            holder1.mTvComment.setText(mData.get(position).getComments() + "");
            holder1.mTvRead.setText(mData.get(position).getPageviews() + "");
            if (SystemUtil.isOpen()) {
                Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder1.mIvTu);
            }
            getOnItem(holder1, position);
        } else if (itemViewType == 2) {
            MyViewHolder2 holder2 = (MyViewHolder2) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(mContext).load(mData.get(position).getHeadImagePath()).apply(requestOptions).into(holder2.mIvUserHead);
            holder2.mTvtitle.setText(mData.get(position).getTitle());
            holder2.mTvUserName.setText(mData.get(position).getNickname());
            holder2.mTvtime.setText(mData.get(position).getPublishTime());
            holder2.mTvLike.setText(mData.get(position).getLikes() + "");
            holder2.mTvComment.setText(mData.get(position).getComments() + "");
            holder2.mTvRead.setText(mData.get(position).getPageviews() + "");
            if (SystemUtil.isOpen()) {
                Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder2.mIvTu1);
                Glide.with(mContext).load(mData.get(position).getImageListThumb().get(1)).into(holder2.mIvTu2);
            }
            getOnItem(holder2, position);
        } else if (itemViewType == 3) {
            MyViewHolder3 holder3 = (MyViewHolder3) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(mContext).load(mData.get(position).getHeadImagePath()).apply(requestOptions).into(holder3.mIvUserHead);
            holder3.mTvtitle.setText(mData.get(position).getTitle());
            holder3.mTvUserName.setText(mData.get(position).getNickname());
            holder3.mTvtime.setText(mData.get(position).getPublishTime());
            holder3.mTvLike.setText(mData.get(position).getLikes() + "");
            holder3.mTvComment.setText(mData.get(position).getComments() + "");
            holder3.mTvRead.setText(mData.get(position).getPageviews() + "");
            if (SystemUtil.isOpen()) {
                Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(holder3.mIvTu1);
                Glide.with(mContext).load(mData.get(position).getImageListThumb().get(1)).into(holder3.mIvTu2);
                Glide.with(mContext).load(mData.get(position).getImageListThumb().get(2)).into(holder3.mIvTu3);
            }
            getOnItem(holder3, position);
        } else {
            MyViewHolder4 holder4 = (MyViewHolder4) holder;
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(mContext).load(mData.get(position).getHeadImagePath()).apply(requestOptions).into(holder4.mIvUserHead);
            holder4.mTvtitle.setText(mData.get(position).getTitle());
            holder4.mTvUserName.setText(mData.get(position).getNickname());
            holder4.mTvtime.setText(mData.get(position).getPublishTime());
            holder4.mTvLike.setText(mData.get(position).getLikes() + "");
            holder4.mTvComment.setText(mData.get(position).getComments() + "");
            holder4.mTvRead.setText(mData.get(position).getPageviews() + "");
            holder4.mTvShare.setText(mData.get(position).getShareLink());
            getOnItem(holder4, position);
        }
    }

    private void getOnItem(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
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

    public void setData(List<Topic.TopicListBean> data) {
        mData = data;
        notifyDataSetChanged();
    }

    class MyViewHolder1 extends XRecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvtime;
        private final TextView mTvtitle;
        private final ImageView mIvTu;
        private final TextView mTvRead;
        private final TextView mTvComment;
        private final TextView mTvLike;

        public MyViewHolder1(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mTvtitle = itemView.findViewById(R.id.tv_title);
            mIvTu = itemView.findViewById(R.id.iv_tu);
            mTvRead = itemView.findViewById(R.id.tv_read);
            mTvComment = itemView.findViewById(R.id.tv_comment);
            mTvLike = itemView.findViewById(R.id.tv_like);
        }
    }

    class MyViewHolder2 extends XRecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvtime;
        private final TextView mTvtitle;
        private final ImageView mIvTu1;
        private final ImageView mIvTu2;
        private final TextView mTvRead;
        private final TextView mTvComment;
        private final TextView mTvLike;

        public MyViewHolder2(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mTvtitle = itemView.findViewById(R.id.tv_title);
            mIvTu1 = itemView.findViewById(R.id.iv_tu1);
            mIvTu2 = itemView.findViewById(R.id.iv_tu2);
            mTvRead = itemView.findViewById(R.id.tv_read);
            mTvComment = itemView.findViewById(R.id.tv_comment);
            mTvLike = itemView.findViewById(R.id.tv_like);
        }
    }

    class MyViewHolder3 extends XRecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvtime;
        private final TextView mTvtitle;
        private final ImageView mIvTu1;
        private final ImageView mIvTu2;
        private final ImageView mIvTu3;
        private final TextView mTvRead;
        private final TextView mTvComment;
        private final TextView mTvLike;

        public MyViewHolder3(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mTvtitle = itemView.findViewById(R.id.tv_title);
            mIvTu1 = itemView.findViewById(R.id.iv_tu1);
            mIvTu2 = itemView.findViewById(R.id.iv_tu2);
            mIvTu3 = itemView.findViewById(R.id.iv_tu3);
            mTvRead = itemView.findViewById(R.id.tv_read);
            mTvComment = itemView.findViewById(R.id.tv_comment);
            mTvLike = itemView.findViewById(R.id.tv_like);
        }
    }

    class MyViewHolder4 extends XRecyclerView.ViewHolder {

        private final ImageView mIvUserHead;
        private final TextView mTvUserName;
        private final TextView mTvtime;
        private final TextView mTvtitle;
        private final TextView mTvShare;
        private final TextView mTvRead;
        private final TextView mTvComment;
        private final TextView mTvLike;

        public MyViewHolder4(View itemView) {
            super(itemView);
            mIvUserHead = itemView.findViewById(R.id.iv_user_head);
            mTvUserName = itemView.findViewById(R.id.tv_userName);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mTvtitle = itemView.findViewById(R.id.tv_title);
            mTvShare = itemView.findViewById(R.id.tv_share);
            mTvRead = itemView.findViewById(R.id.tv_read);
            mTvComment = itemView.findViewById(R.id.tv_comment);
            mTvLike = itemView.findViewById(R.id.tv_like);
        }
    }

    @Override
    public int getItemViewType(int position) {
        List<String> imageListThumb = mData.get(position).getImageListThumb();
        if (imageListThumb != null) {
            if (imageListThumb.size() == 1) {
                return 1;
            } else if (imageListThumb.size() == 2) {
                return 2;
            } else if (imageListThumb.size() == 3) {
                return 3;
            } else {
                return 4;
            }
        } else {
            return 4;
        }
    }

    public interface OnItemListener {
        void OnItemListener(Topic.TopicListBean topicListBean);
    }

    public void setOnItemListener(OnItemListener listener) {
        mListener = listener;
    }
}
