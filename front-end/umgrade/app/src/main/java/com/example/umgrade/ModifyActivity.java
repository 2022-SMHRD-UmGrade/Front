package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

import java.util.HashMap;
import java.util.Map;

public class ModifyActivity extends AppCompatActivity {
    Button btnModifyCancel, btnModifySend;
    Fragment CommuFragment;

    EditText edtModifyTitle, edtModifyContent;

    RequestQueue queue;
    StringRequest request;

    Board dto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        btnModifyCancel = findViewById(R.id.btnModifyCancel);
        btnModifySend = findViewById(R.id.btnModifySend);

        CommuFragment = (CommuFragment) getSupportFragmentManager().findFragmentById(R.id.fragCommu);
        CommuFragment = new Fragment();

        dto = BoardInfo.info;

        // 취소 버튼 누르면 이전 화면으로
        btnModifyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 글 전송
        btnModifySend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int method = Request.Method.POST;
                String server_url = "http://192.168.0.3:8081/myapp/Android/boardUpdate.do";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(ModifyActivity.this,
                                        "게시글 수정 성공"+response,
                                        Toast.LENGTH_SHORT).show();
                            //onFragmentChanged();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(ModifyActivity.this,
                                        "게시글 수정 실패!"+error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ){
                    @NonNull
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> param = new HashMap<>();

                        param.put("article_id", dto.getArticle_id());
                        param.put("article_title", edtModifyTitle.getText().toString());
                        param.put("article_content", edtModifyContent.getText().toString());

                        return param;
                    }

                };
                queue.add(request);
            }
        });

    }

    public void onFragmentChanged(int index) {
        if(index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, CommuFragment).commit();
        }
        else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, CommuFragment).commit();
        }
    }
}