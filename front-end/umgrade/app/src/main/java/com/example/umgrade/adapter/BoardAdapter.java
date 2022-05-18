package com.example.umgrade.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umgrade.adapterInterface.OnBoardItemClickListener;
import com.example.umgrade.R;
import com.example.umgrade.vo.Board;

import java.util.ArrayList;

//어뎁터 클래스가 새로 정의한 리스너 인터페이스 구현하도록 함
public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> implements OnBoardItemClickListener {

    ArrayList<Board> items = new ArrayList<>();
    static OnBoardItemClickListener listener;

    //ViewHolder Start~
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView boardTitle;
        TextView boardNick;
        TextView boardSeq;
        TextView boardTime;

        public ViewHolder(View itemView) { // 뷰홀더 생성자로 전달되는 뷰 객체를 참조
            super(itemView);
            // 뷰 객체에 들어 있는 텍스트 뷰 참조
            boardTitle = itemView.findViewById(R.id.boardTitle);
            boardNick = itemView.findViewById(R.id.boardNick);
            boardSeq = itemView.findViewById(R.id.boardSeq);
            boardTime = itemView.findViewById(R.id.boardTime);



            itemView.setOnClickListener(new View.OnClickListener() { //아이템 뷰에 OnClickListener 설정
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position); //아이템 뷰 클릭 시 미리 정의한 다른 리스너의 메서드 호출!

                    }
                }
            });
        }

        public void setItem(Board item){
            boardTitle.setText(item.getArticle_title());
            boardNick.setText(item.getArticle_id());
            boardSeq.setText(String.valueOf(item.getArticle_seq()));
            boardTime.setText(item.getArticle_date());
        }

    }
    @Override //Override 하는 이유는 BoardAdapter는 onBoardItemClickListener를 implement하기 때문이다
    public void onItemClick(ViewHolder viewHolder, View view, int position) { // adapter 안에 있는 viewHolder,view, position을 외부에서 쓰기위함이다.
        if(listener != null) {
            listener.onItemClick(viewHolder, view, position);
        }
    }
    //ViewHolder end.

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.board_list, viewGroup, false); // 인플레이션을 통해 뷰 객체 만듬
        return new ViewHolder(itemView); //뷰 객체를 생성하면서 뷰 객체를 전달하고 그 뷰홀더 객체를 반환
    }
    //onBindViewHolder : 재활용 할 수 있는 객체를 파라미터로 전달
    // 뷰홀더에 현제 아이템에 맞는 데이터만 설정함
    //onBindViewHolder 메서드로 전달된 position 파라미터를 이용하여
    //ArrayList에서 Board 객체를 꺼내어 설정 할 수 있다!
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Board item = items.get(position);
        viewHolder.setItem(item);
    }

    //getItemCount 메서드 : ArrayList의 size 메서드를 호출하여 전체의 아이템이 몇개인지 확인한 후 값을 반환 한다.
    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnBoardItemClickListener {
        public void onItemClick(BoardAdapter.ViewHolder viewHolder, View view, int position);
    }

    public void setOnItemClickListener(OnBoardItemClickListener listener) { //외부 리스너를 설정 할 수 있도록 메서드를 추가함
        this.listener = listener;
    };


    public void addItem(Board item) {
        items.add(item);
    }

    public void setItems(ArrayList<Board> items) {
        this.items = items;
    }

    public Board getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Board item) {
        items.set(position, item);
    }
}
