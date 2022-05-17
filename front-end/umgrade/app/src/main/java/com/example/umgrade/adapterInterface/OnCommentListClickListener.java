package com.example.umgrade.adapterInterface;

import android.view.View;

import com.example.umgrade.adapter.CommentAdapter;

public interface OnCommentListClickListener {
    void onListClick(CommentAdapter.ViewHolder viewHolder, View view, int position);
}
