package com.example.yumatakahashi.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by yuma.takahashi on 2015/05/03.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 5;

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return SampleFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}