package com.example.umgrade.holder;

import android.view.View;
import android.widget.TextView;

import com.example.umgrade.R;

public class ViewHolder {

    private TextView boardTitle;
    private TextView boardNick;
    private TextView boardSeq;
    private TextView boardTime;

    public ViewHolder(View itemview) {
        boardTitle = itemview.findViewById(R.id.boardTitle);
        boardNick = itemview.findViewById(R.id.boardNick);
        boardSeq = itemview.findViewById(R.id.boardSeq);
        boardTime = itemview.findViewById(R.id.boardTime);
    }

    public TextView getBoardTitle() {
        return boardTitle;
    }

    public TextView getBoardNick() {
        return boardNick;
    }

    public TextView getBoardSeq() { return boardSeq; }

    public TextView getBoardTime() {
        return boardTime;
    }
}
