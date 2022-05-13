package com.example.umgrade;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.umgrade.holder.ViewHolder;
import com.example.umgrade.info.BoardInfo;
import com.example.umgrade.info.UserInfo;
import com.example.umgrade.vo.Board;
import com.example.umgrade.vo.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        ViewHolder holder = null;

        if (view == null) {
            view = inflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder(view);

            view.setTag(holder);
        }

        else {
            holder = (ViewHolder) view.getTag();
        }

        dto = (Board) getItem(i);
        holder.getBoardTitle().setText(dto.getArticle_title());
        holder.getBoardNick().setText(dto.getArticle_id());
        holder.getBoardTime().setText(dto.getArticle_date());

        return view;
    }
}
