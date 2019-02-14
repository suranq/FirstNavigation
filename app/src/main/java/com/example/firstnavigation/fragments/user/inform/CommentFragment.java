package com.example.firstnavigation.fragments.user.inform;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.inform.MyCommentAdapter;
import com.example.firstnavigation.base.fragment.SimpleFragment;
import com.example.firstnavigation.beans.ListNotify;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends SimpleFragment {


    @BindView(R.id.rlv_comment)
    RecyclerView mRlvComment;
    Unbinder unbinder;
    private List<ListNotify.DataBean> mData = new ArrayList<>();
    private MyCommentAdapter mMyCommentAdapter;

    public CommentFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {
        mRlvComment.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mMyCommentAdapter = new MyCommentAdapter(mData,getContext());
        mRlvComment.setAdapter(mMyCommentAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_comment;
    }

    public void setData(List<ListNotify.DataBean> data) {
        mData = data;
        mMyCommentAdapter.setData(data);
    }
}
