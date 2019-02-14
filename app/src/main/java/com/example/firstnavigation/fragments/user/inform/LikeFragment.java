package com.example.firstnavigation.fragments.user.inform;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.inform.MyLikeAdapter;
import com.example.firstnavigation.base.fragment.SimpleFragment;
import com.example.firstnavigation.beans.ListNotify;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends SimpleFragment {


    @BindView(R.id.rlv_like)
    RecyclerView mRlvLike;
    Unbinder unbinder;
    private List<ListNotify.DataBean> mData;
    private MyLikeAdapter mMyLikeAdapter;

    public LikeFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {
        mRlvLike.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mMyLikeAdapter = new MyLikeAdapter(mData,getContext());
        mRlvLike.setAdapter(mMyLikeAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_like;
    }

    public void setData(List<ListNotify.DataBean> data) {
        mData = data;
//        mMyLikeAdapter.setData(data);
    }
}
