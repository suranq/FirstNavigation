package com.example.firstnavigation.activitys.topic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.topic.TopicDetailsGridAdapter;
import com.example.firstnavigation.base.activity.BaseActivity;
import com.example.firstnavigation.beans.InsertTopic;
import com.example.firstnavigation.beans.ToTopic;
import com.example.firstnavigation.contact.InsertTopicCon;
import com.example.firstnavigation.presenter.InsertTopicPresenter;
import com.example.firstnavigation.shujukuBeans.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class PublishActivity extends BaseActivity<InsertTopicCon.InsertTopicV, InsertTopicPresenter<InsertTopicCon.InsertTopicV>> implements InsertTopicCon.InsertTopicV, LabelActivity.OnItemListener {

    private static OnItemListener sListener;
    @BindView(R.id.tv_publish)
    TextView mTvPublish;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_jump)
    ImageView mIvJump;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.tv_biaoqian)
    TextView mTvBiaoqian;
    @BindView(R.id.ed_title)
    EditText mEdTitle;
    @BindView(R.id.iv_tianjia)
    ImageView mIvTianjia;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.rlv_recyc)
    RecyclerView mRlvRecyc;
    private ArrayList<String> mList = new ArrayList<>();
    private TopicDetailsGridAdapter mTopicDetailsGridAdapter;
    private String mTab;

    @Override
    protected int getActivityColor() {
        return R.color.colorWhite;
    }

    @Override
    protected void initData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        mRlvRecyc.setLayoutManager(manager);
        mTopicDetailsGridAdapter = new TopicDetailsGridAdapter(mList, this);
        mRlvRecyc.setAdapter(mTopicDetailsGridAdapter);


        LabelActivity.setOnItemListener(this);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_publish;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected InsertTopicPresenter<InsertTopicCon.InsertTopicV> createPresenter() {
        return new InsertTopicPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @Override
    public void showError(String error) {
        Log.e("eeeeee", error);
    }

    @Override
    public void showInsertTopic(InsertTopic insertTopic) {
        if (insertTopic.getMessage().equals("成功")){
            sListener.OnItemListener();
            finish();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            // 获取返回的图片列表(存放的是图片路径)
            List<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
            mList = (ArrayList<String>) path;
            mTopicDetailsGridAdapter.setList(mList);
            // 处理你自己的逻辑 ....
            Log.d("tag", "" + path);
        }
        if (resultCode == 200) {
            String tabList = data.getStringExtra("tabList");
            mTab = tabList;
            Toast.makeText(PublishActivity.this, tabList, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.tv_publish, R.id.tv_biaoqian, R.id.iv_tianjia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_publish:
                if (mList != null) {
                    mPresenter.getInsertTopic(new ToTopic("efe7538b97f14d11952f5a13e1c7f7cd"
                            , mEdTitle.getText().toString(), mTvBiaoqian.getText().toString()
                            , null
                            , mList));
                } else {
                    mPresenter.getInsertTopic(new ToTopic("efe7538b97f14d11952f5a13e1c7f7cd"
                            , mEdTitle.getText().toString(), mTvBiaoqian.getText().toString()
                            , "https://www.baidu.com/"
                            , null));
                }
                break;
            case R.id.tv_biaoqian:
                Intent intent = new Intent(PublishActivity.this, LabelActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_tianjia:
                //限数量的多选(比喻最多9张)
                ArrayList<String> strings = new ArrayList<>();
                MultiImageSelector.create(this)
                        .showCamera(true) // 是否显示相机. 默认为显示
                        .count(9) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                        // 单选模式 .single()
                        .multi() // 多选模式, 默认模式;
                        .origin(strings)
                        // 默认已选择图片. 只有在选择模式为多选时有效
                        .start(PublishActivity.this, 1); //最后一个参数为暗号是个int值
                break;
        }
    }

    @Override
    public void OnItemList(List<Label> labels) {
        String s = null;
        if (labels != null && labels.size() == 1) {
            s = labels.get(0).getTag();
        }else {
            s = labels.get(0).getTag() + "," + labels.get(1).getTag();
        }
        mTvBiaoqian.setText(s);
    }

    public interface OnItemListener{
        void OnItemListener();
    }

    public static void setOnItemListener(OnItemListener listener){
        sListener = listener;
    }
}
