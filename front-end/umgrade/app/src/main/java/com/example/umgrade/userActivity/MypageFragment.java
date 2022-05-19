package com.example.umgrade.userActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.umgrade.AccountSettingActivity;
import com.example.umgrade.PaymentActivity;
import com.example.umgrade.ProfileUpdateActivity;
import com.example.umgrade.R;
import com.example.umgrade.UsageHistoryActivity;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class MypageFragment extends Fragment {

    Button btnProfileUpdate, btnPayment, btnUsageHistory, btnAccountSetting, btnLogout;
    TextView tvNickMypageCard, tvUserId, tvRatingMypageCard, tvPointMypageCard, tvCouponMypageCard;
    ImageView imgMypageProfile;
    User vo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        btnProfileUpdate = view.findViewById(R.id.btnProfileUpdate); //프로필 수정
        imgMypageProfile = view.findViewById(R.id.imgProfileChange); //프로필이미지
        btnPayment = view.findViewById(R.id.btnPayment); // 결제관리
        btnUsageHistory = view.findViewById(R.id.btnUsageHistory); // 이용내역
        btnAccountSetting = view.findViewById(R.id.btnAccountSetting); // 계정설정
        btnLogout = view.findViewById(R.id.btnLogout); // 로그아웃

        tvNickMypageCard = view.findViewById(R.id.tvNickMypageCard); // 닉네임
        tvUserId = view.findViewById(R.id.tvUserId); // ID
        tvRatingMypageCard = view.findViewById(R.id.tvRatingMypageCard); // 회원 등급
        tvPointMypageCard = view.findViewById(R.id.tvPointMypageCard); // 보유 포인트
        tvCouponMypageCard = view.findViewById(R.id.tvCouponMypageCard); // 보유 쿠폰

        // 닉네임 란에 수정한 닉네임 출력
        Bundle bundle = new Bundle();
        if(getArguments() != null){
            String nickUpdate = bundle.getString("nickUpdate");
            // 왜 출력이 안되니
            Toast.makeText(getActivity(), "nickUpdate : "+nickUpdate, Toast.LENGTH_SHORT).show();
            tvNickMypageCard.setText(nickUpdate);
        }

        // 프로필 수정 페이지 이동
        btnProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 닉네임 저장
                String nick = tvNickMypageCard.getText().toString();

                // 닉네임 값을 수정페이지로 전달
                Intent intent = new Intent(getActivity(), ProfileUpdateActivity.class);
                intent.putExtra("nick", nick);

                startActivity(intent);
            }
        });

        // 결제관리 페이지 이동
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PaymentActivity.class);
                startActivity(intent);
            }
        });

        // 이용내역 페이지 이동
        btnUsageHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UsageHistoryActivity.class);
                startActivity(intent);
            }
        });

        // 계정설정 페이지 이동
        btnAccountSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AccountSettingActivity.class);
                startActivity(intent);
            }
        });

        // 로그아웃
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo.info = vo;
                String text = btnLogout.getText().toString(); // 로그아웃 버튼 텍스트
                if(text.equals("로그아웃")){
                    vo = null;
                    Toast.makeText(getActivity(),
                            "로그아웃 되었습니다.",
                            Toast.LENGTH_SHORT).show();
                    btnLogout.setText("로그인");
                } else if(text.equals("로그인")){
                    if(vo == null) {
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    }
                    btnLogout.setText("로그아웃");
                }

            }
        });

        return view;
    }
}