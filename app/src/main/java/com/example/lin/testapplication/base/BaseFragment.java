package com.example.lin.testapplication.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by 101912 on 2017/8/2.
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment {

    public BaseLayout baseLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        baseLayout = new BaseLayout(getActivity());
        View view = setContentView(inflater, container, savedInstanceState);
        baseLayout.addContentView(view);
        return baseLayout;
    }


    public abstract View setContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
