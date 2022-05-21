package com.example.umgrade.community;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.umgrade.MoreActivity;
import com.example.umgrade.R;
import com.example.umgrade.adapter.BoardAdapter;
import com.example.umgrade.main.MainActivity;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class CommuActivity extends AppCompatActivity {

    BottomNavigationView bottomNavCommu;

    Button btnCmWrite; // 글작성 버튼

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

        bottomNavCommu = findViewById(R.id.bottomNavCommu);

        // 프래그먼트 전환
        bottomNavCommu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.fragMain){
                    Intent intent = new Intent(CommuActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragCommu){
                    Intent intent = new Intent(CommuActivity.this, CommuActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.fragMyPage){
//                    Intent intent = new Intent(CommuActivity.this, MainActivity.class);
//                    startActivity(intent);
                } else if (itemId == R.id.fragMore){
                    Intent intent = new Intent(CommuActivity.this, MoreActivity.class);
                    startActivity(intent);
                }

                return false;
            }
        }); // bottomNav end

    }
}