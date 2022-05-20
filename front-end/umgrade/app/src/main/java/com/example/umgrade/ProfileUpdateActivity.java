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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.umgrade.mainFrag.MainFragment;
import com.example.umgrade.userActivity.MypageFragment;

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
//        Intent intentUpdate = getIntent();
        Bundle extras = getIntent().getExtras();
        edtNickChange.setText(extras.getString("nick"));
//        byte[] byteArray = getIntent().getByteArrayExtra("byteArray");
//        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//
//        imgProfileChange.setImageBitmap(bitmap);

        // 버튼 누르면 닉네임 값을 마이페이지로 전달
        btnProfileChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                //Intent intent = new Intent(ProfileUpdateActivity.this, MypageFragment.class);
                MypageFragment fragment = new MypageFragment();
                String nickUpdate = edtNickChange.getText().toString();
                // 닉네임 값을 마이페이지로 전달
                Bundle bundle = new Bundle();
                bundle.putString("nickUpdate", nickUpdate);
                //intent.putExtra("nickUpdate", bundle);
                //startActivity(intent);
                fragment.setArguments(bundle);
                //Toast.makeText(ProfileUpdateActivity.this, "ActivityNickUpdate : "+nickUpdate, Toast.LENGTH_SHORT).show();
                // 화면종료
                //finish();
                onBackPressed();
                transaction.replace(R.id.container, fragment).commit();
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
}