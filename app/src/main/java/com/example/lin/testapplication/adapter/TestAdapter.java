package com.example.lin.testapplication.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lin.testapplication.R;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * Created by 101912 on 2017/8/10.
 */

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> mData;//所有数据项
    List<String> rData;//当前已显示的数据项
    Context context;
    private boolean isMore = true;//是否还有下一页
    private int restCount;//剩余未显示的item数
    private int page = 1;//页数

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_LOAD = 1;
    private static final int TYPE_NOMORE = 2;
    private static final int pageCount = 15;//每页的item数


    public TestAdapter(Context context) {
        this.context = context;
        mData = new ArrayList<>();
        rData = new ArrayList<>();
        for (int i = 1; i <= 55; i++)
            mData.add("linziyuehenshuai " + i);
        for (int i = 0; i < pageCount; i++)
            rData.add(mData.get(i));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_NORMAL) {
            if (holder instanceof ViewHolder) {
                ((ViewHolder) holder).textView.setText(rData.get(position));
            }
        } else if (getItemViewType(position) == TYPE_LOAD) {
            loadData();
        } else
            return;
    }


    private void loadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                restCount = mData.size() - rData.size();
                List<String> lData = new ArrayList<>();
                if (restCount >= pageCount) {
                    for (int i = page * pageCount; i < (page + 1) * pageCount; i++)
                        lData.add(mData.get(i));
                    isMore = true;
                } else {
                    for (int i = page * pageCount; i < page * pageCount + restCount; i++)
                        lData.add(mData.get(i));
                    isMore = false;
                }
                page++;
                rData.addAll(lData);
                lData.clear();
                notifyDataSetChanged();
            }
        }, 2000);

    }

    @Override
    public int getItemViewType(int position) {
        if (position == rData.size()) {
            if (isMore)
                return TYPE_LOAD;
            else
                return TYPE_NOMORE;
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return rData.size() + 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_item, parent, false);
            return new ViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_test, parent, false);
            return new FooterViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.bottom_hint, parent, false);
            return new FooterViewHolder(view);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {


        public FooterViewHolder(View view) {
            super(view);

        }
    }

}
