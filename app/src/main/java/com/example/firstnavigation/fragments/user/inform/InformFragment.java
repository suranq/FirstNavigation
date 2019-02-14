package com.example.firstnavigation.fragments.user.inform;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.inform.MyInformAdapter;
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
public class InformFragment extends SimpleFragment {


    @BindView(R.id.rlv_inform)
    RecyclerView mRlvInform;
    Unbinder unbinder;
    @BindView(R.id.iv_inform)
    ImageView mIvInform;
    @BindView(R.id.zanwu)
    LinearLayout mZanwu;
    Unbinder unbinder1;
    private List<ListNotify.DataBean> mData = new ArrayList<>();
    private MyInformAdapter mMyInformAdapter;

    public InformFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {
        if (mData == null && mData.size()==0){
            mZanwu.setVisibility(View.VISIBLE);
        }
        mRlvInform.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mMyInformAdapter = new MyInformAdapter(mData, getContext());
        mRlvInform.setAdapter(mMyInformAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_inform;
    }

    public void setData(List<ListNotify.DataBean> data) {
        if (data == null && data.size() == 0) {
            mZanwu.setVisibility(View.VISIBLE);
        } else {
            mZanwu.setVisibility(View.GONE);
            mMyInformAdapter.setData(data);
        }

    }

}
