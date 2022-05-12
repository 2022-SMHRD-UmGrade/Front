package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ModifyActivity extends AppCompatActivity {
    Button btnModifyCancel, btnModifySend;
    ImageButton btnModifyCamera, btnModifyGallary;
    Fragment CommuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        btnModifyCancel = findViewById(R.id.btnModifyCancel);
        btnModifySend = findViewById(R.id.btnModifySend);
        btnModifyCamera = findViewById(R.id.btnModifyCamera);
        btnModifyGallary = findViewById(R.id.btnModifyGallary);
        CommuFragment = new Fragment();

        // 취소 버튼 누르면 이전 화면으로
        btnModifyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 글 전송
        btnModifySend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // 카메라 호출
        btnModifyCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        // 갤러리 호출
        btnModifyGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivity(intent);
            }
        });
    }
}