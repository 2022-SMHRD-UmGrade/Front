package com.example.umgrade.communityFrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CommuFragment extends Fragment {

    Button btnCmWrite; // 글작성 버튼

    RecyclerView recyclerView;
    BoardAdapter adapter = new BoardAdapter();
    ArrayList<Board> items = new ArrayList<>();
    RequestQueue queue;
    StringRequest request;

    User vo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commu, container, false);

        queue = Volley.newRequestQueue(getContext());

        initBoard();

        recyclerView = view.findViewById(R.id.lvborad);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(new BoardAdapter.OnBoardItemClickListener() {
            @Override
            public void onItemClick(BoardAdapter.ViewHolder viewHolder, View view, int position) {

                Board item = adapter.getItem(position);
                int seq = item.getArticle_seq();
                String title = item.getArticle_title();
                String content = item.getArticle_content();
                String nick = item.getArticle_id();
                String date = item.getArticle_date();
                String file = item.getArticle_file();

                Intent intent = new Intent(getContext(), PostActivity.class);
                intent.putExtra("article_seq", seq);
                intent.putExtra("article_title", title);
                intent.putExtra("article_content", content);
                intent.putExtra("article_id", nick);
                intent.putExtra("article_date", date);
                intent.putExtra("article_file", file);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);


        btnCmWrite = view.findViewById(R.id.btnCmWrite);

        btnCmWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vo = UserInfo.info;
                Intent intent = new Intent(getActivity(), WriteActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    //게시판 불러오는 메서드
    public void initBoard() {
        int method = Request.Method.GET;
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
                        Log.d("asdf", response);
                        try {
                            JSONArray boardArray = new JSONArray(response);

                            for(int i=0; i<boardArray.length(); i++) {
                                JSONObject Object = boardArray.getJSONObject(i);

                                int seq = Integer.parseInt(Object.getString("article_seq"));
                                String title = Object.getString("article_title");
                                String content = Object.getString("article_content");
                                String date = Object.getString("article_date");
                                String file = Object.getString("article_file");
                                String id = Object.getString("article_id");
                                int cnt = Integer.parseInt(Object.getString("article_cnt"));
                                Board item = new Board(seq, title, content, date, file, id, cnt);
                                items.add(item);

                            }
                            adapter.setItems(items);
                            adapter.notifyDataSetChanged();
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
    }
}