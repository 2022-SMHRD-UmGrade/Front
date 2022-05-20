package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.User;

public class PayViewActivity extends AppCompatActivity {
    WebView webView;
    Button btnPayview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_view);

        webView = findViewById(R.id.webView);
        //btnPayview = findViewById(R.id.btnPayview);

        User vo = UserInfo.info;
        Intent intent = getIntent();
        String user_id = intent.getStringExtra("user_id");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); //자바스크립트 사용허용

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://220.80.203.18:8081/myapp/pay?id="+user_id);

    }
}