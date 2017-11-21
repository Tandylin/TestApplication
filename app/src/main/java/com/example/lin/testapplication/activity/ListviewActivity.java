package com.example.lin.testapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.adapter.ListviewAdapter;
import com.example.lin.testapplication.base.BaseActivity;
import com.example.lin.testapplication.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 101912 on 2017/7/31.
 */

public class ListviewActivity extends BaseActivity {

    private ListView listView;
    private List<Person> data;
    private ListviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initData();
        adapter = new ListviewAdapter(this);
        adapter.setData(data);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        addHeaderView();
    }

    private void addHeaderView() {
        View view = LayoutInflater.from(this).inflate(R.layout.header, null, false);
        listView.addHeaderView(view);
    }



    private void initData() {
        data = new ArrayList<>();
        for(int i = 0; i < 15; i ++) {
            Person p = new Person();
            String name = "name is " + i;
            String age = "age is " + i;
            p.setName(name);
            p.setAge(age);
            data.add(p);
        }
    }


}
