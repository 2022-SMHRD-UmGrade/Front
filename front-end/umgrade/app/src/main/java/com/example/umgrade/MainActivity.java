package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.umgrade.communityFrag.CommuFragment;
import com.example.umgrade.mainFrag.MainFragment;
import com.example.umgrade.userActivity.MypageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    MainFragment frag_main;
    CommuFragment frag_commu;
    MypageFragment frag_mypage;
    MoreFragment frag_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        frag_main = new MainFragment();
        frag_commu = new CommuFragment();
        frag_mypage = new MypageFragment();
        frag_more = new MoreFragment();

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
                } else if (itemId == R.id.fragMore){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_more).commit();
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