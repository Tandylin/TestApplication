package com.example.lin.testapplication.activity;

import android.app.ActionBar;
import android.app.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lin.testapplication.R;

import com.example.lin.testapplication.adapter.HeaderAndFooterWrapper;
import com.example.lin.testapplication.adapter.MyAdapter;
import com.example.lin.testapplication.adapter.RecyclerviewAdapter;
import com.example.lin.testapplication.base.BaseActivity;
import com.example.lin.testapplication.broadcast.MyBroadcastReceiver;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    RecyclerView recyclerView ;
    List<String> data;
    MyAdapter myAdapter;
   // MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout.setTopLayoutVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) findViewById(R.id.list_item);
        data = new ArrayList<>();
        myAdapter = new MyAdapter();
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setItemAnimator(new DefaultItemAnimator());
        /*View footer = LayoutInflater.from(this).inflate(R.layout.activity_test, recyclerView, false);
        TextView v = new TextView(this);
        v.setText("这是头部~");
        v.setTextSize(20);*/
        recyclerView.setAdapter(myAdapter);
        myAdapter.addDatas(data);
        /*myAdapter.setFooterView(footer);
        myAdapter.setHeaderView(v);*/
        /*myAdapter.setOnItemClickListener(new HeaderAndFooterWrapper.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                Toast.makeText(MainActivity.this, "data is :" + String.valueOf(data), Toast.LENGTH_LONG).show();
            }
        });*/

        /*View header = LayoutInflater.from(this).inflate(R.layout.header, null);
        myAdapter.setHeaderView(header);*/

       /* Intent intent = new Intent("lin");
        sendBroadcast(intent, null);*/
        /*FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.id, );
        transaction.commit();*/

    }

    protected void initData() {
        /*for (int i = 'A'; i < 'z'; i++)
        {
            data.add("" + (char) i);
        }*/
        for (int i = 1; i < 51; i ++) {
            data.add("fjdlk" + i);
        }
/*        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("CLOSED");
        intentFilter.setPriority(1000);
        myBroadcastReceiver = new MyBroadcastReceiver();
        //注册广播接收器，在onCreate或onResume中
        registerReceiver(myBroadcastReceiver, intentFilter);*/
    }





/*
    @Override
    protected void onPause() {
        super.onPause();
        //取消广播接受者
        //动态注册一定要在onPause或onDestroy中取消
        //unregisterReceiver(myBroadcastReceiver);
    }*/
}
