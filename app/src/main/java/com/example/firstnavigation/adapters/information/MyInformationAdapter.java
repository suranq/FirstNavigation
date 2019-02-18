package com.example.firstnavigation.adapters.information;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstnavigation.R;
import com.example.firstnavigation.beans.DownList;
import com.example.firstnavigation.utils.SystemUtil;
import com.example.firstnavigation.utils.TimeUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/21.
 */

public class MyInformationAdapter extends XRecyclerView.Adapter {
    private List<DownList.NewListBean> mData;
    private final Context mContext;

    private int ZERO = 0;
    private int ONE = 1;
    private int TWO = 2;
    private int THREE = 3;
    private OnItemListener mListener;

    public MyInformationAdapter(List<DownList.NewListBean> data, Context context) {

        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ZERO) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.time_text, null, false);
            return new MyTimeText(inflate);
        } else if (viewType == ONE) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.time_teim, null, false);
            return new MyTimeTeim(inflate);
        } else if (viewType == TWO) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_si, null, false);
            return new MyItemSi(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_san, null, false);
            return new MyItemSan(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == ZERO) {
            getZero(position, holder);
        } else if (itemViewType == ONE) {
            getONE(position, holder);
        } else if (itemViewType == TWO) {
            getTWO(position, holder);
        } else if (itemViewType == THREE) {
            getTHREE(position, holder);
        }

    }

    private void getTHREE(int position, RecyclerView.ViewHolder holder) {
        MyItemSan myItemSan = (MyItemSan) holder;
        myItemSan.mTvTitle.setText(mData.get(position).getTitle());
        if (SystemUtil.isOpen()) {
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(myItemSan.mIvTu1);
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(myItemSan.mIvTu3);
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(myItemSan.mIvTu2);
        }
        myItemSan.mIvStick.setImageResource(R.mipmap.news_top3);
        myItemSan.mIvCha.setImageResource(R.mipmap.news_x3);
        myItemSan.mTvThread.setText(mData.get(position).getPageviews() + "跟帖");
        myItemSan.mTvtime.setText(TimeUtils.gettime(mData.get(position).getPublishTime()));
        myItemSan.mTvwebsite.setText("新华网");

        chacha(myItemSan.mIvCha, position);

        skip(myItemSan.itemView, position);
    }

    private void getTWO(int position, RecyclerView.ViewHolder holder) {
        MyItemSi myItemSi = (MyItemSi) holder;
        myItemSi.mTvTitle.setText(mData.get(position).getTitle());
        if (SystemUtil.isOpen()) {
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(myItemSi.mIv);
        }
        myItemSi.mIvStick.setImageResource(R.mipmap.news_top3);
        myItemSi.mIvCha.setImageResource(R.mipmap.news_x3);
        myItemSi.mTvThread.setText(mData.get(position).getPageviews() + "跟帖");
        myItemSi.mTvtime.setText(TimeUtils.gettime(mData.get(position).getPublishTime()));
        myItemSi.mTvwebsite.setText("新华网");

        chacha(myItemSi.mIvCha, position);

        skip(myItemSi.itemView, position);
    }

    private void getONE(int position, RecyclerView.ViewHolder holder) {
        MyTimeTeim myTimeTeim = (MyTimeTeim) holder;
        myTimeTeim.mTvTitle.setText(mData.get(position).getTitle());
        if (SystemUtil.isOpen()) {
            Glide.with(mContext).load(mData.get(position).getImageListThumb().get(0)).into(myTimeTeim.mIvImage);
        }
        myTimeTeim.mIvStick.setImageResource(R.mipmap.news_top3);
        myTimeTeim.mIvCha.setImageResource(R.mipmap.news_x3);
        myTimeTeim.mTvThread.setText(mData.get(position).getPageviews() + "跟帖");
        myTimeTeim.mTvtime.setText(TimeUtils.gettime(mData.get(position).getPublishTime()));
        myTimeTeim.mTvwebsite.setText("新华网");

        chacha(myTimeTeim.mIvCha, position);

        skip(myTimeTeim.itemView, position);

    }

    private void skip(View itemView, final int position) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.OnItemListener(mData.get(position));
                }
            }
        });
    }

    private void chacha(ImageView ivCha, final int position) {
        ivCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    private void getZero(int position, RecyclerView.ViewHolder holder) {
        MyTimeText myTimeText = (MyTimeText) holder;
        myTimeText.mTvtitle.setText(mData.get(position).getTitle());
        myTimeText.mIvStick.setImageResource(R.mipmap.news_top3);
        myTimeText.mTvtime.setText(TimeUtils.gettime(mData.get(position).getPublishTime()));
        myTimeText.mTvwebsite.setText("新华网");
        myTimeText.mTvThread.setText(mData.get(position).getPageviews() + "跟帖");

        skip(myTimeText.itemView, position);
    }

    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    public void setData(List<DownList.NewListBean> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    class MyTimeText extends XRecyclerView.ViewHolder {

        private final TextView mTvtitle;
        private final TextView mTvwebsite;
        private final TextView mTvThread;
        private final TextView mTvtime;
        private final ImageView mIvStick;

        public MyTimeText(View itemView) {
            super(itemView);
            mTvtitle = itemView.findViewById(R.id.tv_title);
            mTvwebsite = itemView.findViewById(R.id.tv_website);
            mTvThread = itemView.findViewById(R.id.tv_Thread);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mIvStick = itemView.findViewById(R.id.iv_Stick);
        }
    }

    class MyTimeTeim extends XRecyclerView.ViewHolder {

        private final TextView mTvTitle;
        private final ImageView mIvImage;
        private final TextView mTvwebsite;
        private final TextView mTvThread;
        private final TextView mTvtime;
        private final ImageView mIvStick;
        private final ImageView mIvCha;

        public MyTimeTeim(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);

            mIvImage = itemView.findViewById(R.id.iv_image);
            mTvwebsite = itemView.findViewById(R.id.tv_website);
            mTvThread = itemView.findViewById(R.id.tv_Thread);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mIvStick = itemView.findViewById(R.id.iv_Stick);
            mIvCha = itemView.findViewById(R.id.iv_cha);
        }
    }

    class MyItemSan extends XRecyclerView.ViewHolder {

        private final TextView mTvTitle;
        private final ImageView mIvTu1;
        private final ImageView mIvTu2;
        private final ImageView mIvTu3;

        private final TextView mTvwebsite;
        private final TextView mTvThread;
        private final TextView mTvtime;
        private final ImageView mIvStick;
        private final ImageView mIvCha;

        public MyItemSan(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mIvTu1 = itemView.findViewById(R.id.iv_tu1);
            mIvTu2 = itemView.findViewById(R.id.iv_tu2);
            mIvTu3 = itemView.findViewById(R.id.iv_tu3);
            mTvwebsite = itemView.findViewById(R.id.tv_website);
            mTvThread = itemView.findViewById(R.id.tv_Thread);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mIvStick = itemView.findViewById(R.id.iv_Stick);
            mIvCha = itemView.findViewById(R.id.iv_cha);
        }
    }

    class MyItemSi extends XRecyclerView.ViewHolder {

        private final TextView mTvTitle;
        private final ImageView mIv;
        private final TextView mTvwebsite;
        private final TextView mTvThread;
        private final TextView mTvtime;
        private final ImageView mIvStick;
        private final ImageView mIvCha;

        public MyItemSi(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mIv = itemView.findViewById(R.id.iv);
            mTvwebsite = itemView.findViewById(R.id.tv_website);
            mTvThread = itemView.findViewById(R.id.tv_Thread);
            mTvtime = itemView.findViewById(R.id.tv_time);
            mIvStick = itemView.findViewById(R.id.iv_Stick);
            mIvCha = itemView.findViewById(R.id.iv_cha);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int i = position % 4;
        if (i == 1) {
            return ONE;
        } else if (i == 2) {
            return TWO;
        } else if (i == 3) {
            return THREE;
        } else {
            return ZERO;
        }
    }

    public interface OnItemListener {
        void OnItemListener(DownList.NewListBean newListBean);
    }

    public void setOnItemListener(OnItemListener listener) {
        mListener = listener;
    }
}
