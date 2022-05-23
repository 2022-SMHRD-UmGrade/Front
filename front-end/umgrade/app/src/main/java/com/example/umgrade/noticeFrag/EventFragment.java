package com.example.umgrade.noticeFrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.umgrade.R;
import com.example.umgrade.notice.EventPostActivity;

public class EventFragment extends Fragment {
    ListView lvEvent; // 이벤트 리스트뷰

    TextView eventTitle, eventStart, eventEnd, eventCnt;

    View eventPost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        eventTitle = view.findViewById(R.id.eventTitle); // 글제목
        eventStart = view.findViewById(R.id.eventStart); // 시작 날짜
        eventEnd = view.findViewById(R.id.eventEnd); // 종료날짜
        eventCnt = view.findViewById(R.id.eventSeq); // 글번호 - 나중에 안보이게 처리

        eventPost = view.findViewById(R.id.eventPost); // 게시물

        eventPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventPostActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}