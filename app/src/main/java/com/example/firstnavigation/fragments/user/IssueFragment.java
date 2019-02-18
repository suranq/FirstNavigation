package com.example.firstnavigation.fragments.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.user.WentiActivity;
import com.example.firstnavigation.adapters.user.MyIssueAdapter;
import com.example.firstnavigation.base.fragment.BaseFragment;
import com.example.firstnavigation.beans.Question;
import com.example.firstnavigation.contact.QuestionCon;
import com.example.firstnavigation.presenter.QuestionPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class IssueFragment extends BaseFragment<QuestionCon.QuestionV, QuestionPresenter<QuestionCon.QuestionV>> implements QuestionCon.QuestionV {


    @BindView(R.id.rlv_issue)
    RecyclerView mRlvIssue;
    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    Unbinder unbinder;

    private List<Question.DataBean> mData = new ArrayList<>();
    private MyIssueAdapter mMyIssueAdapter;

    public IssueFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {
        mPresenter.getQuestion("");

        mRlvIssue.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRlvIssue.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        mMyIssueAdapter = new MyIssueAdapter(mData,getContext());
        mRlvIssue.setAdapter(mMyIssueAdapter);

        mMyIssueAdapter.setOnItemListener(new MyIssueAdapter.OnItemListener() {
            @Override
            public void OnItemListener(Question.DataBean dataBean) {
                Intent intent = new Intent(getContext(), WentiActivity.class);
                intent.putExtra("answer",dataBean.getAnswer());
                startActivity(intent);
            }
        });

    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_issue;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showQuestion(Question question) {
        mMyIssueAdapter.setData(question.getData());
    }

    @Override
    protected QuestionPresenter<QuestionCon.QuestionV> createPresenter() {
        return new QuestionPresenter<>();
    }

    @Override
    protected View getActivityID() {
        return mFrameLayout;
    }
}
