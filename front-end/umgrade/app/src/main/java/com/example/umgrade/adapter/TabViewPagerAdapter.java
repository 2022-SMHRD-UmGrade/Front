package com.example.umgrade.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.umgrade.EventFragment;
import com.example.umgrade.NoticeFragment;

import java.util.ArrayList;

public class TabViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> tabList = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();

    public TabViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        tabList.add(new NoticeFragment());
        tabList.add(new EventFragment());

        name.add("공지사항");
        name.add("이벤트");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return name.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabList.get(position);
    }

    @Override
    public int getCount() {
        return tabList.size();
    }
}

