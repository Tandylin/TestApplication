package com.example.lin.testapplication.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.entity.ImageBean;

import java.util.List;

/**
 * Created by 101912 on 2017/7/31.
 */

public class GridviewAdapter extends BaseAdapter {


    private List<ImageBean> data;
    private Context context;
    private LayoutInflater layoutInflater;

    public GridviewAdapter(Context context) {
        super();
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.gridview_item, parent, false);
            holder.image = (ImageView) convertView.findViewById(R.id.iv_item_image);
            holder.imageDes = (TextView) convertView.findViewById(R.id.tv_image_des);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image.setImageResource(R.drawable.ic_modify);
        holder.imageDes.setText(data.get(position).getImageDes());
        return convertView;
    }



    class ViewHolder {
        TextView imageDes;
        ImageView image;
    }

    public void setData(List<ImageBean> data) {
        this.data = data;
    }
}
