package com.example.umgrade.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.umgrade.R;
import com.example.umgrade.adapterInterface.OnCommentListClickListener;
import com.example.umgrade.vo.Comment;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> implements OnCommentListClickListener {

    ArrayList<Comment> lists = new ArrayList<>();
    static OnCommentListClickListener listener;

    //viewHolder start ~
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvCommentNick;
        TextView tvCommentContent;
        TextView tvCommentTime;

        public ViewHolder(View listView) {
            super(listView);

            tvCommentNick = listView.findViewById(R.id.tvCommentNick);
            tvCommentContent = listView.findViewById(R.id.tvCommentContent);
            tvCommentTime = listView.findViewById(R.id.tvCommentTime);

            listView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if(listener != null) {
                        listener.onListClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Comment list) {
            tvCommentNick.setText(list.getCmt_id());
            tvCommentContent.setText(list.getCmt_content());
            tvCommentTime.setText(list.getCmt_date());
        }
    }

    @Override
    public void onListClick(ViewHolder viewHolder, View view, int position) {
        if(listener != null) {
            listener.onListClick(viewHolder, view, position);
        }
    }
    //viewHolder end.

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View listView = inflater.inflate(R.layout.comment_list, viewGroup, false);
        return new ViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Comment list = lists.get(position);
        viewHolder.setItem(list);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public interface onCommentListClickListener {
        public void onListClick(CommentAdapter.ViewHolder viewHolder, View view, int position);
    }

    public void setOnListClickListener(OnCommentListClickListener listener) {
        this.listener = listener;
    }

    public void addList(Comment list) {
        lists.add(list);
    }

    public void setLists(ArrayList<Comment> lists) {
        this.lists = lists;
    }

    public Comment getList(int position) {
        return lists.get(position);
    }

    public void setList(int position, Comment list) {
        lists.set(position, list);
    }
}
