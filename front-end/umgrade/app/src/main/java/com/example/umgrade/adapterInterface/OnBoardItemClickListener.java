package com.example.umgrade.adapterInterface;

import android.view.View;

import com.example.umgrade.adapter.BoardAdapter;

public interface OnBoardItemClickListener {
    public void onItemClick(BoardAdapter.ViewHolder viewHolder, View view, int position);

}
