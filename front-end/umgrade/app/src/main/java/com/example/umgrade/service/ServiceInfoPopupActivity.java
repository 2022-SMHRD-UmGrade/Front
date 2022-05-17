package com.example.umgrade.service;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.umgrade.R;

public class ServiceInfoPopupActivity extends AppCompatActivity {

    Button servicePopupClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info_popup);

        servicePopupClose = findViewById(R.id.servicePopupClose);
        servicePopupClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
            }
        });
    }
}