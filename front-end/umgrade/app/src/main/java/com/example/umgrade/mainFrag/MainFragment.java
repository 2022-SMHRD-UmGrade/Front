package com.example.umgrade.mainFrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.umgrade.FareActivity;
import com.example.umgrade.main.QrActivity;
import com.example.umgrade.R;
import com.example.umgrade.sevice.ServiceActivity;
import com.example.umgrade.sevice.SupportActivity;
import com.example.umgrade.main.MapActivity;
import com.example.umgrade.notice.NoticeActivity;


public class MainFragment extends Fragment {
    ImageView imgMypageProfile;
    Button btnFare, btnServiceCard, btnNoticeEvent, btnMapCard, btnQrCard, btnSupportCard;
    CardView cvMypage;
    View btnFareLayout;

//    // 메인액티비티 호출
//    MainActivity mainActivity;
//    @Override
//    public void onAttach(@NonNull Context context){
//        super.onAttach(context);
//        mainActivity = (MainActivity) getActivity();
//    }
//
//    // 메인액티비티 해제
//    @Override
//    public void onDetach(){
//        super.onDetach();
//        mainActivity = null;
//    }
    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // 마이페이지 카드 클릭 시 frag_mypage로 이동
        cvMypage = view.findViewById(R.id.cvMypage);
        cvMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ServiceActivity.MainActivity)getActivity()).changeMypage(newInstance());
            }
        });

        btnServiceCard = view.findViewById(R.id.btnServiceCard);
        // 서비스안내 클릭 시 화면전환
        btnServiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ServiceActivity.class);
                startActivity(intent);
            }
        });

        btnNoticeEvent = view.findViewById(R.id.btnNoticeEvent);
        // 공지&이벤트 클릭 시 화면전환
        btnNoticeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        btnMapCard = view.findViewById(R.id.btnMapCard);
        // 보관함 찾기 클릭 시 화면전환
        btnMapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });

        btnSupportCard = view.findViewById(R.id.btnSupportCard);
        // 고객센터 클릭 시 화면전환
        btnSupportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SupportActivity.class);
                startActivity(intent);
            }
        });

        btnQrCard = view.findViewById(R.id.btnQrCard);
        // QR스캔 클릭 시 화면전환
        btnQrCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QrActivity.class);
                startActivity(intent);
            }
        });


        imgMypageProfile = (ImageView) view.findViewById(R.id.imgMypageProfile);
        Glide.with(this).load(R.drawable.umbrella).circleCrop().into(imgMypageProfile);

        btnFare = view.findViewById(R.id.btnFare);
        // 로그인 시 btnFare에 "오늘까지의 UM-CYCLE 이용 요금은 n,nnn원 입니다." 출력
        btnFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 요금 안내 페이지로 이동
                Intent intent = new Intent(getActivity(), FareActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}