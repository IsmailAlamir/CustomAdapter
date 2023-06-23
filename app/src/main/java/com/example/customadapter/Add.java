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
                String followers= et_followers.getText().toString();
                String posts= et_posts.getText().toString();
                String following= et_following.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("username", username);
                intent.putExtra("description", description);
                intent.putExtra("date", date);
                intent.putExtra("followers", followers);
                intent.putExtra("posts", posts);
                intent.putExtra("following", following);

                setResult(1, intent);
                finish();

            }
        });
    }


}