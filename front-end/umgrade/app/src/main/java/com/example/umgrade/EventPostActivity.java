package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EventPostActivity extends AppCompatActivity {

    TextView eventPostTitle, eventPostTime, eventPostContent, eventPostSeq, eventPostCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_post);

        eventPostTitle = findViewById(R.id.eventPostTitle); // 글제목
        eventPostTime = findViewById(R.id.eventPostTime); // 글 작성 시각
        eventPostContent = findViewById(R.id.eventPostContent); // 글 본문
        eventPostSeq = findViewById(R.id.eventPostSeq); // 글 번호 - 나중에 숨기기
        eventPostCnt = findViewById(R.id.eventPostCnt); // 조회수
    }
}