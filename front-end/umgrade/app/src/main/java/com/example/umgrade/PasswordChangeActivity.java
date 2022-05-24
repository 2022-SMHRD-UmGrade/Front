package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.android.volley.toolbox.Volley;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.userActivity.MypageFragment;
import com.example.umgrade.vo.User;
import com.squareup.okhttp.internal.DiskLruCache;

import java.util.HashMap;
import java.util.Map;

public class PasswordChangeActivity extends AppCompatActivity {

    ImageButton btnPasswordChangePre;
    Button btnChangePw;
    EditText edtNowPw, edtNewPw, edtNewCkPw;
    User vo = UserInfo.info;
    String server_url2 = "http://192.168.43.209:8081/myapp";

    RequestQueue queue;
    StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        btnPasswordChangePre = findViewById(R.id.btnPasswordChangePre); // 뒤로가기
        btnChangePw = findViewById(R.id.btnChangePw);

        edtNowPw = findViewById(R.id.edtNowPw);
        edtNewPw = findViewById(R.id.edtNewPw);
        edtNewCkPw = findViewById(R.id.edtNewCkPw);

        queue = Volley.newRequestQueue(PasswordChangeActivity.this);
        // 뒤로가기
        btnPasswordChangePre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnChangePw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePw();
            }
        });


    }
    //비밀번호 변경 메서드
    public void changePw() {
        Log.d("userInfo1", vo.toString());
        int method = Request.Method.POST;
        String server_url = server_url2+"/Android/PwUpdate";

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(PasswordChangeActivity.this,
                                "비밀번호 수정 성공",
                                Toast.LENGTH_SHORT).show();
                        if(edtNewPw.getText().toString().equals(edtNewCkPw.getText().toString())) {
                            Intent intent = new Intent(PasswordChangeActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PasswordChangeActivity.this,
                                "비밀번호 수정 실패"+error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        )
        {
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("user_id", vo.getUser_id());
                param.put("user_pw", edtNewPw.getText().toString());
                return param;
            }
        };
        queue.add(request);
    }


}