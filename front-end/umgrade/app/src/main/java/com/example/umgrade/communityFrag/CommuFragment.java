package com.example.umgrade.communityFrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.adapter.BoardAdapter;
import com.example.umgrade.community.PostActivity;
import com.example.umgrade.R;
import com.example.umgrade.community.WriteActivity;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CommuFragment extends Fragment {

    Button btnCmWrite; // 글작성 버튼
    ListView lvBoard; // 게시물 리스트뷰
    BoardAdapter adapter;
    ListView boardListItem; //게시물 레이아웃

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

        // board_list 리스트뷰 클릭이벤트
        lvBoard = (ListView) view.findViewById(R.id.lvBoard);
        lvBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Board data = list.get(i);
                vo = UserInfo.info;

                Log.d("vo1", vo.getUser_id());
                Log.d("data", data.getArticle_id());
                Log.d("data2", data.getArticle_content());
                Log.d("data3", String.valueOf(data.getArticle_seq()));

                Intent intentPost = new Intent(getActivity(), PostActivity.class);
                intentPost.putExtra("article_seq", data.getArticle_seq());
                startActivity(intentPost);
            }
        });


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

                                dto = new Board(seq, title, content, date, file, id, cnt);

                                BoardInfo.info = dto;

                                list.add(dto);

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