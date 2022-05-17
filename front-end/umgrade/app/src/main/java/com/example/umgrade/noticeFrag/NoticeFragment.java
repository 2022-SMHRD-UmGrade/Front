package com.example.umgrade.noticeFrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.umgrade.R;

public class NoticeFragment extends Fragment {
    ListView lvNotice; // 공지 리스트뷰
    
    TextView noticeTitle, noticeTime, noticeCnt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        
        noticeTitle = view.findViewById(R.id.noticeTitle); // 공지글 제목
        noticeTime = view.findViewById(R.id.noticeTime); // 글 등록 시간
        noticeCnt = view.findViewById(R.id.noticeSeq); // 글번호 - 나중에 안보이게 처리
        
        return view;
    }
}