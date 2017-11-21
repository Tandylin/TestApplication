package com.example.lin.testapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.base.BaseFragment;

/**
 * Created by 101912 on 2017/7/28.
 */

public class MyFragment extends BaseFragment {


    @Override
    public View setContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        baseLayout.setTopLayoutVisibility(View.GONE);
        return inflater.inflate(R.layout.fragment_my, null);
    }
}
