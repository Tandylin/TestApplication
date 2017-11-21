package com.example.lin.testapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lin.testapplication.R;

/**
 * Created by 101912 on 2017/8/8.
 */

public class LoadMoreAdapterWrapper extends BaseAdapter<String> {

    private static final int TYPE_LOAD = 1;
    private static final int TYPE_NOMOER = 2;

    private BaseAdapter mAdapter;
    private OnLoad onLoad;
    private boolean isMoreData = true;
    private int mPagePosition = 0;  //页数
    private int mPageSize = 15;

    public LoadMoreAdapterWrapper(BaseAdapter baseAdapter, OnLoad onLoad) {
        mAdapter = baseAdapter;
        this.onLoad = onLoad;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mData.size()) {
            if (isMoreData)
                return TYPE_LOAD;
            else
                return TYPE_NOMOER;
        }
        return mAdapter.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_LOAD)
            loadMoreData(mPagePosition, mPageSize);
        else if (getItemViewType(position) == TYPE_NOMOER) {

        } else
            mAdapter.onBindViewHolder(holder, position);
    }

    private void loadMoreData(int pagePosition, int pageSize) {
        if (onLoad != null) {
            onLoad.load(pagePosition, pageSize, new LoadCallBack() {
                @Override
                public void onSuccess() {
                    mPagePosition = mPagePosition + mPageSize;
                    isMoreData = true;
                    notifyDataSetChanged();
                }

                @Override
                public void onFailure() {
                    isMoreData = false;
                }
            });
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LOAD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_test, parent, false);
            return new LoadHolder(view);
        }
        if (viewType == TYPE_NOMOER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_hint, parent, false);
            return new LoadHolder(view);
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount() + 1;
    }

    class LoadHolder extends RecyclerView.ViewHolder {
        public LoadHolder(View view) {
            super(view);
        }
    }

    public interface OnLoad {
        void load(int pagePosition, int pageSize, LoadCallBack callBack);
    }

    public interface LoadCallBack {
        void onSuccess();

        void onFailure();
    }
}
