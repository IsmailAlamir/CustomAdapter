package com.example.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PostsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Post> posts;
    private int resource ;
    public PostsAdapter(Context context,int resource , ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
        this.resource=resource;
    }

    public void addItem (Post post){
        this.posts.add(post);
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
        View view= convertView;
        if (view==null){
            view= LayoutInflater.from(context).inflate(resource,null,false);
        }
        TextView tv_date= view.findViewById(R.id.date);
        TextView tv_name=view.findViewById(R.id.tv_name);
        TextView tv_description=view.findViewById(R.id.description);
        TextView tv_following= view.findViewById(R.id.tv_following_data);
        TextView tv_followers=view.findViewById(R.id.tv_followers_data);
        TextView tv_posts=view.findViewById(R.id.tv_post_data);

        Post p= (Post) getItem(position);
        tv_date.setText(p.getDate());
        tv_followers.setText(p.getFollowers()+"");
        tv_name.setText(p.getName());
        tv_description.setText(p.getBody());
        tv_following.setText(p.getFollowing()+"");
        tv_posts.setText(p.getPosts()+"");
        return view;
    }
}
