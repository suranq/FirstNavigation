package com.example.firstnavigation.activitys.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.MyListProfessionAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.ListProfession;
import com.example.firstnavigation.contact.ListProfessionCon;
import com.example.firstnavigation.presenter.ListProfessionPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfessionActivity extends BaseActivity<ListProfessionCon.ListProfessionV, ListProfessionPresenter<ListProfessionCon.ListProfessionV>> implements ListProfessionCon.ListProfessionV {

    private static OnItemListener sListener;
    @BindView(R.id.iv_fan)
    ImageView mIvFan;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rlv_zhiye)
    RecyclerView mRlvZhiye;
    @BindView(R.id.bt_wan)
    Button mBtWan;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    private MyListProfessionAdapter mMyListProfessionAdapter;
    private List<ListProfession.ProfessionListBean> mData = new ArrayList<>();

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        mPresenter.getListProfession("");
        mRlvZhiye.setLayoutManager(new LinearLayoutManager(ProfessionActivity.this,LinearLayoutManager.VERTICAL,false));
        mMyListProfessionAdapter = new MyListProfessionAdapter(mData,ProfessionActivity.this,mRlvZhiye);
        mRlvZhiye.setAdapter(mMyListProfessionAdapter);

        mMyListProfessionAdapter.setOnItemListener(new MyListProfessionAdapter.OnItemListener() {
            @Override
            public void OnItemListener(ListProfession.ProfessionListBean listBean) {
                sListener.OnItemListener(listBean);
                finish();
            }
        });
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_profession;
    }

    @Override
    protected ListProfessionPresenter<ListProfessionCon.ListProfessionV> createPresenter() {
        return new ListProfessionPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showListProfession(ListProfession listProfession) {
        mMyListProfessionAdapter.setData(listProfession.getProfessionList());
    }

    @OnClick({R.id.iv_fan, R.id.bt_wan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_fan:
                finish();
                break;
            case R.id.bt_wan:
                break;
        }
    }

    public interface OnItemListener{
        void OnItemListener(ListProfession.ProfessionListBean professionListBean);
    }

    public static void setOnItemListener(OnItemListener listener){
        sListener = listener;
    }
}
