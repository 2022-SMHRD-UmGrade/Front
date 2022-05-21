package com.example.umgrade.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.umgrade.MoreActivity;
import com.example.umgrade.R;
import com.example.umgrade.adapter.BoardAdapter;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.userActivity.MypageActivity;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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

        navMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommuActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
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
}