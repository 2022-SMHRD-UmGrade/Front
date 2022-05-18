package com.example.umgrade.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.User;

import java.util.HashMap;
import java.util.Map;

public class WriteActivity extends AppCompatActivity {

    Button btnWriteCancel, btnWriteSend;
    EditText edtWriteTitle, edtWriteContent;
    Fragment CommuFragment;

    RequestQueue queue;
    StringRequest request;

    User vo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        edtWriteTitle = findViewById(R.id.edtWriteTitle);
        edtWriteContent = findViewById(R.id.edtWriteContent);
        btnWriteCancel = findViewById(R.id.btnWriteCancel);
        btnWriteSend = findViewById(R.id.btnWriteSend);

        CommuFragment = new Fragment();

        queue = Volley.newRequestQueue(WriteActivity.this);

        //게시글 작성 메서드 불러오기
        writeContent();

        // 취소 버튼 누르면 이전 화면으로
        btnWriteCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
    //게시글 작성 메서드
    public void writeContent() {

        btnWriteSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vo = UserInfo.info;

                int method = Request.Method.POST;
                String server_url = "http://220.80.203.18:8081/myapp/BoardInsert.do";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(WriteActivity.this,
                                        "등록 성공!" + response,
                                        Toast.LENGTH_SHORT).show();
                                Log.d("asdf", response);


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(WriteActivity.this,
                                        "등록 실패!" + error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @NonNull
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> param = new HashMap<>();

                        param.put("article_title", edtWriteTitle.getText().toString());
                        param.put("article_content", edtWriteContent.getText().toString());
                        param.put("article_file", "N");
                        param.put("article_id", vo.getUser_id());

                        return param;
                    }
                };//end
                queue.add(request);
            }
        });
    }

}