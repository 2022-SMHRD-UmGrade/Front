package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class UsageHistoryActivity extends AppCompatActivity {
    
    ImageButton btnUsageHistoryPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage_history);

        btnUsageHistoryPre = findViewById(R.id.btnUsageHistoryPre); // 뒤로가기

        // 뒤로가기
        btnUsageHistoryPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}