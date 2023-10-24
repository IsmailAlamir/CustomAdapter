package com.example.customadapter;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
//                startActivityForResult(intent, REQ_CODE_ADD);
                activityResultLauncher.launch(intent);

            }


        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode==REQ_CODE_ADD ){
//            assert data != null;
//            Post p= (Post) data.getSerializableExtra(Add.post_variable_name);
//            adapter.addItem(p);
//            adapter.notifyDataSetChanged();
//        }
//    }
//

    ActivityResultLauncher<Intent> activityResultLauncher= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode()==Activity.RESULT_OK ) {
                                Intent data= result.getData();
                                assert data != null;
                                Post p = (Post) data.getSerializableExtra(Add.post_variable_name);
                                adapter.addItem(p);
                                adapter.notifyDataSetChanged();
                            }
                }
            }
    );




}