package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.umgrade.info.UserInfo;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.vo.User;

public class PayViewActivity extends AppCompatActivity {
    WebView webView;
    Button btnPayview;
    String server_url2 = "http://192.168.43.209:8081/myapp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_view);

        webView = findViewById(R.id.webView);
        btnPayview = findViewById(R.id.btnPayview); // 닫기 버튼

        User vo = UserInfo.info;
        Intent intent = getIntent();
        String user_id = intent.getStringExtra("user_id");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); //자바스크립트 사용허용

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(server_url2+"/pay?id="+user_id);

        btnPayview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PayViewActivity.this, MypageActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}