package com.example.firstnavigation.fragments.user;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.MyZixunAdapter;
import com.example.firstnavigation.base.fragment.SimpleFragment;
import com.example.firstnavigation.beans.UserListComment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZixunFragment extends SimpleFragment {


    private String mHeadImagePath;
    private String mNickname;
    @BindView(R.id.rlv_zixun)
    RecyclerView mRlvZixun;
    Unbinder unbinder;
    private List<UserListComment.UserCommentListBean> mData = new ArrayList<>();
    private MyZixunAdapter mMyZixunAdapter;

    public ZixunFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ZixunFragment(String headImagePath, String nickname) {

        mHeadImagePath = headImagePath;
        mNickname = nickname;
    }


    @Override
    protected void initData() {
        mRlvZixun.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mMyZixunAdapter = new MyZixunAdapter(mData,getContext(),mHeadImagePath,mNickname);
        mRlvZixun.setAdapter(mMyZixunAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_zixun;
    }

    public void setData(List<UserListComment.UserCommentListBean> data) {
        mMyZixunAdapter.setData(data);
    }

}
