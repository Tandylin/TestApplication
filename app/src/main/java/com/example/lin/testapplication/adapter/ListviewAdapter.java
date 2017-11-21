package com.example.lin.testapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.entity.Person;

import java.util.List;

/**
 * Created by 101912 on 2017/7/31.
 */

public class ListviewAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    private List<Person> data;
    Context context;

    public ListviewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    //每绘制一个item就会调用一次
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.adapter_item, parent, false);
            holder.button = (Button) convertView.findViewById(R.id.button);
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            //将新的item保存
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setText(data.get(position).getName());
        holder.button.setText(data.get(position).getAge());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getAge(), Toast.LENGTH_LONG);
                //Log.d("TAG", data.get(position).getAge());
            }
        });
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    //在绘制listview前调用，获取item个数
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Person getItem(int position) {
        return data.get(position);
    }

    public final class ViewHolder {
        TextView textView;
        Button button;

        public ViewHolder() {

        }
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

    public List<Person> getData() {
        return data;
    }



}
