package com.example.umgrade;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.main.MapActivity;
import com.example.umgrade.main.QrActivity;
import com.example.umgrade.mainFrag.MainFragment;
import com.example.umgrade.notice.NoticeActivity;
import com.example.umgrade.service.ServiceActivity;
import com.example.umgrade.service.SupportActivity;

public class MoreFragment extends Fragment {

    Button btnMoreUserInfo, btnMoreSearch, btnMoreQr, btnMoreCommu,
            btnMoreNotice, btnMoreService, btnMoreSupport, btnMoreTerms;
    ImageView imgMoreProfile;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        btnMoreUserInfo = view.findViewById(R.id.btnMoreUserInfo);
        btnMoreSearch = view.findViewById(R.id.btnMoreSearch);
        btnMoreQr = view.findViewById(R.id.btnMoreQr);
        btnMoreCommu = view.findViewById(R.id.btnMoreCommu);
        btnMoreNotice = view.findViewById(R.id.btnMoreNotice);
        btnMoreService = view.findViewById(R.id.btnMoreService);
        btnMoreSupport = view.findViewById(R.id.btnMoreSupport);
        btnMoreTerms = view.findViewById(R.id.btnMoreTerms);

        imgMoreProfile = (ImageView) view.findViewById(R.id.imgMoreProfile);
        // 이미지 원형으로
        Glide.with(this).load(R.drawable.logoumbrella).circleCrop().into(imgMoreProfile);

        // 회원정보수정
        btnMoreUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 마이페이지 내부 수정페이지로
                Intent intent = new Intent(getActivity(), AccountSettingActivity.class);
                startActivity(intent);
            }
        });

        // 보관함찾기
        btnMoreSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });

        // QR스캔
        btnMoreQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QrActivity.class);
                startActivity(intent);
            }
        });

        // 커뮤니티
        btnMoreCommu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커뮤니티 프래그먼트로 이동
                ((MainActivity)getActivity()).changeCommu(newInstance());
            }
        });

        // 공지&이벤트
        btnMoreNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        // 서비스안내
        btnMoreService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ServiceActivity.class);
                startActivity(intent);
            }
        });

        // 고객센터
        btnMoreSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SupportActivity.class);
                startActivity(intent);
            }
        });

        // 약관확인
        btnMoreTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TermsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}