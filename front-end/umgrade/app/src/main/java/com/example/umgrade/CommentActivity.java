package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CommentActivity extends AppCompatActivity {

    Button btnComment;
    EditText edtComment;

    TextView tvCommentNick, tvWriter, tvCommentContent, tvCommentTime, tvCommentDel, tvCommentModify, tvCommentReport;

    ImageView imgCommentProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        btnComment = findViewById(R.id.btnComment);
        edtComment = findViewById(R.id.edtComment);

        // 댓글 내용이 없을 경우 버튼 비활성화
        edtComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btnComment.setClickable(true);
                btnComment.setBackgroundColor(Color.parseColor("#2196F3"));
                btnComment.setTextColor(Color.WHITE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (edtComment.length()==0){
                    btnComment.setClickable(false);
                    btnComment.setBackgroundColor(Color.parseColor("#B9B7BD"));
                    btnComment.setTextColor(Color.parseColor("#888888"));
                } else {
                    btnComment.setClickable(true);
                    btnComment.setBackgroundColor(Color.parseColor("#2196F3"));
                    btnComment.setTextColor(Color.WHITE);
                    }


                 }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 댓글 포커스 시 버튼 색상 변경
        edtComment.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus){
                    // 포커스 시
                    btnComment.setClickable(false);
                    btnComment.setBackgroundColor(Color.parseColor("#B9B7BD"));
                    btnComment.setTextColor(Color.parseColor("#888888"));
                }else{
                    btnComment.setClickable(true);
                    btnComment.setBackgroundColor(Color.parseColor("#2196F3"));
                    btnComment.setTextColor(Color.WHITE);
                }
            }
        });


//        tvCommentNick = findViewById(R.id.tvCommentNick);
//        tvWriter = findViewById(R.id.tvWriter);
//        tvCommentContent = findViewById(R.id.tvCommentContent);
//        tvCommentTime = findViewById(R.id.tvCommentTime);
//        tvCommentDel = findViewById(R.id.tvCommentDel);
//        tvCommentModify = findViewById(R.id.tvCommentModify);
//        tvCommentReport = findViewById(R.id.tvCommentReport);
//
//        // 게시물 작성자와 댓글 작성자가 일치할 경우에만 작성자 표시
//        String brWriterID = "test"; // 게시물 작성자 ID
//        String cmWriterID = "test"; // 댓글 작성자 ID
//        if(cmWriterID.equals(brWriterID)){
//            tvWriter.setVisibility(View.VISIBLE);
//        }else{
//            tvWriter.setVisibility(View.INVISIBLE);
//        }
//
//        // 댓글 작성자와 접속한 사용자가 일치할 경우에만 수정/삭제 기능 표시
//        String cmWriterId = "test";
//        String userId = "test";
//        if(userId.equals(cmWriterId)){
//            tvCommentModify.setVisibility(View.VISIBLE);
//            tvCommentDel.setVisibility(View.VISIBLE);
//        } else {
//            tvCommentModify.setVisibility(View.GONE);
//            tvCommentDel.setVisibility(View.VISIBLE);
//        }
//
//        // 접속한 사람이 관리자일 때 삭제 기능 표시
//        String managerId = "test";
//        if(userId.equals(managerId)){
//            tvCommentDel.setVisibility(View.VISIBLE);
//        } else {
//            tvCommentDel.setVisibility(View.GONE);
//        }
//
//        // 댓글 프로필 사진
//        imgCommentProfile = findViewById(R.id.imgCommentProfile);
//
//        Glide.with(this).load(R.drawable.umbrella).circleCrop().into(imgCommentProfile);

    }


}