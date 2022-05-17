package com.example.umgrade.service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.umgrade.R;

public class SupportWriteActivity extends AppCompatActivity {

    Button btnSupportCancel, btnSupportSend;
    EditText edtSupportTitle, edtSupportContent;
    TextView tvSupportCount;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_write);

        btnSupportCancel = findViewById(R.id.btnSupportCancel);
        btnSupportSend = findViewById(R.id.btnSupportSend);
        edtSupportTitle = findViewById(R.id.edtSupportTitle);
        edtSupportContent = findViewById(R.id.edtSupportContent);
        tvSupportCount = findViewById(R.id.tvSupportCount); // 글자 수 카운트

        // 취소 버튼 누르면 이전 화면으로
        btnSupportCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 전송 버튼 누르면 데이터 전송
        btnSupportSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}