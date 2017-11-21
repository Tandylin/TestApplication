package com.example.lin.testapplication.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lin.testapplication.base.BaseLayout;

/**
 * Created by 101912 on 2017/8/1.
 */

public  class BaseActivity extends FragmentActivity{

    public BaseLayout baseLayout;
    public BaseActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initView();
        setData();
        setListener();
        initAdapter();
    }

    public void setData() {

    }

    public void setListener() {

    }

    public void initView() {

    }

    public void initAdapter() {

    }

    @Override
    public void setContentView(int layoutResID) {
        baseLayout = new BaseLayout(this);
        //View v = View.inflate(this, layoutResID, null);
        View v = LayoutInflater.from(this).inflate(layoutResID, baseLayout.rl_top, false);
        baseLayout.addContentView(v);
        super.setContentView(baseLayout);
    }
}
