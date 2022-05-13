package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

public class PostActivity extends AppCompatActivity {
    ImageView imgPostProfile;
    Button btnPostModify, btnPostDelete, btnPostComment;
    TextView tvPostTitle, tvPostNick, tvPostId, tvPostTime, tvPostCnt, tvPostContent;

    RequestQueue queue;
    StringRequest request;

    Board dto;
    User vo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        btnPostModify = findViewById(R.id.btnPostModify);
        btnPostDelete = findViewById(R.id.btnPostDelete);
        btnPostComment = findViewById(R.id.btnPostComment);

        tvPostTitle = findViewById(R.id.tvPostTitle);
        tvPostNick = findViewById(R.id.tvPostNick);
        tvPostTime = findViewById(R.id.tvPostTime);
        tvPostCnt = findViewById(R.id.tvPostCnt);
        tvPostContent = findViewById(R.id.tvPostContent);
        tvPostId = findViewById(R.id.tvPostId);

        queue = Volley.newRequestQueue(PostActivity.this);

        tvPostId.setText(vo.getUser_id());

        vo = UserInfo.info;
        dto = BoardInfo.info;

        // 프로필 사진 원형으로
        imgPostProfile = (ImageView) findViewById(R.id.imgPostProfile);
        Glide.with(this).load(R.drawable.umbrella).circleCrop().into(imgPostProfile);

        // 사용자 ID와 작성자 ID 일치할 때만 수정/삭제 버튼 활성화
        String Userid = tvPostId.getText().toString();

        if (Userid.equals(dto.getArticle_id())) {
            btnPostModify.setVisibility(View.VISIBLE);
            btnPostDelete.setVisibility(View.VISIBLE);
        } else {
            btnPostModify.setVisibility(View.GONE);
            btnPostDelete.setVisibility(View.GONE);
        }

        btnPostComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vo = UserInfo.info;
                Log.d("user_id", vo.getUser_id());
                Intent intent = new Intent(PostActivity.this, CommentActivity.class);

                startActivity(intent);
            }
        });

    }
}