package com.example.appreadingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BookUserActivity extends AppCompatActivity {

    ImageButton IB_back;
    Button bt_home;
    Button bt_profile;
    Button bt_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_user);


        IB_back = (ImageButton) findViewById(R.id.imageButton);
        bt_home = (Button) findViewById(R.id.bt_home);
        bt_profile = (Button) findViewById(R.id.bt_profile);
        bt_category = (Button) findViewById(R.id.bt_category);




        IB_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookUserActivity.this, IntroductionUserActivity.class);
                startActivity(intent);
            }
        });
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookUserActivity.this, HomeUserActivity.class);
                startActivity(intent);
            }
        });
        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookUserActivity.this, ProfileUserActivity.class);
                startActivity(intent);
            }
        });
        bt_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookUserActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });



    }
}