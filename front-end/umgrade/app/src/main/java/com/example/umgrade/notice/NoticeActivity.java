package com.example.umgrade.notice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.umgrade.R;
import com.example.umgrade.adapter.TabViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class NoticeActivity extends AppCompatActivity {

    ViewPager tabViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        tabViewpager = findViewById(R.id.tabViewpager);
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager());
        tabViewpager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.noticeTab);
        tabLayout.setupWithViewPager(tabViewpager);

        for (int i = 0; i<2; i++){
            tabLayout.getTabAt(i);
        }

    }
}