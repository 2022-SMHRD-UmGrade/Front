package com.example.umgrade.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ModifyActivity extends AppCompatActivity {
    Button btnModifyCancel, btnModifySend;
    Fragment CommuFragment;

    EditText edtModifyTitle, edtModifyContent;

    RequestQueue queue;
    StringRequest request;

    User vo;
    Board dto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        vo = UserInfo.info;
        dto = BoardInfo.info;

        btnModifyCancel = findViewById(R.id.btnModifyCancel);
        btnModifySend = findViewById(R.id.btnModifySend);

        edtModifyTitle = findViewById(R.id.edtModifyTitle);
        edtModifyContent = findViewById(R.id.edtModifyContent);

        CommuFragment = (com.example.umgrade.communityFrag.CommuFragment) getSupportFragmentManager().findFragmentById(R.id.fragCommu);
        CommuFragment = new Fragment();

        queue = Volley.newRequestQueue(ModifyActivity.this);

        Intent intent = getIntent();

        int seq = intent.getIntExtra("article_seq", dto.getArticle_seq());

        edtModifyTitle.setText(intent.getStringExtra("article_title"));
        edtModifyContent.setText(intent.getStringExtra("article_content"));

        // 취소 버튼 누르면 이전 화면으로
        btnModifyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnModifySend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUpdate(seq, edtModifyTitle.getText().toString(), edtModifyContent.getText().toString());
                replace(CommuFragment);
            }
        });


    }

    public void getUpdate(int seq, String title, String content) {
        // 글 전송

        int method = Request.Method.POST;
        String server_url = "http://192.168.0.3:8081/myapp/BoardUpdate.do";

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ModifyActivity.this,
                                "게시글 수정 성공",
                                Toast.LENGTH_SHORT).show();
                        Log.d("update", response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ModifyActivity.this,
                                "게시글 수정 실패!" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();

                param.put("article_seq", String.valueOf(seq));
                param.put("article_title", title);
                param.put("article_content", content);

                return param;
            }

        };
        queue.add(request);
    }

    public void replace(Fragment commuFragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, commuFragment);
        fragmentTransaction.commit();
    }

}