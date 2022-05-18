package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AccountSettingActivity extends AppCompatActivity {
    
    ImageButton btnAccountSettingPre;
    Button btnPasswordChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        btnAccountSettingPre = findViewById(R.id.btnAccountSettingPre); // 뒤로가기
        btnPasswordChange = findViewById(R.id.btnPasswordChange); // 비밀번호 변경

        // 뒤로가기
        btnAccountSettingPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 비밀번호 변경 페이지 이동
        btnPasswordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountSettingActivity.this, PasswordChangeActivity.class);
                startActivity(intent);
            }
        });
    }
}