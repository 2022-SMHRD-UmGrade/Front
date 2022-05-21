package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.umgrade.community.CommuActivity;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.main.MapActivity;
import com.example.umgrade.main.QrActivity;
import com.example.umgrade.notice.NoticeActivity;
import com.example.umgrade.service.ServiceActivity;
import com.example.umgrade.service.SupportActivity;
import com.example.umgrade.userActivity.MypageActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MoreActivity extends AppCompatActivity {

    Button btnMoreUserInfo, btnMoreSearch, btnMoreQr, btnMoreCommu,
            btnMoreNotice, btnMoreService, btnMoreSupport, btnMoreTerms;
    ImageView imgMoreProfile;
    BottomNavigationView bottomNavMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        bottomNavMore = findViewById(R.id.bottomNavMore);

        btnMoreUserInfo = findViewById(R.id.btnMoreUserInfo);
        btnMoreSearch = findViewById(R.id.btnMoreSearch);
        btnMoreQr = findViewById(R.id.btnMoreQr);
        btnMoreCommu = findViewById(R.id.btnMoreCommu);
        btnMoreNotice = findViewById(R.id.btnMoreNotice);
        btnMoreService = findViewById(R.id.btnMoreService);
        btnMoreSupport = findViewById(R.id.btnMoreSupport);
        btnMoreTerms = findViewById(R.id.btnMoreTerms);

        imgMoreProfile = (ImageView) findViewById(R.id.imgMoreProfile);
        // 이미지 원형으로
        Glide.with(this).load(R.drawable.logoumbrella).circleCrop().into(imgMoreProfile);

        // 회원정보수정
        btnMoreUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 마이페이지 내부 수정페이지로
                Intent intent = new Intent(MoreActivity.this, AccountSettingActivity.class);
                startActivity(intent);
            }
        });

        // 보관함찾기
        btnMoreSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        // QR스캔
        btnMoreQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, QrActivity.class);
                startActivity(intent);
            }
        });

        // 커뮤니티
        btnMoreCommu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커뮤니티 프래그먼트로 이동
                Intent intent = new Intent(MoreActivity.this, CommuActivity.class);
                startActivity(intent);
            }
        });

        // 공지&이벤트
        btnMoreNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        // 서비스안내
        btnMoreService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        // 고객센터
        btnMoreSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, SupportActivity.class);
                startActivity(intent);
            }
        });

        // 약관확인
        btnMoreTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, TermsActivity.class);
                startActivity(intent);
            }
        });

        // 프래그먼트 전환
        bottomNavMore.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.fragMain){
                    Intent intent = new Intent(MoreActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragCommu){
                    Intent intent = new Intent(MoreActivity.this, CommuActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragMyPage){
                    Intent intent = new Intent(MoreActivity.this, MypageActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragMore){
                    Intent intent = new Intent(MoreActivity.this, MoreActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        }); // bottomNav end
    }
}