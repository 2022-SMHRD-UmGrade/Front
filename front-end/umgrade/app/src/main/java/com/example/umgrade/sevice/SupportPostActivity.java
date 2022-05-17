package com.example.umgrade.sevice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.umgrade.R;

import org.w3c.dom.Text;

public class SupportPostActivity extends AppCompatActivity {
    
    TextView supportPostTitle, supportPostTime, supportPostCnt, tvSupportSet, supportPostSeq;
    Button btnSupportDelete;
    TextView supportPostContent, tvSupportPostComment;
    EditText edtSupportComment;
    Button btnSupportComment;
    View divSupportPost1, divSupportPost2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_post);
        
        supportPostTitle = findViewById(R.id.supportPostTitle); // 글제목
        supportPostTime = findViewById(R.id.supportPostTime); // 작성시각
        supportPostCnt = findViewById(R.id.supportPostCnt); // 조회수
        tvSupportSet = findViewById(R.id.tvSupportSet); // 처리 상태 여부
        supportPostSeq = findViewById(R.id.supportPostSeq); // 글번호(Seq)
        btnSupportDelete = findViewById(R.id.btnSupportDelete); // 글삭제
        supportPostContent = findViewById(R.id.supportPostContent); // 글 본문
        
        tvSupportPostComment = findViewById(R.id.tvSupportPostComment); // 문의 답변 출력
        edtSupportComment = findViewById(R.id.edtSupportComment); // 문의 답변 작성란
        btnSupportComment = findViewById(R.id.btnSupportComment); // 문의 답변 전송 버튼
        divSupportPost1 = findViewById(R.id.divSupportPost1); // 구분선
        divSupportPost2 = findViewById(R.id.divSupportPost2);

        // 관리자가 접속했을 때만 답변 작성란/전송 버튼 보이게
        String managerId = "manager"; // 관리자 아이디(임시)
        String userId = "manager"; // 사용자 아이디(임시)
        if(userId.equals(managerId)){
            edtSupportComment.setVisibility(View.VISIBLE);
            btnSupportComment.setVisibility(View.VISIBLE);
            divSupportPost1.setVisibility(View.VISIBLE);
            divSupportPost2.setVisibility(View.VISIBLE);
        }else{
            edtSupportComment.setVisibility(View.GONE);
            btnSupportComment.setVisibility(View.GONE);
            divSupportPost1.setVisibility(View.GONE);
            divSupportPost2.setVisibility(View.GONE);
        }

        // 전송 누르면 입력한 답변 출력
        btnSupportComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = edtSupportComment.getText().toString();
                tvSupportPostComment.setText(comment);
                edtSupportComment.setText(null); // 입력창 초기화

                // 답변이 있을 경우 처리 상태 변경
                // 답변 유무는 길이로 파악함
                String commentCnt = tvSupportPostComment.getText().toString(); // 답변 텍스트뷰 불러옴
                if(commentCnt.length()==0){
                    tvSupportSet.setText("처리중");
                    tvSupportSet.setTextColor(Color.BLACK);
                    tvSupportSet.setBackgroundResource(R.drawable.roundblack);
                } else {
                    tvSupportSet.setText("완료");
                    tvSupportSet.setTextColor(Color.WHITE);
                    tvSupportSet.setBackgroundResource(R.drawable.round);
                }
            }
        });

    }
}