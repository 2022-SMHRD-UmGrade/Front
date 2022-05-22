package com.example.umgrade.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.example.umgrade.adapter.CommentAdapter;
import com.example.umgrade.adapterInterface.OnCommentListClickListener;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.CommentInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.Comment;
import com.example.umgrade.vo.User;
import com.google.rpc.context.AttributeContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommentActivity extends AppCompatActivity {

    Button btnComment;
    EditText edtComment, edtCommentContent;

    TextView tvCommentNick, tvSeq, tvCommentContent, tvCommentTime, tvCommentDel, tvCommentModify, tvCommentReport, tvCommentSuccess, tvPostSeq, tvWriter;

    ImageView imgCommentProfile;

    RequestQueue queue;
    StringRequest request;
    RecyclerView recyclerView;
    CommentAdapter adapter = new CommentAdapter();
    ArrayList<Comment> lists = new ArrayList<>();

    User vo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        vo = UserInfo.info;

        tvCommentContent = findViewById(R.id.tvCommentContent); // 댓글 본문
        tvSeq = findViewById(R.id.tvSeq); // 댓글 순번
        tvPostSeq = findViewById(R.id.tvPostSeq); // 게시물 순번
        tvWriter = findViewById(R.id.tvWriter); // 작성자
        tvCommentNick = findViewById(R.id.tvCommentNick); // 작성자 닉네임
        tvCommentTime = findViewById(R.id.tvCommentTime); // 댓글 작성시각
        tvCommentDel = findViewById(R.id.tvCommentDel); // 삭제
        tvCommentModify = findViewById(R.id.tvCommentModify); // 수정
        tvCommentReport = findViewById(R.id.tvCommentReport); // 신고

        btnComment = findViewById(R.id.btnComment);
        edtComment = findViewById(R.id.edtComment);

        edtCommentContent = findViewById(R.id.edtCommentContent); // 댓글 수정 창
        tvCommentSuccess = findViewById(R.id.tvCommentSuccess); // 완료

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
                if (edtComment.length() == 0) {
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
                if (focus) {
                    // 포커스 시
                    btnComment.setClickable(false);
                    btnComment.setBackgroundColor(Color.parseColor("#B9B7BD"));
                    btnComment.setTextColor(Color.parseColor("#888888"));
                } else {
                    btnComment.setClickable(true);
                    btnComment.setBackgroundColor(Color.parseColor("#2196F3"));
                    btnComment.setTextColor(Color.WHITE);
                }
            }
        });
//        if(tvCommentNick.equals(vo.getUser_id())) {
//
//        }
        // 수정 누르면 활성화
//        tvCommentModify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvCommentSuccess.setVisibility(View.VISIBLE); // 수정 완료
//                edtCommentContent.setVisibility(View.VISIBLE); // 댓글 수정 란
//                tvCommentModify.setVisibility(View.GONE); // 수정 버튼 숨김
//                tvCommentContent.setVisibility(View.GONE); // 댓글 본문 숨김
//                tvCommentTime.setVisibility(View.GONE); // 댓글 작성 시각 숨김
//
//                // 기존에 작성한 댓글 수정란에 출력
//                edtCommentContent.setText(tvCommentContent.getText().toString());
//            }
//        });
//
//        // 완료 누르면 특정 항목 숨김/보임
//        tvCommentSuccess.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvCommentSuccess.setVisibility(View.GONE); // 수정 숨김
//                edtCommentContent.setVisibility(View.GONE); // 댓글 수정 숨김
//                tvCommentModify.setVisibility(View.VISIBLE); // 수정 버튼
//                tvCommentContent.setVisibility(View.VISIBLE); // 댓글 본문
//                tvCommentTime.setVisibility(View.VISIBLE); // 댓글 작성 시각
//
//                // 수정한 text 댓글 본문 출력
//                tvCommentContent.setText(edtCommentContent.getText().toString());
//            }
//        });

        Intent intent = getIntent();
        int article_seq = intent.getIntExtra("article_seq", 0);
        int cmt_seq = intent.getIntExtra("cmt_seq", 0);
        String content = intent.getStringExtra("article_content");

        Log.d("seqa", String.valueOf(article_seq));

        queue = Volley.newRequestQueue(CommentActivity.this);

        writecomment(article_seq, content);
        initComment(article_seq, content);

        recyclerView = findViewById(R.id.rvComment);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnListClickListener(new OnCommentListClickListener() {
            @Override
            public void onListClick(CommentAdapter.ViewHolder viewHolder, View view, int position) {
                Comment list = adapter.getList(position);
                int seq = list.getArticle_seq();
                String nick = list.getCmt_id();
                String content = list.getCmt_content();
                String time = list.getCmt_date();

                Intent intent = new Intent(getApplicationContext(), PostActivity.class);
                intent.putExtra("article_seq", seq);
                intent.putExtra("cmt_id", nick);
                intent.putExtra("cmt_content", content);
                intent.putExtra("cmt_date", time);
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(adapter);

//        tvCommentModify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateComment(cmt_seq, content);
//                Intent intent = new Intent(CommentActivity.this, PostActivity.class);
//                intent.putExtra("article_seq", article_seq);
//                intent.putExtra("cmt_seq", cmt_seq);
//                intent.putExtra("cmt_content", content);
//                startActivity(intent);
//            }
//        });
//


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

    //댓글 리스트 메서드
    public void initComment(int article_seq, String content) {

        int method = Request.Method.GET;
        String server_url = "http://220.80.203.18:8081/myapp/BoardComment.do?article_seq=" + article_seq;

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CommentActivity.this,
                                "댓글 불러오기 성공",
                                Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray cmtArray = new JSONArray(response);

                            for (int i = 0; i < cmtArray.length(); i++) {
                                JSONObject object = cmtArray.getJSONObject(i);

                                int seq = Integer.parseInt(object.getString("cmt_seq"));
                                int seq1 = Integer.parseInt(object.getString("article_seq"));
                                String content = object.getString("cmt_content");
                                String date = object.getString("cmt_date");
                                String id = object.getString("cmt_id");
                                int likes = Integer.parseInt(object.getString("cmt_likes"));
                                Comment list = new Comment(seq, seq1, content, date, id, likes);

                                lists.add(list);

//                                tvCommentDel.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        deleteComment(list.getCmt_seq());
//                                    }
//                                });

                            }
                            adapter.setLists(lists);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CommentActivity.this,
                                "댓글 불러오기 실패",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("article_seq", String.valueOf(article_seq));
                param.put("article_contnet", content);
                return param;
            }
        };
        queue.add(request);

    }

    //댓글 작성 메서드
    public void writecomment(int seq, String content) {
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
                                        "댓글 추가 성공!" + response,
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CommentActivity.this, PostActivity.class);
                                intent.putExtra("article_seq", seq);
                                intent.putExtra("article_content", content);
                                intent.putExtra("cmt_content", edtComment.getText().toString());
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(CommentActivity.this,
                                        "댓글 추가 실패!" + error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @NonNull
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> param = new HashMap<>();

                        param.put("article_seq", String.valueOf(seq));
                        param.put("article_content", content);
                        param.put("cmt_content", edtComment.getText().toString());
                        param.put("cmt_id", vo.getUser_id());

                        return param;
                    }
                };
                queue.add(request);
            }
        });
    }

    //댓글 수정 메서드
    public void updateComment(int cmt_seq, String content) {
        int method = Request.Method.POST;
        String server_url = "http://220.80.203.18:8081/myapp/CommentUpdate.do";

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CommentActivity.this,
                                "댓글 수정 성공!",
                                Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CommentActivity.this,
                                "댓글 수정 실패!" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("cmt_seq", String.valueOf(cmt_seq));
                param.put("cmt_content", content);
                return param;
            }
        };
        queue.add(request);
    }

    //댓글 삭제 메서드
    public void deleteComment(int cmt_seq) {
        int method = Request.Method.POST;
        String server_url = "http://220.80.203.18:8081/myapp/CommentDelete.do";

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CommentActivity.this,
                                "댓글 삭제 실패!" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("cmt_seq", String.valueOf(cmt_seq));
                return param;
            }
        };
        queue.add(request);
    }

}