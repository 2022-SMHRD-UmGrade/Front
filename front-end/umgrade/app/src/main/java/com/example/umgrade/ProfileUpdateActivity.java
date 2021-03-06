package com.example.umgrade;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.mainFrag.MainFragment;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.userActivity.MypageFragment;
import com.example.umgrade.vo.User;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ProfileUpdateActivity extends AppCompatActivity {

    ImageView imgProfileChange;
    EditText edtNickChange;
    Button btnProfileChange;
    ImageButton btnProfileUpdatePre;
    User vo;

    RequestQueue queue;
    StringRequest request;
    String server_url2 = "http://192.168.43.209:8081/myapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        vo = UserInfo.info;

        imgProfileChange = findViewById(R.id.imgProfileChange); // ????????? ????????? ?????????
        edtNickChange = findViewById(R.id.edtNickChange); // ????????? ?????????
        btnProfileChange = findViewById(R.id.btnProfileChange); // ????????? ??????
        btnProfileUpdatePre = findViewById(R.id.btnProfileUpdatePre); // ???????????? ??????

        queue = Volley.newRequestQueue(ProfileUpdateActivity.this);

        Intent intent = getIntent();
        String nick = intent.getStringExtra("nick");

        // ????????? ???????????? ????????? ??????
        imgProfileChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ????????? ??????
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                launcher.launch(intent);
            }
        });

        // ?????????/????????? ?????? ?????? ??? ??????
        Intent intentUpdate = getIntent();
        edtNickChange.setText(nick);

        // ?????? ????????? ????????? ?????? ?????????????????? ??????
        btnProfileChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ??? ????????????
                updateNick();

            }
        });

        // ???????????? ??????
        btnProfileUpdatePre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    } // oncreate

    // ????????? ????????????
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        Uri uri = intent.getData();
                        Glide.with(ProfileUpdateActivity.this)
                                .load(uri)
                                .into(imgProfileChange);
                    }
                }
            });

    public static String BitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos);
        byte[] bytes = baos.toByteArray();
        String temp = Base64.encodeToString(bytes, Base64.DEFAULT);
        return temp;
    }

    public void updateNick() {
        vo = UserInfo.info;
        int method = Request.Method.POST;
        String server_url = server_url2+"/Android/NcikUpdate";

        request = new StringRequest(
                method,
                server_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ProfileUpdateActivity.this,
                                "????????? ?????? ??????",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProfileUpdateActivity.this, MypageActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ProfileUpdateActivity.this,
                                "????????? ?????? ??????" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("user_id", vo.getUser_id());
                param.put("user_nick", edtNickChange.getText().toString());
                return param;
            }
        };
        queue.add(request);
    }
}