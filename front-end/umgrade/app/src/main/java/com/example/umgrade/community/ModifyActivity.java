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
import com.example.umgrade.adapter.BoardAdapter;
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

    BoardAdapter adapter = new BoardAdapter();

    RequestQueue queue;
    StringRequest request;
    String server_url2 = "http://192.168.43.209:8081/myapp";
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

        int seq = intent.getIntExtra("article_seq", 0);
        String nick = intent.getStringExtra("article_id");

        edtModifyTitle.setText(intent.getStringExtra("article_title"));
        edtModifyContent.setText(intent.getStringExtra("article_content"));

        // ?????? ?????? ????????? ?????? ????????????
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
                Intent intent = new Intent(ModifyActivity.this, CommuActivity.class);
                intent.putExtra("article_seq", seq);
                adapter.notifyDataSetChanged();
                startActivity(intent);
            }
        });


    }
    // ????????? ???????????? ???????????? ?????????
    public void getUpdate(int seq, String title, String content) {

        int method = Request.Method.POST;
        String server_url = server_url2+"/myapp/BoardUpdate.do";

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ModifyActivity.this,
                                "????????? ?????? ??????",
                                Toast.LENGTH_SHORT).show();
                        Log.d("update", response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ModifyActivity.this,
                                "????????? ?????? ??????!" + error.toString(),
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
                param.put("article_file", "N");
                return param;
            }
        };
        queue.add(request);
    }
}