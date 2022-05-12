package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class WriteActivity extends AppCompatActivity {

    Button btnWriteCancel, btnWriteSend;
    ImageButton btnWriteCamera, btnWriteGallary;
    Fragment CommuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        btnWriteCancel = findViewById(R.id.btnWriteCancel);
        btnWriteSend = findViewById(R.id.btnWriteSend);
        btnWriteCamera = findViewById(R.id.btnWriteCamera);
        btnWriteGallary = findViewById(R.id.btnWriteGallary);
        CommuFragment = new Fragment();

        // 취소 버튼 누르면 이전 화면으로
        btnWriteCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 작성 글 전송
        btnWriteSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // 카메라 호출
        btnWriteCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        // 갤러리 호출
        btnWriteGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivity(intent);
            }
        });

    }
}