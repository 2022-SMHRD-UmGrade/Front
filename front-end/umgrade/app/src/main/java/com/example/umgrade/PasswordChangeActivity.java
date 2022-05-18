package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PasswordChangeActivity extends AppCompatActivity {

    ImageButton btnPasswordChangePre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        btnPasswordChangePre = findViewById(R.id.btnPasswordChangePre); // 뒤로가기

        // 뒤로가기
        btnPasswordChangePre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}