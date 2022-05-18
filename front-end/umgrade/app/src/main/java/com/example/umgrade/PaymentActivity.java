package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PaymentActivity extends AppCompatActivity {
    
    ImageButton btnPaymentPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnPaymentPre = findViewById(R.id.btnPaymentPre); // 뒤로가기

        // 뒤로가기
        btnPaymentPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}