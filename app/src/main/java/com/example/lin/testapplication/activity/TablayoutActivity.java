package com.example.lin.testapplication.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.adapter.ViewPagerAdapter;
import com.example.lin.testapplication.base.BaseActivity;
import com.example.lin.testapplication.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 101912 on 2017/8/2.
 */

public class TablayoutActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<MyFragment> fragments;

    @Override
    public void initView() {
        setContentView(R.layout.activity_tablayout);
        baseLayout.setTopLayoutVisibility(View.GONE);
        tabLayout = (TabLayout) findViewById(R.id.tl_tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
    }

    @Override
    public void initAdapter() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragments = new ArrayList<>();
        MyFragment myFragment1 = new MyFragment();
        MyFragment myFragment2 = new MyFragment();
        MyFragment myFragment3 = new MyFragment();
        MyFragment myFragment4 = new MyFragment();
        MyFragment myFragment5 = new MyFragment();
        MyFragment myFragment6 = new MyFragment();
        MyFragment myFragment7 = new MyFragment();
        MyFragment myFragment8 = new MyFragment();
        fragments.add(myFragment1);
        fragments.add(myFragment2);
        fragments.add(myFragment3);
        fragments.add(myFragment4);
        fragments.add(myFragment5);
        fragments.add(myFragment6);
        fragments.add(myFragment7);
        fragments.add(myFragment8);
        viewPagerAdapter.setViews(fragments);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("11");
        tabLayout.getTabAt(1).setText("22");
        tabLayout.getTabAt(2).setText("33");
        tabLayout.getTabAt(3).setText("44");
        tabLayout.getTabAt(4).setText("55");
        tabLayout.getTabAt(5).setText("66");
        tabLayout.getTabAt(6).setText("77");
        tabLayout.getTabAt(7).setText("88");
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    public void setData() {
        super.setData();
    }
}
