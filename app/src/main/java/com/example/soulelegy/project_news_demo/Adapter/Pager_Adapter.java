package com.example.soulelegy.project_news_demo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Soul elegy on 2017/8/10.
 */

public class Pager_Adapter extends FragmentPagerAdapter{
    private List<Fragment> data;

    public Pager_Adapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    public Pager_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
