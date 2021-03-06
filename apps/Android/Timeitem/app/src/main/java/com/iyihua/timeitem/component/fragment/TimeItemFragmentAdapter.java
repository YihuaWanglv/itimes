package com.iyihua.timeitem.component.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iyihua.timeitem.R;
import com.iyihua.timeitem.frame.nav.ContentFragment;

public class TimeItemFragmentAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 1;
    private final Context c;

    public TimeItemFragmentAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
//        NUM_ITEMS = item_count;
        c = context;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return TimeItemFragment.newInstance();
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return c.getString(R.string.tab) + " " + String.valueOf(position + 1);
    }

}
