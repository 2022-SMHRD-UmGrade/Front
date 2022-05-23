package com.example.umgrade.userActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.AccountSettingActivity;
import com.example.umgrade.MoreActivity;
import com.example.umgrade.PaymentActivity;
import com.example.umgrade.ProfileUpdateActivity;
import com.example.umgrade.R;
import com.example.umgrade.UsageHistoryActivity;
import com.example.umgrade.community.CommuActivity;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.vo.User;

public class MypageActivity extends AppCompatActivity {

    Button btnProfileUpdate, btnPayment, btnUsageHistory, btnAccountSetting, btnLogout;
    Button navMain, navCommu, navMypage, navMore;
    TextView tvNickMypageCard, tvUserId, tvRatingMypageCard, tvPointMypageCard, tvCouponMypageCard;
    ImageView imgMypageProfile;
    User vo;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btnProfileUpdate = findViewById(R.id.btnProfileUpdate); //프로필 수정
        imgMypageProfile = findViewById(R.id.imgProfileChange); //프로필이미지
        btnPayment = findViewById(R.id.btnPayment); // 결제관리
        btnUsageHistory = findViewById(R.id.btnUsageHistory); // 이용내역
        btnAccountSetting = findViewById(R.id.btnAccountSetting); // 계정설정
        btnLogout = findViewById(R.id.btnLogout); // 로그아웃

        tvNickMypageCard = findViewById(R.id.tvNickMypageCard); // 닉네임
        tvUserId = findViewById(R.id.tvUserId); // ID
        tvRatingMypageCard = findViewById(R.id.tvRatingMypageCard); // 회원 등급
        tvPointMypageCard = findViewById(R.id.tvPointMypageCard); // 보유 포인트
        tvCouponMypageCard = findViewById(R.id.tvCouponMypageCard); // 보유 쿠폰

        vo = UserInfo.info;
        Log.d("vo1", vo.toString());

        queue = Volley.newRequestQueue(MypageActivity.this);

        Intent intent = getIntent();
        String nick = intent.getStringExtra("user_nick");

        tvNickMypageCard.setText(vo.getUser_nick());
        tvUserId.setText(vo.getUser_id());
        tvRatingMypageCard.setText(vo.getUser_type());
        tvPointMypageCard.setText(vo.getUser_point());
        String user_id = vo.getUser_id();



        // 출력된 값과 수정한 값이 다를 때만 닉네임 변경
//        if (!tvNickMypageCard.equals(nickUpdate)){
//            tvNickMypageCard.setText(nickUpdate);
//        }

        // 프로필 수정 페이지 이동
        btnProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 닉네임 저장
                vo = UserInfo.info;
                // 닉네임 값을 수정페이지로 전달
                Intent intent = new Intent(MypageActivity.this, ProfileUpdateActivity.class);
                intent.putExtra("nick", vo.getUser_nick());
                Log.d("vo2", vo.toString());
                // 화면전환
                startActivity(intent);
            }
        });

        // 결제관리 페이지 이동
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, PaymentActivity.class);
                intent.putExtra("user_id", user_id);
                startActivity(intent);
            }
        });

        // 이용내역 페이지 이동
        btnUsageHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, UsageHistoryActivity.class);
                startActivity(intent);
            }
        });

        // 계정설정 페이지 이동
        btnAccountSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, AccountSettingActivity.class);
                startActivity(intent);
            }
        });

        // 로그아웃
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo.info = vo;
                String text = btnLogout.getText().toString(); // 로그아웃 버튼 텍스트
                if (text.equals("로그아웃")) {
                    vo = null;
                    Toast.makeText(MypageActivity.this,
                            "로그아웃 되었습니다.",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MypageActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    btnLogout.setText("로그인");
                } else if (text.equals("로그인")) {
                    if (vo == null) {
                        Intent intent = new Intent(MypageActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    btnLogout.setText("로그아웃");
                }

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
                Intent intent = new Intent(MypageActivity.this, CommuActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MypageActivity.this, MoreActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });


    }

    public static Bitmap StringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}