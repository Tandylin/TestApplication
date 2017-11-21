package com.example.lin.testapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lin.testapplication.base.BaseFragment;

import java.util.List;

/**
 * Created by 101912 on 2017/8/2.
 */

public class ViewPagerAdapter<T extends BaseFragment> extends FragmentPagerAdapter {

    private List<T> fragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setViews(List<T> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
