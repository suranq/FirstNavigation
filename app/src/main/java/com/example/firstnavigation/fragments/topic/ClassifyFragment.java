package com.example.firstnavigation.fragments.topic;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.SearchTopicActivity;
import com.example.firstnavigation.adapters.MyTagsHotAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.TagsHot;
import com.example.firstnavigation.beans.TagsSearch;
import com.example.firstnavigation.contact.TagsHotCon;
import com.example.firstnavigation.json.JsonTags;
import com.example.firstnavigation.presenter.TagsHotPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment<TagsHotCon.TagsHotV, TagsHotPresenter<TagsHotCon.TagsHotV>> implements TagsHotCon.TagsHotV {


    @BindView(R.id.search_edit)
    EditText mSearchEdit;
    @BindView(R.id.search_text_quxiao)
    TextView mSearchTextQuxiao;
    @BindView(R.id.rlv_classify)
    RecyclerView mRlvClassify;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    Unbinder unbinder;
    private MyTagsHotAdapter mMyTagsHotAdapter;
    private List<String> mData = new ArrayList<>();
    private String mString;

    public ClassifyFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {

        mPresenter.getTagsHot("");

        mSearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mString = mSearchEdit.getText().toString();
                if (mString != null && mString.length()>0) {
                    JsonTags jsonTags = new JsonTags();
                    jsonTags.setKeyword(mString);
                    jsonTags.setCursor("0");
                    mPresenter.getTagsSearch(new Gson().toJson(jsonTags));
                }else {
                    mPresenter.getTagsHot("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mRlvClassify.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mMyTagsHotAdapter = new MyTagsHotAdapter(mData, getContext(),mString);
        mRlvClassify.setAdapter(mMyTagsHotAdapter);

        mMyTagsHotAdapter.setOnItemListener(new MyTagsHotAdapter.OnItemListener() {
            @Override
            public void OnItemListener(String tag, int position) {
                Intent intent = new Intent(getContext(), SearchTopicActivity.class);
                intent.putExtra("tag",tag);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showTagsHot(TagsHot tagsHot) {
        mData.clear();
        List<TagsHot.DataBean> data = tagsHot.getData();
        for (int i = 0; i < data.size(); i++) {
            mData.add(data.get(i).getTag());
        }
        mMyTagsHotAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTagsSearch(TagsSearch tagsSearch) {
        mData.clear();
        List<TagsSearch.TagListBean> tagList = tagsSearch.getTagList();
        for (int i = 0; i < tagList.size(); i++) {
            mData.add(tagList.get(i).getTag());
        }
        mMyTagsHotAdapter.setString(mString);
        mMyTagsHotAdapter.notifyDataSetChanged();
    }

    @Override
    protected TagsHotPresenter<TagsHotCon.TagsHotV> createPresenter() {
        return new TagsHotPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mLinear;
    }

    @OnClick(R.id.search_text_quxiao)
    public void onViewClicked() {

    }
}
