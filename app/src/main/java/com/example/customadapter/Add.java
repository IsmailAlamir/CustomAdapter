package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Add extends AppCompatActivity {
    EditText et_username;
    EditText et_description;
    EditText et_date;
    EditText et_followers;
    EditText et_posts;
    EditText et_following;
    Button btn_add;
    static final String post_variable_name="post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_username = findViewById(R.id.add_et_username);
        et_description = findViewById(R.id.add_et_description);
        et_date = findViewById(R.id.add_et_date);
        et_followers = findViewById(R.id.add_et_followers);
        et_posts = findViewById(R.id.add_et_posts);
        et_following = findViewById(R.id.add_et_following);
        btn_add = findViewById(R.id.add_btn_add);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= et_username.getText().toString();
                String description= et_description.getText().toString();
                String date= et_date.getText().toString();
                int followers= Integer.parseInt(et_followers.getText().toString());
                int posts=Integer.parseInt(et_posts.getText().toString());
                int following=Integer.parseInt(et_following.getText().toString());

                Post post=new Post(date,username, description,followers,following,posts);

                Intent intent = new Intent();
                intent.putExtra(post_variable_name, post);
                setResult(1, intent);
                finish();

            }
        });
    }


}