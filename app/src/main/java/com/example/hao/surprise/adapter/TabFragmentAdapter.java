package com.example.hao.surprise.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hao on 17-4-19.
 */

public class TabFragmentAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;

    private String[] tabTitles;

    public TabFragmentAdapter(FragmentManager fragmentManager, List<Fragment> fragments, String[] tabTmpTitles){
        super(fragmentManager);
        this.fragmentList = fragments;
        this.tabTitles = tabTmpTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles == null ? super.getPageTitle(position) : tabTitles[position];
    }
}
