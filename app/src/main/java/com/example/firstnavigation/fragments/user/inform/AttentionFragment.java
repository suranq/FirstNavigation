package com.example.firstnavigation.fragments.user.inform;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firstnavigation.MainActivity;
import com.example.firstnavigation.R;
import com.example.firstnavigation.adapters.user.inform.MyAttentionAdapter;
import com.example.firstnavigation.base.fragment.SimpleFragment;
import com.example.firstnavigation.beans.ListNotify;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttentionFragment extends SimpleFragment {

    @BindView(R.id.rlv_attention)
    SwipeMenuRecyclerView mRlvAttention;
    private List<ListNotify.DataBean> mData = new ArrayList<>();
    private MyAttentionAdapter mMyAttentionAdapter;

    public AttentionFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initData() {
        mRlvAttention.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //创建菜单
        SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {

                int width = getResources().getDimensionPixelOffset(R.dimen.dp_100);
                int height = ViewGroup.LayoutParams.MATCH_PARENT;
                // 注意：哪边不想要菜单，那么不要添加即可。
                SwipeMenuItem addItem = new SwipeMenuItem(getContext())
                        .setBackground(R.color.colorRed)
                        .setText("删除")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                rightMenu.addMenuItem(addItem); // 添加菜单到右侧。
            }
        };

        // 设置监听器。
        mRlvAttention.setSwipeMenuCreator(mSwipeMenuCreator);

        SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                menuBridge.closeMenu();
                int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
                int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
                int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
                Toast.makeText(getContext(), direction + " " + adapterPosition + " " + menuPosition, Toast.LENGTH_SHORT).show();
            }
        };

        //设置侧滑菜单的点击事件
        mRlvAttention.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                menuBridge.closeMenu();
                int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。0是左，右是1，暂时没有用到
                int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
                int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
                mData.remove(adapterPosition);
                mMyAttentionAdapter = new MyAttentionAdapter(mData, getContext());
                mRlvAttention.setAdapter(mMyAttentionAdapter);
            }
        });

        mMyAttentionAdapter = new MyAttentionAdapter(mData, getContext());
        mRlvAttention.setAdapter(mMyAttentionAdapter);
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_attention;
    }

    public void setData(List<ListNotify.DataBean> data) {
        mData = data;
    }
}
