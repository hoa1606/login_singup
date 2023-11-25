package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryUserActivity extends AppCompatActivity {

    Button bt_home;
    Button bt_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_user);

        bt_home = (Button) findViewById(R.id.bt_home);
        bt_profile = (Button) findViewById(R.id.bt_profile);


        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryUserActivity.this, HomeUserActivity.class);
                startActivity(intent);
            }
        });
        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryUserActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });


    }
}