package com.example.lin.testapplication.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.adapter.GridviewAdapter;
import com.example.lin.testapplication.base.BaseActivity;
import com.example.lin.testapplication.entity.B;
import com.example.lin.testapplication.entity.C;
import com.example.lin.testapplication.entity.ImageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 101912 on 2017/8/1.
 */

public class GridViewActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private GridView gridView;
    private GridviewAdapter adapter;
    private List<ImageBean> data;

    @Override
    public void initView() {
        setContentView(R.layout.activity_gridview);
        gridView = (GridView) findViewById(R.id.gridview);
        //设置gridview列数为3
        gridView.setNumColumns(3);
        //设置两列之间的间隔为150dp
        gridView.setVerticalSpacing(150);
        //设置两行之间的间隔为150dp
        gridView.setHorizontalSpacing(150);
    }

    @Override
    public void setData() {
        data = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            ImageBean imageBean = new ImageBean();
            imageBean.setImageDes("这是第" + i + "张图片");
            data.add(imageBean);
        }

    }

    @Override
    public void initAdapter() {
        adapter = new GridviewAdapter(this);
        adapter.setData(data);
        gridView.setAdapter(adapter);
    }

    @Override
    public void setListener() {
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "linziyue", Toast.LENGTH_SHORT).show();
    }


}
