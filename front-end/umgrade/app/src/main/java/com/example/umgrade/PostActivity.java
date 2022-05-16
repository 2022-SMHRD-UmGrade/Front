package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {
    ImageView imgPostProfile;
    Button btnPostModify, btnPostDelete, btnPostComment;
    TextView tvPostTitle, tvPostNick, tvPostId, tvPostTime, tvPostCnt, tvPostContent;

    ListView lvBoard; // 게시물 리스트뷰
    BoardAdapter adapter;

    RequestQueue queue;
    StringRequest request;

    User vo;
    Board dto;

    ArrayList<Board> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        vo = UserInfo.info;
        dto = BoardInfo.info;

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

        Intent intent = getIntent();

        int seq = intent.getIntExtra("article_seq", dto.getArticle_seq());

        Log.d("seq", String.valueOf(seq));

        getData(seq);

        tvPostId.setText(vo.getUser_id());


    }
    //단일 게시글 불러오는 메서드
    private void getData(int seq) {
        int method = Request.Method.POST;
        String server_url = "http://220.80.203.18:8081/myapp/BoardOne.do";

        request = new StringRequest(
                method,
                server_url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(PostActivity.this,
                                "선택한 게시글 가져오기 성공!",
                                Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject boardObject = new JSONObject(response);
                            tvPostTitle.setText(boardObject.getString("article_title"));
                            tvPostNick.setText(boardObject.getString("article_id"));
                            tvPostContent.setText(boardObject.getString("article_content"));

                            // 사용자 ID와 작성자 ID 일치할 때만 수정/삭제 버튼 활성화
                            String Userid = tvPostId.getText().toString();

                            if (Userid.equals(vo.getUser_id())) {
                                btnPostModify.setVisibility(View.VISIBLE);
                                btnPostDelete.setVisibility(View.VISIBLE);
                            } else {
                                btnPostModify.setVisibility(View.GONE);
                                btnPostDelete.setVisibility(View.GONE);
                            }

                            btnPostModify.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intentModify = new Intent(PostActivity.this, ModifyActivity.class);

                                    startActivity(intentModify);
                                }
                            });

                            btnPostDelete.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    int method = Request.Method.POST;
                                    String server_url = "http://220.80.203.18:8081/myapp/BoardDelete.do";

                                    request = new StringRequest(
                                            method,
                                            server_url,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Toast.makeText(PostActivity.this,
                                                            "게시글 삭제 성공!"+response,
                                                            Toast.LENGTH_SHORT).show();
                                                }
                                            },
                                            new Response.ErrorListener() {
                                                @Override
                                                public void onErrorResponse(VolleyError error) {
                                                    Toast.makeText(PostActivity.this,
                                                            "게시글 삭제 실패!"+error.toString(),
                                                            Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                    ){
                                        @NonNull
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError{
                                            Map<String, String> param = new HashMap<>();

                                            param.put("article_seq", String.valueOf(seq));

                                            return param;
                                        }
                                    };
                                    queue.add(request);
                                }
                            });


                        }
                        catch(JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PostActivity.this,
                                "선택한 게시글 가져오기 실패!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("article_seq", String.valueOf(seq));

                return param;
            }
        };
        queue.add(request);


        // 프로필 사진 원형으로
        imgPostProfile = (ImageView) findViewById(R.id.imgPostProfile);
        Glide.with(this).load(R.drawable.umbrella).circleCrop().into(imgPostProfile);

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