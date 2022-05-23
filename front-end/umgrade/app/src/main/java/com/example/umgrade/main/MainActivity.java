package com.example.umgrade.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.umgrade.FareActivity;
import com.example.umgrade.MoreActivity;
import com.example.umgrade.R;
import com.example.umgrade.community.CommuActivity;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.notice.NoticeActivity;
import com.example.umgrade.service.ServiceActivity;
import com.example.umgrade.service.SupportActivity;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.vo.User;

public class MainActivity extends AppCompatActivity {

    ImageView imgMypageProfile;
    Button btnFare, btnServiceCard, btnNoticeEvent, btnMapCard, btnQrCard, btnSupportCard;
    Button navMain, navCommu, navMypage, navMore;
    TextView tvNickMypageCard, tvRatingMypageCard, tvPointMypageCard, tvWeather, dateView, cityView, weatherView, tempView;
    View myPageLayout;

    View btnFareLayout;
    User vo;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vo = UserInfo.info;

        tvNickMypageCard = findViewById(R.id.tvNickMypageCard);
        tvRatingMypageCard = findViewById(R.id.tvRatingMypageCard);
        tvPointMypageCard = findViewById(R.id.tvPointMypageCard);
        tvWeather = findViewById(R.id.tvWeather);

        tvNickMypageCard.setText(vo.getUser_nick());
        tvRatingMypageCard.setText(vo.getUser_type());
        tvPointMypageCard.setText(vo.getUser_point());
    
        queue = Volley.newRequestQueue(MainActivity.this);

        Intent intent = getIntent();

        // 마이페이지 카드 클릭 시 mypage로 이동
        myPageLayout = findViewById(R.id.myPageLayout);


        myPageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MypageActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
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
                finish();
            }
        });

        btnNoticeEvent = findViewById(R.id.btnNoticeEvent);
        // 공지&이벤트 클릭 시 화면전환
        btnNoticeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnMapCard = findViewById(R.id.btnMapCard);
        // 보관함 찾기 클릭 시 화면전환
        btnMapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSupportCard = findViewById(R.id.btnSupportCard);
        // 고객센터 클릭 시 화면전환
        btnSupportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SupportActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnQrCard = findViewById(R.id.btnQrCard);
        // QR스캔 클릭 시 화면전환
        if(vo.getUser_type().equals("P")) {
            btnQrCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, QrActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        else {
            Toast.makeText(this,
                    "결재정보를 입력해주세요",
                    Toast.LENGTH_SHORT).show();
        }
       


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
                finish();
            }
        });
        // 페이지 전환
        navMain = findViewById(R.id.navMain);
        navCommu = findViewById(R.id.navCommu);
        navMypage = findViewById(R.id.navMypage);
        navMore = findViewById(R.id.navMore);

        navCommu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CommuActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MypageActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoreActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}




