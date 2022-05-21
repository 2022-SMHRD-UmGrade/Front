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

        // SharedPreferences
        // name : 저장소 이름
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // MypageFragment에서 데이터 꺼냄
        //String nick = sharedPreferences.getString("nick", "no data");
        //Log.d("확인", nick);

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

                // imgProfileChange 그림을 bitmap으로 가져오기
                BitmapDrawable drawable = (BitmapDrawable) imgProfileChange.getDrawable();
                Bitmap bitmap = drawable.getBitmap();

                String image = BitmapToString(bitmap);
                editor.putString("imageString", image);
                // SharedPreference에 데이터 넣는 파트
                // 이름, 값
                editor.putString("nickUpdate", nickUpdate);
//                editor.putString("bitmap", );
                editor.commit();
                
                // 화면종료
                //finish();
                onBackPressed();
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