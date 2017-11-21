package com.example.lin.testapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.adapter.BaseAdapter;
import com.example.lin.testapplication.adapter.LoadMoreAdapterWrapper;
import com.example.lin.testapplication.adapter.MyLoadAdapter;
import com.example.lin.testapplication.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 101912 on 2017/8/8.
 */

public class RecycleViewActivity extends Activity {
/*
    RecyclerView recyclerView;
    BaseAdapter baseAdapter;
    int loadCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list_item);
        MyLoadAdapter myLoadAdapter = new MyLoadAdapter(this);
        baseAdapter = new LoadMoreAdapterWrapper(myLoadAdapter, new LoadMoreAdapterWrapper.OnLoad() {
            @Override
            public void load(int pagePosition, int pageSize, final LoadMoreAdapterWrapper.LoadCallBack callBack) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> data = new ArrayList<String>();
                        for (int i = 0; i < 15; i++) {
                            data.add("data is" + i);
                        }
                        baseAdapter.appendData(data);
                        callBack.onSuccess();
                        loadCount++;
                        if (loadCount > 3)
                            callBack.onFailure();
                    }
                }, 2000);
            }
        });
       *//* List<String> mData = new ArrayList<>();
        mData.add("lksjdfl");
        mData.add("lksjdfl");
        mData.add("lksjdfl");
        mData.add("lksjdfl");
        mData.add("lksjdfl");
        baseAdapter.updateData(mData);*//*
        recyclerView.setAdapter(baseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }*/

    List<String> data;
    RecyclerView recyclerView;
    TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list_item);
        adapter = new TestAdapter(this);
        data = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
