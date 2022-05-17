package com.example.umgrade.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.Comment;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<Comment> list;
    LayoutInflater inflater;

    Board dto = BoardInfo.info;

    public CommentAdapter(Context context, int layout, ArrayList<Comment> list) {
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


        return view;
    }
}
