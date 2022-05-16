package com.example.umgrade;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.umgrade.holder.BoardHolder;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.vo.Board;

import java.util.ArrayList;

public class BoardAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<Board> list;
    LayoutInflater inflater;

    Board dto = BoardInfo.info;

    public BoardAdapter(Context context, int layout, ArrayList<Board> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BoardHolder holder = null;

        if (view == null) {
            view = inflater.inflate(layout, viewGroup, false);

            holder = new BoardHolder(view);

            view.setTag(holder);
        }

        else {
            holder = (BoardHolder) view.getTag();
        }

        dto = (Board) getItem(i);
        holder.getBoardTitle().setText(dto.getArticle_title());
        holder.getBoardNick().setText(dto.getArticle_id());
        holder.getBoardSeq().setText(String.valueOf(dto.getArticle_seq()));
        holder.getBoardTime().setText(dto.getArticle_date());

        Log.d("dto", dto.toString());

        return view;
    }
}
