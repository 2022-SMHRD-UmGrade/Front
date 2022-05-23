package com.example.umgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.User;

import java.util.HashMap;
import java.util.Map;

public class PaymentActivity extends AppCompatActivity {
    
    ImageButton btnPaymentPre;
    View cvCardAdd;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        User vo = UserInfo.info;
        Log.d("vo", vo.toString());
        btnPaymentPre = findViewById(R.id.btnPaymentPre); // 뒤로가기
        cvCardAdd = findViewById(R.id.cvCardAdd);

        Intent intent = getIntent();
        String user_id = intent.getStringExtra("user_id");
        Log.d("user_id1", user_id);

        queue = Volley.newRequestQueue(PaymentActivity.this);

        cvCardAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment(user_id);
                Intent intent = new Intent(PaymentActivity.this, PayViewActivity.class);
                intent.putExtra("user_id", user_id);
                startActivity(intent);
                finish();
            }
        });
        // 뒤로가기
        btnPaymentPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    //결제 관련 메서드
    public void payment(String user_id) {
        int method = Request.Method.GET;
        String server_url = "http://220.80.203.18:8081/myapp/pay?id="+user_id;

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(PaymentActivity.this,
                                "success",
                                Toast.LENGTH_SHORT).show();
                        Log.d("response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PaymentActivity.this,
                                "결제등록페이지 연동 실패"+error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> param = new HashMap<>();
                param.put("user_id", user_id);
                return param;
            }
        };
        queue.add(request);
    }
}