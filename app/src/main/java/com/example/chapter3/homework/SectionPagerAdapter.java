package com.example.chapter3.homework;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

public class SectionPagerAdapter extends FragmentStatePagerAdapter {

    private static final int PAGE_COUNT = 4;
    private static String[] tabs = {"tab1", "tab2", "tab3", "tab4"};

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int i) {
        return PlaceholderFragment.newInstance(tabs[i]);
    }

    // 加了下面的就不行了??
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//        return false;
//    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
