package com.example.umgrade.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.MoreActivity;
import com.example.umgrade.R;
import com.example.umgrade.adapter.BoardAdapter;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CommuActivity extends AppCompatActivity {

    Button btnCmWrite; // 글작성 버튼
    Button navMain, navCommu, navMypage, navMore;
    RecyclerView recyclerView;
    BoardAdapter adapter = new BoardAdapter();
    ArrayList<Board> items = new ArrayList<>();
    RequestQueue queue;
    StringRequest request;

    User vo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commu);

        // 페이지 전환
        navMain = findViewById(R.id.navMain);
        navCommu = findViewById(R.id.navCommu);
        navMypage = findViewById(R.id.navMypage);
        navMore = findViewById(R.id.navMore);

<<<<<<< HEAD
        queue = Volley.newRequestQueue(CommuActivity.this);

        Intent intent = getIntent();
        int seq = intent.getIntExtra("seq", 0);

        initBoard();

        recyclerView = findViewById(R.id.lvborad);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CommuActivity.this, LinearLayoutManager.VERTICAL, false);

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

                Intent intent = new Intent(CommuActivity.this, PostActivity.class);
                intent.putExtra("article_seq", seq);
                intent.putExtra("article_title", title);
                intent.putExtra("article_content", content);
                intent.putExtra("article_id", nick);
                intent.putExtra("article_date", date);
                intent.putExtra("article_file", file);
                startActivity(intent);
                finish();
            }
        });
        recyclerView.setAdapter(adapter);


        btnCmWrite = findViewById(R.id.btnCmWrite);

        btnCmWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vo = UserInfo.info;
                Intent intent = new Intent(CommuActivity.this, WriteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 프래그먼트 전환
        bottomNavCommu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.fragMain) {
                    Intent intent = new Intent(CommuActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragCommu) {
                    Intent intent = new Intent(CommuActivity.this, CommuActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragMyPage) {
//                    Intent intent = new Intent(CommuActivity.this, MainActivity.class);
//                    startActivity(intent);
                } else if (itemId == R.id.fragMore) {
                    Intent intent = new Intent(CommuActivity.this, MoreActivity.class);
                    startActivity(intent);
                }

                return false;
=======
        navMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommuActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
>>>>>>> c2f3749a94efc31d0b38d05993831e7281fcfefc
            }
        });
        navMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommuActivity.this, MypageActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        navMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommuActivity.this, MoreActivity.class);
                startActivity(intent);overridePendingTransition(0, 0);
            }
        });


    }

    public void initBoard() {
        int method = Request.Method.GET;
        String server_url = "http://220.80.203.18:8081/myapp/BoardList.do";

        request = new StringRequest(
                method,
                server_url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(CommuActivity.this,
                                "게시판 불러오기 성공",
                                Toast.LENGTH_SHORT).show();
                        Log.d("asdf", response);
                        try {
                            JSONArray boardArray = new JSONArray(response);

                            for (int i = 0; i < boardArray.length(); i++) {
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
                        Toast.makeText(CommuActivity.this,
                                "게시판 불러오기 실패!" + error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        ); //end

        queue.add(request);
    }
}