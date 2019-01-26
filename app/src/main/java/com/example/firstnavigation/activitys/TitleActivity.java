package com.example.firstnavigation.activitys;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyInformationAdaAdapter;
import com.example.firstnavigation.adapters.MyInformationShowAdapter;
import com.example.firstnavigation.base.activity.SimpleActivity;
import com.example.firstnavigation.shujukuBeans.Information;
import com.example.firstnavigation.shujukuBeans.InformationHelep;
import com.example.firstnavigation.utils.DefaultItemTouchHelpCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TitleActivity extends SimpleActivity {

    @BindView(R.id.iv_chacha)
    ImageView mIvChacha;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_compile)
    TextView mTvCompile;
    @BindView(R.id.rlv_show)
    RecyclerView mRlvShow;
    @BindView(R.id.rlv_add)
    RecyclerView mRlvAdd;
    private List<Information> mData = new ArrayList<>();
    private List<Information> mInformationShow = new ArrayList<>();
    private List<Information> mInformationAdd = new ArrayList<>();
    private MyInformationShowAdapter mShowAdapter;
    private MyInformationAdaAdapter mAdaAdapter;
    private InformationHelep mInsh;

    private boolean isRemove;
    public static OnItemListener mListener;
    DefaultItemTouchHelpCallback mCallback;
    DefaultItemTouchHelpCallback mCallback1;

    @Override
    protected int getActivityColor() {
        return R.color.colorRed;
    }


    @Override
    protected void initData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mInsh = InformationHelep.getInsh();

        mRlvShow.setLayoutManager(new GridLayoutManager(TitleActivity.this, 4));
        mRlvAdd.setLayoutManager(new GridLayoutManager(TitleActivity.this, 4));

        mShowAdapter = new MyInformationShowAdapter(mData, TitleActivity.this, isRemove);
        mAdaAdapter = new MyInformationAdaAdapter(mData, TitleActivity.this);

        List<Information> information = mInsh.selectAll();
        for (int i = 0; i < information.size(); i++) {

            if (information.get(i).getIsShow()) {
                mInformationShow.add(information.get(i));
                mShowAdapter.notifyDataSetChanged();
            } else {
                mInformationAdd.add(information.get(i));
                mAdaAdapter.notifyDataSetChanged();
            }
        }

        mRlvShow.setAdapter(mShowAdapter);
        mRlvAdd.setAdapter(mAdaAdapter);

        mShowAdapter.setData(mInformationShow);
        mAdaAdapter.setData(mInformationAdd);

        mShowAdapter.setOnItemListener(new MyInformationShowAdapter.OnItemListener() {
            @Override
            public void OnItemListener(Information information, int position) {
                if (position == 0) {
                    isRemove = false;
                    mShowAdapter.mIsRemove = false;
                }
                if (isRemove) {
                    information.setIsShow(false);
                    mInsh.updata(information);

                    mInformationShow.remove(position);
                    mShowAdapter.notifyDataSetChanged();

                    mInformationAdd.add(information);
                    mAdaAdapter.notifyDataSetChanged();
                }
            }
        });
        mAdaAdapter.setOnItemListener(new MyInformationAdaAdapter.OnItemListener() {
            @Override
            public void OnItemListener(Information information, int position) {
                if (!isRemove) {
                    information.setIsShow(true);
                    mInsh.updata(information);

                    mInformationAdd.remove(position);
                    mAdaAdapter.notifyDataSetChanged();

                    mInformationShow.add(information);
                    mShowAdapter.notifyDataSetChanged();
                }
            }
        });

        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {

            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (mInformationAdd != null){
                    Collections.swap(mInformationAdd,srcPosition,targetPosition);
                    mAdaAdapter.notifyItemMoved(srcPosition,targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(true);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(mRlvAdd);

        mCallback1 = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {

            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (mInformationShow != null){
                    Collections.swap(mInformationShow,srcPosition,targetPosition);
                    mShowAdapter.notifyItemMoved(srcPosition,targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(true);
        ItemTouchHelper itemTouchHelper1 = new ItemTouchHelper(mCallback1);
        itemTouchHelper1.attachToRecyclerView(mRlvShow);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_title;
    }

    @OnClick({R.id.iv_chacha, R.id.tv_compile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_chacha:
                mListener.OnItemListnenr();
                finish();
                break;
            case R.id.tv_compile:
                if (isRemove) {
                    isRemove = false;
                    mTvCompile.setText("编辑");
                } else {
                    isRemove = true;
                    mTvCompile.setText("完成");
                }
                mShowAdapter.setShow(isRemove);
                mShowAdapter.notifyDataSetChanged();
                break;
        }
    }

    public interface OnItemListener {
        void OnItemListnenr();
    }

    public static void setOnItemListener(OnItemListener listener) {
        mListener = listener;
    }
}
