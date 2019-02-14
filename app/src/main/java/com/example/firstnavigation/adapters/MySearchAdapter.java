package com.example.firstnavigation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstnavigation.R;
import com.example.firstnavigation.activitys.information.SearchActivity;
import com.example.firstnavigation.shujukuBeans.Search;

import java.util.List;

/**
 * Created by 马明祥 on 2019/1/24.
 */

public class MySearchAdapter extends RecyclerView.Adapter{
    private List<Search> mSearches;
    private final SearchActivity mSearchActivity;

    public MySearchAdapter(List<Search> searches, SearchActivity searchActivity) {

        mSearches = searches;
        mSearchActivity = searchActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mSearchActivity).inflate(R.layout.item_search, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.mTvSearch.setText(mSearches.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if (mSearches == null) {
            return 0;
        }
        return mSearches.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvSearch;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTvSearch = itemView.findViewById(R.id.tv_search);
        }
    }
}
