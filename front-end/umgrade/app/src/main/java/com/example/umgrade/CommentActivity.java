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
import android.widget.TextView;

public class CommentActivity extends AppCompatActivity {

    Button btnComment;
    EditText edtComment;

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



    }
}