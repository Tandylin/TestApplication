package com.example.lin.testapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lin.testapplication.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 101912 on 2017/7/26.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_FOOTER = 2;

    private int MAX = 15;

    private ArrayList<String> mDatas = new ArrayList<>();

    private View mHeaderView;

    private View mFooterView;

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setFooterView(View footerView) {
        mFooterView = footerView;
        if (mHeaderView == null)
            notifyItemInserted(mDatas.size());
        else
            notifyItemInserted(mDatas.size() + 1);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void removeHeaderView() {
        mHeaderView = null;
        notifyItemRemoved(0);
    }

    public void removeFooterView() {
        mFooterView = null;
        if (mHeaderView == null)
            notifyItemRemoved(mDatas.size());
        else
            notifyItemRemoved(mDatas.size() + 1);
    }

    public void addDatas(List<String> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0 && mHeaderView != null) {
            return TYPE_HEADER;
        }
        if (mFooterView != null) {
            if (mHeaderView == null && mDatas.size() == position) {
                return TYPE_FOOTER;
            }
            if (mHeaderView != null && position == mDatas.size() + 1)
                return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new Holder(mHeaderView);
        if (mFooterView != null && viewType == TYPE_FOOTER) return new Holder(mFooterView);
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        if (getItemViewType(position) == TYPE_FOOTER) return;
        final int pos = getRealPosition(viewHolder);
        final String data = mDatas.get(pos);
        if(viewHolder instanceof Holder) {
            ((Holder) viewHolder).text.setText(data);
            if(mListener == null) return;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos, data);
                }
            });
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        if (mHeaderView != null && mFooterView != null)
            return mDatas.size() + 2;
        if (mHeaderView == null && mFooterView != null)
            return mDatas.size() + 1;
        if (mHeaderView != null && mFooterView == null)
            return mDatas.size() + 1;
        return mDatas.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView text;

        public Holder(View itemView) {
            super(itemView);
            if(itemView == mHeaderView) return;
            text = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    interface OnItemClickListener {
        void onItemClick(int position, String data);
    }
}
