package com.example.umgrade.noticeFrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.umgrade.R;

public class EventFragment extends Fragment {
    ListView lvEvent; // 이벤트 리스트뷰

    TextView eventTitle, eventStart, eventEnd, eventCnt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        eventTitle = view.findViewById(R.id.eventTitle); // 글제목
        eventStart = view.findViewById(R.id.eventStart); // 시작 날짜
        eventEnd = view.findViewById(R.id.eventEnd); // 종료날짜
        eventCnt = view.findViewById(R.id.eventSeq); // 글번호 - 나중에 안보이게 처리

        return view;
    }
}