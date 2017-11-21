package com.example.lin.testapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lin.testapplication.R;

import java.util.List;

/**
 * Created by 101912 on 2017/8/7.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> data;
    private OnItemClickListener itemClickListener;

    public RecyclerviewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).textView.setText(data.get(position));
            if (itemClickListener != null) {
                ((ViewHolder) holder).button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClickListener.onItemClick(data, position);
                    }
                });
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_item, parent, false);
            return new ViewHolder(view);
        } else {
            return null;
        }
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(List<String> data, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Button button;

        public ViewHolder(View view) {
            super(view);
            button = (Button) view.findViewById(R.id.button);
            textView = (TextView)view.findViewById(R.id.textView);
        }
    }
}
