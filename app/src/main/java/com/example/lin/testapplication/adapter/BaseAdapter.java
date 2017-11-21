package com.example.lin.testapplication.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 101912 on 2017/8/8.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    protected List<T> mData = new ArrayList<>();

    public BaseAdapter() {
        mData = new ArrayList<>();

    }

    public void updateData(List data) {
        mData.clear();
        appendData(data);
    }

    public void appendData(List data) {
            mData.addAll(data);
            notifyDataSetChanged();
    }

    public void setmData(List data) {
        mData = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
