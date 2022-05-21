package com.example.umgrade;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

import com.bumptech.glide.Glide;
import com.example.umgrade.mainFrag.MainFragment;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.userActivity.MypageFragment;

import java.io.ByteArrayOutputStream;

public class ProfileUpdateActivity extends AppCompatActivity {

    ImageView imgProfileChange;
    EditText edtNickChange;
    Button btnProfileChange;
    ImageButton btnProfileUpdatePre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        imgProfileChange = findViewById(R.id.imgProfileChange); // 수정할 프로필 이미지
        edtNickChange = findViewById(R.id.edtNickChange); // 수정할 닉네임
        btnProfileChange = findViewById(R.id.btnProfileChange); // 프로필 변경
        btnProfileUpdatePre = findViewById(R.id.btnProfileUpdatePre); // 뒤로가기 버튼

        // 이미지 클릭해서 갤러리 접근
        imgProfileChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 갤러리 접근
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                launcher.launch(intent);
            }
        });

        // 닉네임/이미지 란에 기존 값 출력
        Intent intentUpdate = getIntent();
        edtNickChange.setText(intentUpdate.getStringExtra("nick"));

        // 버튼 누르면 닉네임 값을 마이페이지로 전달
        btnProfileChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 값 가져오기
                String nickUpdate = edtNickChange.getText().toString();
                Intent intent = new Intent(ProfileUpdateActivity.this, MypageActivity.class);
                intent.putExtra("nickUpdate", nickUpdate);
                startActivity(intent);
                // 화면종료
                finish();
            }
        });

        // 뒤로가기 버튼
        btnProfileUpdatePre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    } // oncreate

    // 이미지 불러오기
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>()
            {
                @Override
                public void onActivityResult(ActivityResult result)
                {
                    if (result.getResultCode() == RESULT_OK)
                    {
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
}