package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.umgrade.community.CommuActivity;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.main.MapActivity;
import com.example.umgrade.main.QrActivity;
import com.example.umgrade.notice.NoticeActivity;
import com.example.umgrade.service.ServiceActivity;
import com.example.umgrade.service.SupportActivity;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.vo.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MoreActivity extends AppCompatActivity {

    Button btnMoreUserInfo, btnMoreSearch, btnMoreQr, btnMoreCommu,
            btnMoreNotice, btnMoreService, btnMoreSupport, btnMoreTerms;
    Button navMain, navCommu, navMypage, navMore;
    TextView tvMoreNick;
    ImageView imgMoreProfile;
    User vo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        vo = UserInfo.info;

        btnMoreUserInfo = findViewById(R.id.btnMoreUserInfo);
        btnMoreSearch = findViewById(R.id.btnMoreSearch);
        btnMoreQr = findViewById(R.id.btnMoreQr);
        btnMoreCommu = findViewById(R.id.btnMoreCommu);
        btnMoreNotice = findViewById(R.id.btnMoreNotice);
        btnMoreService = findViewById(R.id.btnMoreService);
        btnMoreSupport = findViewById(R.id.btnMoreSupport);
        btnMoreTerms = findViewById(R.id.btnMoreTerms);
        tvMoreNick = findViewById(R.id.tvMoreNick);

        tvMoreNick.setText(vo.getUser_nick());

        imgMoreProfile = (ImageView) findViewById(R.id.imgMoreProfile);
        // ????????? ????????????
        Glide.with(this).load(R.drawable.logoumbrella).circleCrop().into(imgMoreProfile);

        // ??????????????????
        btnMoreUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ??????????????? ?????? ??????????????????
                Intent intent = new Intent(MoreActivity.this, AccountSettingActivity.class);
                startActivity(intent);
            }
        });

        // ???????????????
        btnMoreSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        // QR??????
        btnMoreQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, QrActivity.class);
                startActivity(intent);
            }
        });

        // ????????????
        btnMoreCommu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ???????????? ?????????????????? ??????
                Intent intent = new Intent(MoreActivity.this, CommuActivity.class);
                startActivity(intent);
            }
        });

        // ??????&?????????
        btnMoreNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        // ???????????????
        btnMoreService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        // ????????????
        btnMoreSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, SupportActivity.class);
                startActivity(intent);
            }
        });

        // ????????????
        btnMoreTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, TermsActivity.class);
                startActivity(intent);
            }
        });

        // ????????? ??????
        navMain = findViewById(R.id.navMain);
        navCommu = findViewById(R.id.navCommu);
        navMypage = findViewById(R.id.navMypage);
        navMore = findViewById(R.id.navMore);

        navCommu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, CommuActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, MypageActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}