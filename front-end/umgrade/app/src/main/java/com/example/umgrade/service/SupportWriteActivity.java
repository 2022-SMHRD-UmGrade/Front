package com.example.umgrade.service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        btnSupportCancel = findViewById(R.id.btnSupportCancel); // 취소버튼
        btnSupportSend = findViewById(R.id.btnSupportSend); // 전송버튼
        edtSupportTitle = findViewById(R.id.edtSupportTitle); // 제목
        edtSupportContent = findViewById(R.id.edtSupportContent); // 본문
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

        // 글자 수 카운트
        edtSupportContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // edtSupportContent(본문) 텍스트 길이를 tvSupportCount에 넣음
                String input = edtSupportContent.getText().toString();
                tvSupportCount.setText(input.length()+" / 1000");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}