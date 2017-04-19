package com.example.hao.surprise;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hao.surprise.adapter.TabFragmentAdapter;
import com.example.hao.surprise.fragments.BirthdayFragment;
import com.example.hao.surprise.fragments.CircleFragment;
import com.example.hao.surprise.fragments.MyFragment;
import com.example.hao.surprise.fragments.PresentFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String[] tabTitles = new String []{"生日", "礼物", "圈子", "我的"};

    private TabLayout tabLayout;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitTabFragment();
    }

    public void InitTabFragment(){
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText(tabTitles[0]));
        tabLayout.addTab(tabLayout.newTab().setText(tabTitles[1]));
        tabLayout.addTab(tabLayout.newTab().setText(tabTitles[2]));
        tabLayout.addTab(tabLayout.newTab().setText(tabTitles[3]));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabSelected: " + tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new BirthdayFragment());
        fragments.add(new CircleFragment());
        fragments.add(new PresentFragment());
        fragments.add(new MyFragment());

        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(),
                fragments, tabTitles);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(tabFragmentAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
