package com.example.customadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class PostsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> posts;
    private int resource ;
    public PostsAdapter(Context context,int resource , ArrayList<String> posts) {
        this.context = context;
        this.posts = posts;
        this.resource=resource;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
