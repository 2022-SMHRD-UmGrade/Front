package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SupportActivity extends AppCompatActivity {
    
    Button btnSupportWrite;
    TextView supportTitle, tvSet, supportTime, supportSeq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        btnSupportWrite = findViewById(R.id.btnSupportWrite);
        
        // 문의 버튼 누르면 페이지 이동
        btnSupportWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupportActivity.this, SupportWriteActivity.class);
                startActivity(intent);
            }
        });
        
        supportTitle = findViewById(R.id.supportTitle); // 글제목
        tvSet = findViewById(R.id.tvSet); // 문의 처리여부 표시
        supportTime = findViewById(R.id.supportTime); // 글작성시각
        supportSeq = findViewById(R.id.supportTime); // 글번호

        // 문의 처리여부에 따라 텍스트뷰 색상 변경
        if(tvSet.getText().toString().equals("처리중")){
            tvSet.setTextColor(Color.BLACK);
            tvSet.setBackgroundResource(R.drawable.roundblack);
        } else if(tvSet.getText().toString().equals("완료")) {
            tvSet.setTextColor(Color.WHITE);
            tvSet.setBackgroundResource(R.drawable.round);
        }

    }
}