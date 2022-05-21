package com.example.umgrade.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.umgrade.FareActivity;
import com.example.umgrade.MoreActivity;
import com.example.umgrade.MoreFragment;
import com.example.umgrade.R;
import com.example.umgrade.community.CommuActivity;
import com.example.umgrade.communityFrag.CommuFragment;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.mainFrag.MainFragment;
import com.example.umgrade.notice.NoticeActivity;
import com.example.umgrade.service.ServiceActivity;
import com.example.umgrade.service.SupportActivity;
import com.example.umgrade.userActivity.MypageFragment;
import com.example.umgrade.vo.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavMain;
    ImageView imgMypageProfile;
    Button btnFare, btnServiceCard, btnNoticeEvent, btnMapCard, btnQrCard, btnSupportCard;
    View myPageLayout;

    View btnFareLayout;
    User vo = UserInfo.info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavMain = findViewById(R.id.bottomNavMain);

        // 마이페이지 카드 클릭 시 frag_mypage로 이동
        myPageLayout = findViewById(R.id.myPageLayout);

        myPageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.v("tetetetetet","teteltetet");
                //((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.container, MainActivity.frag_mypage).commit();
                //MypageFragment frag_mypage = new MypageFragment();
                //((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_mypage).commit();
            }
        });

        btnServiceCard = findViewById(R.id.btnServiceCard);
        // 서비스안내 클릭 시 화면전환
        btnServiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        btnNoticeEvent = findViewById(R.id.btnNoticeEvent);
        // 공지&이벤트 클릭 시 화면전환
        btnNoticeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        btnMapCard = findViewById(R.id.btnMapCard);
        // 보관함 찾기 클릭 시 화면전환
        btnMapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        btnSupportCard = findViewById(R.id.btnSupportCard);
        // 고객센터 클릭 시 화면전환
        btnSupportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SupportActivity.class);
                startActivity(intent);
            }
        });

        btnQrCard = findViewById(R.id.btnQrCard);
        // QR스캔 클릭 시 화면전환
        btnQrCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QrActivity.class);
                startActivity(intent);
            }
        });


        imgMypageProfile = (ImageView) findViewById(R.id.imgMypageProfile);
        Glide.with(this).load(R.drawable.logoumbrella).circleCrop().into(imgMypageProfile);

        btnFare = findViewById(R.id.btnFare);
        // 로그인 시 btnFare에 "오늘까지의 UM-CYCLE 이용 요금은 n,nnn원 입니다." 출력
        btnFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 요금 안내 페이지로 이동
                Intent intent = new Intent(MainActivity.this, FareActivity.class);
                startActivity(intent);
            }
        });


        // 프래그먼트 전환
        bottomNavMain.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.fragMain){
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragCommu){
                    Intent intent = new Intent(MainActivity.this, CommuActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragMyPage){
//                    Intent intent = new Intent(MoreActivity.this, MainActivity.class);
//                    startActivity(intent);
                } else if (itemId == R.id.fragMore){
                    Intent intent = new Intent(MainActivity.this, MoreActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        }); // bottomNav end
    }
}