package com.example.umgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AccountSettingActivity extends AppCompatActivity {
    
    ImageButton btnAccountSettingPre;
    Button btnPasswordChange, btnTelChange, btnEmailChange, btnAddrChange;
    TextView tvTel, tvEmail, tvAddress;
    EditText edtTel, edtEmail, edtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        btnAccountSettingPre = findViewById(R.id.btnAccountSettingPre); // 뒤로가기
        btnPasswordChange = findViewById(R.id.btnPasswordChange); // 비밀번호 변경
        btnTelChange = findViewById(R.id.btnTelChange); // 전화번호 변경
        btnEmailChange = findViewById(R.id.btnEmailChange); // 이메일 변경
        btnAddrChange = findViewById(R.id.btnAddrChange); // 주소 변경

        tvTel = findViewById(R.id.tvTel); // 전화번호
        edtTel = findViewById(R.id.edtTel); // 전화번호 수정
        tvEmail = findViewById(R.id.tvEmail); // 이메일
        edtEmail = findViewById(R.id.edtEmail); // 이메일 수정
        tvAddress = findViewById(R.id.tvAddress); // 주소
        edtAddress = findViewById(R.id.edtAddress); // 주소 수정

        // 전화번호 버튼
        btnTelChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 누르면 버튼 텍스트 변경
                String state = btnTelChange.getText().toString();
                if(state.equals("변경하기")){
                    btnTelChange.setText("완료");
                    tvTel.setVisibility(View.GONE);
                    edtTel.setVisibility(View.VISIBLE);
                    edtTel.requestFocus();
                    edtTel.setSelection(edtTel.length());
                    // 저장된 전화번호를 edtTel에 출력
                    edtTel.setText(tvTel.getText().toString());
                } else if (state.equals("완료")){
                    btnTelChange.setText("변경하기");
                    tvTel.setVisibility(View.VISIBLE);
                    edtTel.setVisibility(View.GONE);
                    // 수정된 값을 tvTel에 출력
                    tvTel.setText(edtTel.getText().toString());
                }
            }
        });

        // 이메일 버튼
        btnEmailChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 누르면 버튼 텍스트 변경
                String state = btnEmailChange.getText().toString();
                if(state.equals("변경하기")){
                    btnEmailChange.setText("완료");
                    tvEmail.setVisibility(View.GONE);
                    edtEmail.setVisibility(View.VISIBLE);
                    // tvEmail 값 가져오기
                    edtEmail.setText(tvEmail.getText().toString());
                } else if (state.equals("완료")){
                    btnEmailChange.setText("변경하기");
                    tvEmail.setVisibility(View.VISIBLE);
                    edtEmail.setVisibility(View.GONE);
                    // edtEmail 값 가져오기
                    tvEmail.setText(edtEmail.getText().toString());
                }
            }
        });

        // 주소 버튼
        btnAddrChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 누르면 버튼 텍스트 변경
                String state = btnAddrChange.getText().toString();
                if(state.equals("변경하기")){
                    btnAddrChange.setText("완료");
                    tvAddress.setVisibility(View.GONE);
                    edtAddress.setVisibility(View.VISIBLE);
                    // tvAddress 값 가져오기
                    edtAddress.setText(tvAddress.getText().toString());
                } else if (state.equals("완료")){
                    btnAddrChange.setText("변경하기");
                    edtAddress.setVisibility(View.GONE);
                    tvAddress.setVisibility(View.VISIBLE);
                    // edtAddress 값 가져오기
                    tvAddress.setText(edtAddress.getText().toString());
                }
            }
        });

        // 뒤로가기
        btnAccountSettingPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // 비밀번호 변경 페이지 이동
        btnPasswordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountSettingActivity.this, PasswordChangeActivity.class);
                startActivity(intent);
            }
        });
    }
}