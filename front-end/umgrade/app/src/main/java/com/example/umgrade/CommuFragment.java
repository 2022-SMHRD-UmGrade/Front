package com.example.umgrade;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class CommuFragment extends Fragment {
    Button btnCmWrite; // 글작성 버튼
    ListView lvBoard; // 게시물 리스트뷰
    BoardAdapter adapter;
//    ArrayList<VO> list; // VO 생성해야 함

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commu, container, false);

        btnCmWrite = view.findViewById(R.id.btnCmWrite);
        btnCmWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WriteActivity.class);
                startActivity(intent);
            }
        });

        lvBoard = view.findViewById(R.id.lvBoard);
        // VO 생성후에 이름 바꾸기
//        list = new ArrayList<VO>;
//        adapter = new BoardAdapter(getActivity(),R.layout.board_list,list);

        lvBoard.setAdapter(adapter);

        return view;
    }
}