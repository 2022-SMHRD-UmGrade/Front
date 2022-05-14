package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.app.Service;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    MainFragment frag_main;
    CommuFragment frag_commu;
    MypageFragment frag_mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        frag_main = new MainFragment();
        frag_commu = new CommuFragment();
        frag_mypage = new MypageFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, frag_main).commit();

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.fragMain){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_main).commit();
                } else if (itemId == R.id.fragCommu){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_commu).commit();
                } else if (itemId == R.id.fragMyPage){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_mypage).commit();
                }

                return true;
            }
        }); // bottomNav end


    }

    // 프래그먼트에서 사용하는 메소드
   public void changeMypage(MainFragment mainFragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, frag_mypage).commit();
   }


}