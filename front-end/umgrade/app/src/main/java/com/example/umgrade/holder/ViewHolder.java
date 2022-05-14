package com.example.umgrade.holder;

import android.view.View;
import android.widget.TextView;

import com.example.umgrade.R;

public class ViewHolder {

    private TextView boardTitle;
    private TextView boardNick;
    private TextView boardTime;

    public ViewHolder(View itemview) {
        boardTitle = itemview.findViewById(R.id.boardTitle);
        boardNick = itemview.findViewById(R.id.boardNick);
        boardTime = itemview.findViewById(R.id.boardTime);
    }

    public TextView getBoardTitle() {
        return boardTitle;
    }

    public TextView getBoardNick() {
        return boardNick;
    }

    public TextView getBoardTime() {
        return boardTime;
    }
}
