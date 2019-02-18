package com.example.firstnavigation.activitys.topic;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.topic.MyLabelAdapter;
import com.example.firstnavigation.adapters.MyPitchAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.contact.TagsHotCon;
import com.example.firstnavigation.presenter.TagsHotPresenter;
import com.example.firstnavigation.shujukuBeans.Label;
import com.example.firstnavigation.shujukuBeans.LabelHelep;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LabelActivity extends BaseActivity<TagsHotCon.TagsHotV, TagsHotPresenter<TagsHotCon.TagsHotV>> implements TagsHotCon.TagsHotV {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ed_biaoqian)
    EditText mEdBiaoqian;
    @BindView(R.id.tv_accomplish)
    TextView mTvAccomplish;
    @BindView(R.id.iv_add)
    ImageView mIvAdd;
    @BindView(R.id.rlv_label)
    RecyclerView mRlvLabel;
    @BindView(R.id.rlv_hot)
    RecyclerView mRlvHot;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.shuru)
    RelativeLayout mShuru;
    @BindView(R.id.biaoqian)
    RelativeLayout mBiaoqian;
    @BindView(R.id.fanhui)
    ImageView mFanhui;

    private List<Label> mData = new ArrayList<>();
    public List<Label> mLabels = new ArrayList<>();
    public MyLabelAdapter mMyLabelAdapter;
    private LabelHelep mInsh;
    public MyPitchAdapter mMyPitchAdapter;
    private static OnItemListener mListener;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        mInsh = LabelHelep.getInsh();


        SharedPreferences label = getSharedPreferences("label", 0);
        boolean isPitch = label.getBoolean("isPitch", false);
        if (isPitch) {
            List<Label> labels = mInsh.selectAll();
            for (int i = 0; i < labels.size(); i++) {
                mData.add(labels.get(i));
            }
        } else {
            mPresenter.getTagsHot("");
        }


        mRlvLabel.setLayoutManager(new LinearLayoutManager(LabelActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyPitchAdapter = new MyPitchAdapter(mLabels, LabelActivity.this);
        mRlvLabel.setAdapter(mMyPitchAdapter);

        mMyPitchAdapter.setOnItemListener(new MyPitchAdapter.OnItemListener() {
            @Override
            public void OnItemListener(Label label) {
                if (mLabels != null){
                    mLabels.remove(label);
                    mMyPitchAdapter.notifyDataSetChanged();
                }
            }
        });


        mRlvHot.setLayoutManager(new LinearLayoutManager(LabelActivity.this, LinearLayoutManager.VERTICAL, false));
        mMyLabelAdapter = new MyLabelAdapter(mData, LabelActivity.this);
        mRlvHot.setAdapter(mMyLabelAdapter);

        mMyLabelAdapter.setOnItemListeners(new MyLabelAdapter.OnItemListeners() {
            @Override
            public void OnItemListeners(List<Label> label) {
                mLabels = label;
                mMyPitchAdapter.setData(label);
            }
        });

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_label;
    }


    @Override
    protected TagsHotPresenter<TagsHotCon.TagsHotV> createPresenter() {
        return new TagsHotPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showTagsHot(TagsHot tagsHot) {
        SharedPreferences label = getSharedPreferences("label", 0);
        SharedPreferences.Editor edit = label.edit();
        edit.putBoolean("isPitch", true);
        edit.commit();

        List<TagsHot.DataBean> data = tagsHot.getData();
        for (int i = 0; i < data.size(); i++) {
            mInsh.insert(new Label(null, data.get(i).getTag(), false));
        }
        List<Label> labels = mInsh.selectAll();
        mMyLabelAdapter.setData(labels);
    }

    @Override
    public void showTagsSearch(TagsSearch tagsSearch) {

    }

    @OnClick({R.id.tv_accomplish, R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_accomplish:
                mShuru.setVisibility(View.GONE);
                mBiaoqian.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_add:
                mShuru.setVisibility(View.VISIBLE);
                mBiaoqian.setVisibility(View.GONE);
                break;
        }
    }

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        mListener.OnItemList(mLabels);
        finish();
    }

    public interface OnItemListener {
        void OnItemList(List<Label> labels);
    }

    public static void setOnItemListener(OnItemListener listener) {
        mListener = listener;
    }
}
