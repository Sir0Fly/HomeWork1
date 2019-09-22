package com.example.yaoyufei.homework1.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private ArrayList<Fragment> list;
    private ArrayList<String> title = new ArrayList<>();

    public MyFragmentStatePagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
        this.notifyDataSetChanged();
    }

    public MyFragmentStatePagerAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> title) {
        super(fm);
        this.list = list;
        this.title=title;
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

/*    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (title.size() > 0) {
            return title.get(position);
        }
            return super.getPageTitle(position);
    }*/
}
