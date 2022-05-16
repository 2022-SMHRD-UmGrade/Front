package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupportActivity extends AppCompatActivity {
    
    Button btnSupportWrite;

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
    }
}