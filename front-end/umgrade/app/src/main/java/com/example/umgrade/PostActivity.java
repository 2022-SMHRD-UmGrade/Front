package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PostActivity extends AppCompatActivity {
    ImageView imgPostProfile;
    Button btnPostModify, btnPostComment;
    TextView tvPostTitle, tvPostNick, tvPostId, tvPostTime, tvPostClicks, tvPostContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        btnPostModify = findViewById(R.id.btnPostModify);
        btnPostComment = findViewById(R.id.btnPostComment);
        tvPostTitle = findViewById(R.id.tvPostTitle);
        tvPostNick = findViewById(R.id.tvPostNick);
        tvPostTime = findViewById(R.id.tvPostTime);
        tvPostClicks = findViewById(R.id.tvPostClicks);
        tvPostContent = findViewById(R.id.tvPostContent);
        tvPostId = findViewById(R.id.tvPostId);

        // 프로필 사진 원형으로
        imgPostProfile = (ImageView) findViewById(R.id.imgPostProfile);
        Glide.with(this).load(R.drawable.umbrella).circleCrop().into(imgPostProfile);

        // 사용자 ID와 작성자 ID 일치할 때만 btnPostModify 버튼 활성화
        String Userid = tvPostId.getText().toString();

        if (Userid.equals("ID***")){
            btnPostModify.setVisibility(View.VISIBLE);
        }else{
            btnPostModify.setVisibility(View.GONE);
        }

    }
}