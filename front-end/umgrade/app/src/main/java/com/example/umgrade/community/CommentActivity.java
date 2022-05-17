package com.example.umgrade.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.R;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

import java.util.HashMap;
import java.util.Map;

public class CommentActivity extends AppCompatActivity {

    Button btnComment;
    EditText edtComment;

    TextView tvCommentNick, tvWriter, tvCommentContent, tvCommentTime, tvCommentDel, tvCommentModify, tvCommentReport;

    ImageView imgCommentProfile;

    RequestQueue queue;
    StringRequest request;

    User vo;
    Board dto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        vo = UserInfo.info;
        dto = BoardInfo.info;

        btnComment = findViewById(R.id.btnComment);
        edtComment = findViewById(R.id.edtComment);

        queue = Volley.newRequestQueue(CommentActivity.this);

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

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int method = Request.Method.POST;
                String server_url = "http://220.80.203.18:8081/myapp/InsertCmt.do";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(CommentActivity.this,
                                        "댓글 추가 성공!"+response,
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CommentActivity.this, PostActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(CommentActivity.this,
                                        "댓글 추가 실패!"+error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ){
                    @NonNull
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> param = new HashMap<>();

                        param.put("article_seq", String.valueOf(dto.getArticle_seq()));
                        param.put("article_content", dto.getArticle_content());
                        param.put("cmt_content", edtComment.getText().toString());
                        param.put("cmt_id", vo.getUser_id());

                        return param;
                    }
                };
                queue.add(request);
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