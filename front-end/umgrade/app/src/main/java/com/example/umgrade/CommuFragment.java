package com.example.umgrade;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CommuFragment extends Fragment {

    Button btnCmWrite; // 글작성 버튼
    ListView lvBoard; // 게시물 리스트뷰
    BoardAdapter adapter;

    User vo;
    Board dto;

    ArrayList<Board> list;

    RequestQueue queue;
    StringRequest request;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commu, container, false);

        btnCmWrite = view.findViewById(R.id.btnCmWrite);

        vo = UserInfo.info;

        btnCmWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vo = UserInfo.info;
                Intent intent = new Intent(getActivity(), WriteActivity.class);
                startActivity(intent);
            }
        });

        list = new ArrayList<Board>();

        adapter = new BoardAdapter(getActivity(),R.layout.board_list,list);

        lvBoard =  view.findViewById(R.id.lvBoard);


        queue = Volley.newRequestQueue(getContext());

        int method = Request.Method.POST;
        String server_url = "http://220.80.203.18:8081/myapp/BoardList.do";

        request = new StringRequest(
                method,
                server_url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getContext(),
                                "게시판 불러오기 성공",
                                Toast.LENGTH_SHORT).show();
                        Log.d("user_id", vo.getUser_id());
                        Log.d("asdf", response);
                        try {
                            JSONArray boardArray = new JSONArray(response);

                            for(int i=0; i<boardArray.length(); i++) {
                                JSONObject Object = boardArray.getJSONObject(i);
                                Log.d("seq", Object.getString("article_seq"));
                                Log.d("title", Object.getString("article_title"));
                                Log.d("content", Object.getString("article_content"));
                                Log.d("date", Object.getString("article_date"));
                                Log.d("file", Object.getString("article_file"));
                                Log.d("id", Object.getString("article_id"));
                                Log.d("cnt", Object.getString("article_cnt"));

                                int seq = Integer.parseInt(Object.getString("article_seq"));
                                String title = Object.getString("article_title");
                                String content = Object.getString("article_content");
                                String date = Object.getString("article_date");
                                String file = Object.getString("article_file");
                                String id = Object.getString("article_id");
                                int cnt = Integer.parseInt(Object.getString("article_cnt"));

                                list.add(new Board(seq,title,content,date,file,id,cnt));

                                lvBoard.setAdapter(adapter);

                                adapter.notifyDataSetChanged();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),
                                "게시판 불러오기 실패!" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ); //end

        queue.add(request);

        return view;
    }
}