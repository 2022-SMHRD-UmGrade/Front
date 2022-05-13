package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NoticePostActivity extends AppCompatActivity {

    TextView noticePostTitle, noticePostTime, noticePostContent, noticePostSeq, noticePostCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_post);

        noticePostTitle = findViewById(R.id.noticePostTitle); // 글제목
        noticePostTime = findViewById(R.id.noticePostTime); // 작성시각
        noticePostContent = findViewById(R.id.noticePostContent); // 본문
        noticePostSeq = findViewById(R.id.noticePostSeq); // 글번호 - 나중에 숨김
        noticePostCnt = findViewById(R.id.noticePostCnt); // 조회수
    }
}