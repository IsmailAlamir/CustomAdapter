package com.example.customadapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_add;
    final int REQ_CODE_ADD=1;
    PostsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv= findViewById(R.id.lv);
        ArrayList<Post> posts= new ArrayList<>();
//        posts.add(new Post("19 dec 1996", "Ismail Alamir", "software developer", 100, 12,34));
//        posts.add(new Post("26 jun 1996", "sanad Alamir", "lawyer ", 43, 132,64));

       adapter= new PostsAdapter(this,R.layout.activity_post_layout,posts);

       lv.setAdapter(adapter);
        btn_add =findViewById(R.id.main_btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Add.class);
                startActivityForResult(intent, REQ_CODE_ADD);

            }


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==REQ_CODE_ADD && requestCode==1){
            Post p= (Post) data.getSerializableExtra(Add.post_variable_name);
            adapter.addItem(p);
            adapter.notifyDataSetChanged();
        }
    }
}